/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/*
 * Robert Fink
 * CS3380
 */
public class RwfwcbSuperVisualizer implements Visualizer{
   
    private final String name = "Rwfwcb Visualizer";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
    private final Double bandWidthPercentage = .80;
    private final Double bandHeightPercentage = .9;
    private final Double minRectangleHeight = 10.0;
    
    private Double width = 0.0;
    private Double height = 0.0;
    private Double halfHeight = 0.0;
    
    private Double pctBandWidth = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private Double halfBandHeight = 0.0;
    
    private final Double startHue = 250.0;
    
    private Rectangle[] rectangles;
        
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        width = vizPane.getWidth();
        height = vizPane.getHeight();
        halfHeight = height / 2;
        
        Rectangle clip = new Rectangle(width, height);
        clip.setLayoutX(0);
        clip.setLayoutY(0);
        vizPane.setClip(clip);
        
        bandWidth = width / numBands;
        pctBandWidth = bandWidth * bandWidthPercentage;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        
        rectangles = new Rectangle[numBands];        
        
        for (int i = 0; i < numBands; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(bandWidth * i);
            rectangle.setY(halfHeight);
            rectangle.setHeight(minRectangleHeight);
            rectangle.setWidth(pctBandWidth);
            rectangle.setFill(Color.hsb(startHue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }
    }

    @Override
    public void end() {
        if (rectangles != null) {
             for (Rectangle rectangle : rectangles) {
                 vizPane.getChildren().remove(rectangle);
             }
            rectangles = null;
            vizPane.setClip(null);
            vizPane.setStyle("");
        } 
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (rectangles == null) {
            return;
        }
        
        Integer num = min(rectangles.length, magnitudes.length);
        Double hue = ((60.0 + magnitudes[0])/60.0) * 360;
        vizPane.setStyle("-fx-background-color: hsb(" + hue + ", 50%, 40%)" );
        
        for (int i = 0; i < num; i++) {
            rectangles[i].setHeight( ((60.0 + magnitudes[i])/60.0) * halfBandHeight + minRectangleHeight);
            rectangles[i].setFill(Color.hsb(startHue - (magnitudes[i] * -6.0), 1.0, 1.0, 1.0));
        }
    }   
}

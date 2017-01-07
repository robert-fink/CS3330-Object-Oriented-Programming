/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rwfwcblanguagebasics;

/**
 * Robert Fink
 * rwfwcb
 * CS3330
 * Java Language Basics
 */
public class RwfwcbLanguageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        byte sample1 = 0x3A;
        byte sample2 = 58;
        short heartRate = 85;
        long deposits = 135002796;
        float acceleration = 9.584f;
        float mass = 14.6f;
        double distance = 129.763001;
        boolean lost = true;
        boolean expensive = true;
        int choice = 1;
        char integral = '\u222B';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = new String("Hello");
        String name = new String("Karen");
        
        if (sample1 == sample2){
            System.out.println("The samples are equal");
        } else {
            System.out.println("The samples are not equal");
        }
        
        if (heartRate >=40 && heartRate<=80){
            System.out.println("Heart rate is normal");
        } else {
            System.out.println("Heart rate is not normal");
        }
        
        if (deposits >= 100000000){
            System.out.println("You are exceedingly wealthy");
        } else {
            System.out.println("Sorry you are so poor");
        }
        
        float force = mass * acceleration;
        System.out.println("force = " + force);
        
        System.out.println(distance + " is the distance");
        
        if (lost==true && expensive==true){
           System.out.println("I am really sorry! I will get the manager."); 
        } else if (lost==true && expensive==false){
            System.out.println("Heer is coupon for 10% off");
        }
        
        switch (choice){
            case 1: System.out.println("You chose 1.");
                    break;
            case 2: System.out.println("You chose 2.");
                    break;
            case 3: System.out.println("You chose 3.");
                    break;
            default: System.out.println("You made an unknown choice");
                    break;
        }
        
        System.out.println(integral + " is an integral");
        
        if (letter1 == letter2){
            System.out.println(letter1 + " and " + letter2 + " are the same.");
        } else if (letter1 != letter2){
            System.out.println(letter1 + " and " + letter2 + " are not the same.");   
        }
        
        for (int i=5; i<=10; ++i){
            System.out.println("i = " + i);
        }
        
        int age = 0;
        while (age < 6){
            System.out.println("age = " + age);
            age++;
        }
        
        System.out.println(greeting + " " + name);
     } 
}


package rwfwcbdocuments;

public class Document {
    private String title;
    private String author;
    private String body;
    private int version;
    
    public Document(String title, String author){
        this.version = 0;
        this.title = title;
        this.author = author;
    }
    
    public Document(String title, String author, String body){
        this.version = 1;
        this.title = title;
        this.author = author;
        this.body = body;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setBody(String body) {
        this.body = body;
    }
    
    public String getTitle() {
        return(title);
    }
    
    public String getAuthor() {
        return(author);
    }
    
    public String getBody() {
        return(body);
    }
    
    public int getVersion() {
        return(version);
    }
    
}

/*Robert Fink
 *rwfwcb
 *Documents
*/
package rwfwcbdocuments;

public class RwfwcbDocuments {

    public static void main(String[] args) {
        
        Document document1 = new Document("Another Life", "Sally Smith");
        
        document1.setBody("The grass is always greener on the other side");
        
        Document document2 = new Document("Final Word", "Karen Jones", "We should plan for the worst and hope for the best");
                
        document2.setTitle("Final Words");
        
        System.out.println("document1:");
        System.out.println("title: " + document1.getTitle());
        System.out.println("author:" + document1.getAuthor());
        System.out.println("body: " + document1.getBody());
        System.out.println("version: " + document1.getVersion());
        System.out.println("");
        System.out.println("document2:");
        System.out.println("title: " + document2.getTitle());
        System.out.println("author: " + document2.getAuthor());
        System.out.println("body: " + document2.getBody());
        System.out.println("version: " + document2.getVersion());
    }  
}

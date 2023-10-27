 abstract public class Ad {
    private String title;
    abstract String format();
     public Ad(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }
 }

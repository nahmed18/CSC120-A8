import java.util.Hashtable; 

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements {

    //Attribute 
    private Hashtable<String, Boolean> collection; 

    /**
     * Constructor for Library set up collection/hastable and call super to set up name, address, floors
     */
    public Library() {
      super("ZLibrary", "123 St", 10);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    //Methods 

    /**
     * Method to add a book to hashtable 
     * @param title - the book name to be added  
     */
    public void addTitle(String title) {
      collection.put(title, true);
    }

    /**
     * Method to remove book from hastable 
     * @param title - the book name to be removed 
     * @return title - book that has been removed 
     */
    public String removeTitle(String title) {
      collection.remove(title);
      return title;
    }

    /**
     * Method to check out a book/borrow it and mark it unavailable 
     * @param title - the name of the book 
     */
    public void checkOut(String title) {
      collection.replace(title, false);
    }
 
    /**
     * Return the book back to the library and mark it available 
     * @param title - the name of the book returned 
     */
    public void returnBook(String title) {
      collection.replace(title, true);
    }

    /**
     * Check if library contains a book 
     * @param title - the name of the book asked about 
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Check if the book is available i.e. not current checked out 
     * @param title - the name of the book 
     */
    public boolean isAvailable(String title) {
      return collection.containsKey(title) && collection.get(title) == true;
    }

    /**
     * Print the library's collection in a easy to read and organized way 
     */
    public void printCollection(){
      System.out.println("\nCollection:"); //title 
      if (collection.isEmpty()) { //if there is no collection 
        System.out.println("Collection is empty. :("); //print a message 
      } else { //if there are books in collection 
        for (String title : collection.keySet()) { 
          Boolean status = collection.get(title); //get the availability t/f 
          String availability; //set up availabliity as a string then check availablity through status 
          if (status == true) { //if book available print that 
            availability = "Available";
          } else { //book unavailable print that 
            availability = "Checked Out";
          }
          System.out.println(title + " - " + availability); //organize format
        }
      }
    }
    
  
    public static void main(String[] args) {
      Library ZLib = new Library(); //create new library 

      //create books 
      String b1 = "The Kite Runner";
      String b2 = "Divergent";
      String b3 = "Hunger Games";

      ZLib.printCollection(); //empty collection

      //add books 
      ZLib.addTitle(b1);
      ZLib.addTitle(b2);
      ZLib.addTitle(b3);

      ZLib.printCollection();

      //remove books 
      ZLib.removeTitle(b1);
      ZLib.removeTitle(b2);

      ZLib.printCollection();

      ZLib.checkOut(b3); //check out 
      ZLib.printCollection();

      ZLib.addTitle(b1); //add title to ensure b3 is still checked out 
      ZLib.printCollection();

      ZLib.returnBook(b3); //return book 
      ZLib.printCollection();

      //check if it returns t/f accurately 
      System.out.println(ZLib.containsTitle(b3));
      System.out.println(ZLib.containsTitle(b2));
      System.out.println(ZLib.isAvailable(b3));

    }
}

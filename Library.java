import java.util.Hashtable; 
import java.util.ArrayList;

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements {

    //Attributes 
    private Hashtable<String, Boolean> collection; 
    private boolean hasElevator;

    /**
     * Constructor for Library set up collection/hastable and call super to set up name, address, floors
     * @param name - name of the library 
     * @param address - the address of the library 
     * @param nFloors - the # of floors in the library   
     * @param hasElevator - t/f if there is an elevator 
     */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    
    /**
     * Overloaded library constructor - makes a default library, no elevator 
     * @param name - name of the library 
     * @param address - address of the library 
     */
    public Library(String name, String address) {
      super(name, address, 5);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true; 
      System.out.println("You have built the default library");
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
    * Overloaded - addTitles method allows you to add multiple titles to the collecion 
    * @param titles - the arraylist of titles to be added 
    */
    public void addTitle(ArrayList<String>titles) {
      for (String title : titles) {
        try {
          addTitle(title);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
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
     * @return - t/f if the name of the book is in the collection 
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Check if the book is available i.e. not current checked out 
     * @param title - the name of the book 
     * @return - t/f if the name of the book is in the collection and if it is available 
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

    /**
     * Overrided showOptions method - adds the methods in library with building methods 
     */
    @Override
    public void showOptions() {
      super.showOptions();
      System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
    }

    /**
   * Overrided goToFloor - allows someone to go to any floor using elevator not just adjacent floors 
   * @param floorNum - the floor they want to go to 
   */
    @Override
    public void goToFloor(int floorNum) {
      if (hasElevator) {
        super.goToFloor(floorNum);
      } else {
        System.out.println("There is no elevator use the stairs");
      }
    }
    
  
    public static void main(String[] args) {
      Library zLib = new Library("zLib", "narnia st", 100, false); //create new library 

      //create books 
      String b1 = "The Kite Runner";
      String b2 = "Divergent";
      String b3 = "Hunger Games";

      zLib.printCollection(); //empty collection

      //add books 
      zLib.addTitle(b1);
      zLib.addTitle(b2);
      zLib.addTitle(b3);

      zLib.printCollection();

      //remove books 
      zLib.removeTitle(b1);
      zLib.removeTitle(b2);

      zLib.printCollection();

      zLib.checkOut(b3); //check out 
      zLib.printCollection();

      zLib.addTitle(b1); //add title to ensure b3 is still checked out 
      zLib.printCollection();

      zLib.returnBook(b3); //return book 
      zLib.printCollection();

      //check if it returns t/f accurately 
      System.out.println(zLib.containsTitle(b3));
      System.out.println(zLib.containsTitle(b2));
      System.out.println(zLib.isAvailable(b3));

      System.out.println("test override show options");
      zLib.showOptions();

      zLib.enter();
      zLib.goToFloor(5);
      zLib.goToFloor(2);

      //Test default library 
      Library defaultLibrary = new Library("Default", "narnia ave"); 

      ArrayList<String> booksToAdd = new ArrayList<>();
        //booksToAdd.add("The Great Gatsby");
        //booksToAdd.add("To Kill a Mockingbird");
       // booksToAdd.add("1984");

       defaultLibrary.addTitle(booksToAdd); //test arraylist added
       defaultLibrary.printCollection();
    }
}

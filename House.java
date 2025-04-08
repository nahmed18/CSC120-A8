import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements{

  //Attributes
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for House sets up array list and checks if there's a dining room
   * @param hasDiningRoom - takes in a boolean t/f if there is a dining room
   * @param hasElevator - takes in a boolean t/f if there is an elevator 
   */
  public House(boolean hasDiningRoom, boolean hasElevator) {
    super("Ziskind", "elm st", 5);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  } 


  /**
   * Overloaded House constructor - creates a dummy house that has no dining room and elevator
   */
  public House() {
    super("Dummy House", "123 st", 1);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false; 
  }

  //Acessors:

  /**
   * Checks if there is a dining room in the house 
   * @return hasDiningRoom - t/f if there is a dining room 
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Get how many residents are in the house 
   * @return number of residents in the house 
   */
  public int nResidents(){
    return this.residents.size();
  }

  //Methods: 

  /**
   * Student moves in by adding student to the house 
   * @param s the student to be added to the class 
   */
  public void moveIn(Student s) {
    residents.add(s);
  }

 
  /**
   * Overloaded moveIn method - moves in student directly with a string of their name 
   * @param name - students name 
   */
  public void moveIn(String name) {
    Student s = new Student(name, "0000", 2028); // create a student with default values
    residents.add(s);
}

  /**
   * Student moves out by removing them from the house 
   * @param s student to be removed 
   * @return student 
   */
  public Student moveOut(Student s){
    residents.remove(s);
    return s;
  }

  /**
   * Check if the resident in the house 
   * @param s student to check
   * @return t/f if they are in the house 
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  }

  /**
     * Overrided showOptions method - adds the methods in house with building methods 
     */
  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(s) \n + moveOut(s) \n + isResident(s)");
  }

  /**
   * Overrided goToFloor - allows someone to go to any floor using elevator not just adjacent floors 
   * @param floorNum - the floor they want to go to 
   */
  @Override
  public void goToFloor(int floorNum) {
    if (hasElevator == true) {
      super.goToFloor(floorNum); 
    } else {
      System.out.println("There is no elevator use the stairs");
    }
  }


  public static void main(String[] args) {
    House NazHouse = new House(true, true);

    //create students 
    Student Ayesha = new Student("Ayesha", "1234", 2028);
    Student Lily = new Student("Lily", "1235", 2025);
    Student JJ = new Student("JJ", "1236", 2027);

    System.out.println(NazHouse.nResidents()); //check how many # of residents

    //add students to house 
    NazHouse.moveIn(Ayesha);
    NazHouse.moveIn(Lily);
    NazHouse.moveIn(JJ);

    System.out.println(NazHouse.nResidents()); //# of residents 

    System.out.println(NazHouse.isResident(Ayesha)); //check if returns true 

    //move out students 
    NazHouse.moveOut(Ayesha); 
    NazHouse.moveOut(JJ);

    System.out.println(NazHouse.nResidents()); //# of residents
    System.out.println(NazHouse.hasDiningRoom); //check if their is a dining room

    System.out.println("Test showOptions overide");
    NazHouse.showOptions();

    NazHouse.enter();
    NazHouse.goToFloor(3);

    NazHouse.moveIn("Ali");

    System.out.println(NazHouse.residents);

    

  }

}
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements{

  //Attributes
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;

  /**
   * Constructor for House sets up array list and checks if there's a dining room
   * @param hasDiningRoom - takes in a boolean t/f if there is a dining room
   */
  public House(boolean hasDiningRoom) {
    super("Ziskind", "elm st", 5);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
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

  public static void main(String[] args) {
    House NazHouse = new House(true);

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


  }

}
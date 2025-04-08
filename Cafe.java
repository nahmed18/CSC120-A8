public class Cafe extends Building implements CafeRequirements {

    //Attributes 
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /**
     * Constructor for Cafe sets up coffee oz, sugar, cream, and cups
     * @param nCoffeeOunces - # of oz coffee
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     * @param nCups - # of cups
     */
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super("Qawah House", "Yemeni St", 2);
        this.nCoffeeOunces = nCoffeeOunces; 
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams; 
        this.nCups = nCups;  
        System.out.println("You have built a cafe: ☕");
    }

 
    /**
     * Overloaded Cafe - default cafe created, set # of each inventory  
     */
    public Cafe () {
        super("Boring café", "idk st", 2);
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 5; 
        this.nCreams = 5;
        this.nCups = 10;
        System.out.println("You have built a default cafe.");
    }

    /**
     * Overloaded Cafe constructor - completely custom 
     * @param name - name of the cafe
     * @param address - address of the cafe
     * @param nFloors - # of floors 
     * @param nCoffeeOunces - # of coffe oz
     * @param nSugarPackets # of sugar packets 
     * @param nCreams - # of creams 
     * @param nCups- # of cups 
     */
    public Cafe (String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); 
        this.nCoffeeOunces = nCoffeeOunces; 
        this.nSugarPackets = nSugarPackets; 
        this.nCreams = nCreams; 
        this.nCups = nCups;  
        System.out.println("You have built a custom cafe");
    }



    //Methods 

    /**
     * Sell coffee by subtracting ingredients from inventory & restock if there's not enough
     * @param size - # of coffee oz
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     */
    public void sellCoffee(int size,  int nSugarPackets, int nCreams) {
        //Call restock in case there isn't enough in inventory
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(50, 20, 20, 50);
        }
        
        //Subtract the amount of inventory used 
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets; 
        this.nCreams -= nCreams; 
    }

    /**
     * Restock the inventory in case it runs out by adding more 
     * @param nCoffeeOunces - # of oz coffee
     * @param nSugarPackets - # of sugar packets
     * @param nCreams - # of splashes of cream
     * @param nCups - # of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces; 
        this.nSugarPackets += nSugarPackets; 
        this.nCreams += nCreams; 
        this.nCups += nCups; 
    }

    /**
     * Overrided showOptions method - adds the methods in cafe with building methods 
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarpackets, nCreams)");
    }

    /**
     * Overrided goToFloor doesn't allow customer to go beyond the 1st floor 
     * @param floorNum - the floor they want to go to 
     */
    @Override 
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1) {
            System.out.println("Only employees are permitted beyond the 1st floor.");
            this.activeFloor = 1; 
        } else {
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;
        }
    }

    
    
    public static void main(String[] args) {
        Cafe Qawah = new Cafe(10, 5, 5, 10); //create a new cafe 

        Qawah.sellCoffee(3, 4, 4); //test if it subtracts from inventory properly 
        System.out.println(Qawah.nCoffeeOunces);
        System.out.println(Qawah.nSugarPackets);
        System.out.println(Qawah.nCreams);

        Qawah.sellCoffee(6, 2, 0); //test if it restocks properly 
        System.out.println(Qawah.nCoffeeOunces);
        System.out.println(Qawah.nSugarPackets);
        System.out.println(Qawah.nCreams);

        System.out.println("override showOptions");
        Qawah.showOptions(); //check showoptions 

        //test you cannot go above floor 1
        Qawah.enter();
        Qawah.goToFloor(2);
        Qawah.goUp();
        System.out.println(Qawah.activeFloor);

        //test overloaded constructor default 
        Cafe Default = new Cafe(); 
        System.out.println(Default);

        //test completely custom cafe 
        Cafe Custom = new Cafe("OG CAFE", "555 ST", 4, 10, 10, 10, 10);
        System.out.println(Custom);
    }
}

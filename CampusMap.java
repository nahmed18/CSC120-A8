import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);

        //add 10 smith buildings:

        //add house - test default overloaded constructor 
        House Ziskind = new House("Bland House", "nothing st");
        myMap.addBuilding(Ziskind);

        //add library - test default overloaded constructor 
        Library Neilson = new Library("Blank Library", "open st"); 
        myMap.addBuilding(Neilson);

        //add cafe - test default overloaded constructor 
        Cafe CC = new Cafe("Bestie Cafe", "dubai st"); 
        myMap.addBuilding(CC);

        //other buildings
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConell Hall", "01063, 2 Tyler Ct, Northampton, MA 01060", 4 ));
        myMap.addBuilding(new Building("Seelye Hall", " 2 Seelye Dr #1, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Hatfield Hall", "3 Neilson Drive, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Campus Center", "100 Elm St, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Ziskind House", "1 Henshaw Ave, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Cutter House", "10 Prospect St, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Duckett House", "41 Elm St, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 Lower College Lane, Northampton, MA 01063", 4));

        System.out.println(myMap);
        
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
/**
 *
 * @author John
 */
public class Location {
    private String locationName;
    private String locationDescription;
    private String[] exits;
    
    public Location (String name, String description) {
        locationName = name;
        locationDescription = description;
        exits = new String[10];
    }
      
    public void addExit(String name, int direction) {
        exits[direction] = name;
    }
    public void removeExit (int direction) {
        exits[direction] = null;
    }
    public String[] getExits () {
        return exits;
    }
    public String getName() {
        return locationName;
    }
    public String getDescription() {
        return locationDescription;
    }
    public void setDescription(String description) {
        locationDescription = description;
    }
    public void setName(String name) {
        locationName = name;
    }
    // En ole vielä varma mihin laittaisin tämän metodin.
    public void startGame (Location gameArea[], int area) {
        TheGrimmAdventure.quit = false;
        System.out.println("Welcome to The Grimm Adventure.");
        while (!TheGrimmAdventure.quit) {
            System.out.println(gameArea[area].getName());
            System.out.println(gameArea[area].getDescription());
            gameArea[area].printExits();
            // Muista poistaa.
            TheGrimmAdventure.quit = true;
        }
    }
    public void printExits() {
        System.out.print("There are exits leading: ");
        for (int i=0; i<10;i++) {
            if (exits[i] != null) {
                System.out.print(Exit.directionName[i] + " ");
            }
        }
        System.out.println();
    }
}


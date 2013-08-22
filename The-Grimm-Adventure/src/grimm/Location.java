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
    
    /**
     * Alueen nimi.
     */
    private String locationName;
    /**
     * Alueen kuvaus.
     */
    private String locationDescription;
    /**
     * Alueen uloskäynnit.
     */
    private String[] exits;
    
    /**
     * Luo uuden alueen peliin.
     * 
     * @param name Alueelle annettu nimi
     * 
     * @param description Alueelle annettu kuvaus
     */
    public Location (String name, String description) {
        locationName = name;
        locationDescription = description;
        exits = new String[10];
    }
    
      /**
       * Lisää uloskäynnin alueeseen.
       * 
       * @param direction Lisättävän uloskäynnin suunta.
       * 
       * @param name Lisättävän uloskäynnin nimi.
       */
    public void addExit(String name, int direction) {
        exits[direction] = name;
    }
    
    /**
     * Poistaa uloskäynnin alueesta.
     * 
     * @param direction Poistettavan uloskäynnin suunta.
      */
    public void removeExit (int direction) {
        exits[direction] = null;
    }
    
    /**
     * Listaa alueen uloskäynnit.
     * 
     * @return Alueen uloskäynnit.
     */
    public String[] getExits () {
        return exits;
    }
    
    /**
     * Kertoo alueen nimen.
     * 
     * @return Alueen nimen.
     */
    public String getName() {
        return locationName;
    }
    
    /**
     * Kertoo alueen kuvauksen.
     * 
     * @return Alueen kuvaus.
     */
    public String getDescription() {
        return locationDescription;
    }
    
    /**
     * Määrittelee alueen kuvauksen.
     * 
     * @param description Alueen uusi kuvaus
     */
    public void setDescription(String description) {
        locationDescription = description;
    }
    
    /**
     *  Määrittelee alueen nimen.
     * 
     * @param name Alueen uusi nimi.
     */
    public void setName(String name) {
        locationName = name;
    }
    
    /**
     * Alkaa ajamaan peliä.
     * 
     * @param gameArea Pelin kaikki alueet.
     * @param area Aloitus alue.
     */
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
    
    /**
     * Tulostaa ruudulle alueen uloskäynnit.
     */
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


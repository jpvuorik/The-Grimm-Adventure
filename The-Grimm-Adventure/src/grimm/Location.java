/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

import java.util.ArrayList;

/**
 *Location-luokall luodaan ja käsitellään kaikkia pelin alueita. Alueet luodaan, niille annetaan nimi,
 *  käsiteltävät asiat ja uloskäynnit toisiin alueisiin.
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
     * Alueen uloskäynnit. Arvo on se game taulun lokero, johon uloskäynti vie.
     * Lokero kuvaa suuntaa, jossa uloskäynti on, ilmansuunnat numpadin mukaan, 0 ylös ja 5 alas.
     */
    private int[] exits;
    /**
     * Alueen manipuloitavat objektit
     */
    ArrayList<String> objects;
    /**
     * Luo uuden alueen peliin. Jos suunnassa ei ole uloskäyntiä, se saa arvon 10
     * 
     * @param name Alueelle annettu nimi
     * 
     * @param description Alueelle annettu kuvaus
     */
    public Location (String name, String description) {
        locationName = name;
        locationDescription = description;
        exits = new int[10];
        objects = new ArrayList();
        for (int i=0;i<10;i++) { exits[i]=10; }
    }
    
      /**
       * Lisää uloskäynnin alueeseen.
       * 
       * @param direction Lisättävän uloskäynnin suunta.
       * 
       * @param name Lisättävän uloskäynnin nimi.
       */
    public void addExit(int destination, int direction) {
        exits[direction] = destination;
    }
    
    /**
     * Poistaa uloskäynnin alueesta.
     * 
     * @param direction Poistettavan uloskäynnin suunta.
      */
    public void removeExit (int direction) {
        exits[direction] = 10;
    }
    
    /**
     * Listaa alueen uloskäynnit.
     * 
     * @return Alueen uloskäynnit.
     */
    public int[] getExits () {
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
     * Tulostaa ruudulle alueen uloskäynnit.
     */
    public void printExits() {
        System.out.print("There are exits leading: ");
        for (int i=0; i<10;i++) {
            if (exits[i] != 10) {
                System.out.print(Exit.directionName[i] + " ");
            }
        }
        System.out.println();
    }
   
    /**
     * Lisää alueeseen objektin.
     * 
     * @param name Objektin nimi.
     */
    public void addObject (String name) {       
        objects.add(name);
                    
        }
        
    /**
     * Palauttaa alueen objektit.
     * 
     * @return 
     */    
    public ArrayList<String> getObjects () {
        return objects;        
    }
    
    /**
     * Tarkistaa onko alueessa annetun nimistä objektia. Palauttaa true, jos on.
     * 
     * @param object Annettu nimi.
     * @return 
     */
    public boolean isObjectHere(String object) {
        if (objects.contains(object)) {
            return true;
        }
        return false;
    }
    
    /**
     * Poistaa alueesta valitun nimisen objektin.
     * 
     * @param name Poistettavan objektin nimi.
     */
    public void removeObject (String name) {
        objects.remove(name);
    }
}


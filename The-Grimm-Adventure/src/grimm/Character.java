/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

import java.util.ArrayList;

/**
 * Character luokassa on kaikki pelihahmo-olioita suoraan käsittelevät metodit.
 * Myös konstruktori, joka luo kyseiset olit (no vain yhden per peli).
 * 
 * @author John
 */
public class Character {
    
    /**
     * Hahmon nimi.
     */
    private String charName;
    
    /**
     * Hahmon kuvaus.
     */
    private String charDescription;
  
    /**
     * Hahmojen attribuuttien nimet ja suhteelliset sijainnit taulukossa.
     */
    
    private final String[] charAttributeNames =
    {
        "Athletics",
        "Size",
        "Smarts",
        "Bravery",
        "Brawn",
        "Charisma",
        "FableLore"  
    };
    
    /**
     * Onko hahmo saanut kyvyn puhua eläimille?
     */
    public static boolean animalFriend = false;
    
    /**
     * Hahmon attribuuttien arvot. True, jos vastaava charAttributeNames alkio
     * kuvaa hahmoa hyvin. False, jos on päinvastoin ja null muuten. Eli, jos
     * charAttribute[0] == true niin hahmo on urheilullinen, jos taas
     * charAttribute[6] == false niin hahmo ei tiedä juuri mitään saduista.
     */
    private int[] charAttributes;
    
    /**
     * Hahmon kannossa olevat esineet.
     */
    private ArrayList<String> inventory;
    
    /**
     * Luo hahmon peliin.
     * 
     * @param name      Hahmon nimi.
     * @param stats     Hahmon attribuutit.
     * @param items     Hahmon kannossa olevat esineet.
     */
    public Character (String name, int[] stats, ArrayList<String> items){
        charName = name;
        charAttributes = stats;
        inventory = items;
    }
    
    /**
     * Asettaa hahmon attribuutille annetun arvon.
     * 
     * @param stat      Valitun attribuutin sijainti taulukossa.
     * @param value     Valittu arvo attribuutille.
     */
    public void setAttribute (int stat, int value) {
        charAttributes[stat] = value;
    }
    
    /**
     * Lisää hahmon inventaarioon yhden esineen.
     * 
     * @param item Esine, joka lisätään inventaarioon.
     */
    public void addItem (String item) {
        inventory.add(item);
    }   
    
    /**
     * Palauttaa hahmon inventaarion.
     * 
     * @return Inventaariolista.
     */
    public ArrayList<String> getItems() {
        return inventory;
    }
    
    /**
     * Tarkistaa onko hahmon inventaariossa annettua esinettä.
     * 
     * @param item Annetun esineen nimi.
     * @return  Palauttaa true, jos on, false muuten.
     */
    public boolean checkInventory(String item) {
        if (inventory.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Metodi palauttaa hahmon nimen.
     * 
     * @return Hahmon nimi.
     */
    public String getName() {
        return charName;
    }
    
    /**
     * Kertoo hahmon vahvat ja heikot puolet.
     */
    public void describeAttributes() {
        System.out.println("Your characters strong points are:");
        for (int i =0;i<7;i++) {
            if (charAttributes[i]==3) {
                System.out.println(charAttributeNames[i]);
            }
        }
        System.out.println("Your characters weak points are:");
        for (int i =0;i<7;i++) {
            if (charAttributes[i]==1) {
                System.out.println(charAttributeNames[i]);
            }
        }
    }
    
    /**
     * Palauttaa hahmon attribuutit.
     * 
     * @return Hahmon attribuutit.
     */
    public int getAttributes(int index) {
        return charAttributes[index];
    }
    
    /**
     * Poistaa esineen hahmon inventaariosta
     * 
     * @param item Poistettavan esineen nimi.
     */
    public void removeItem(String item) {
        inventory.remove(item);
    }
}


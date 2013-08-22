/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

/**
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
        "Booksmarts",
        "Bravery",
        "Brawn",
        "Charisma",
        "FableLore"  
    };
    
    /**
     * Hahmon attribuuttien arvot. True, jos vastaava charAttributeNames alkio
     * kuvaa hahmoa hyvin. False, jos on päinvastoin ja null muuten. Eli, jos
     * charAttribute[0] == true niin hahmo on urheilullinen, jos taas
     * charAttribute[6] == false niin hahmo ei tiedä juuri mitään saduista.
     */
    private boolean[] charAttributes;
    
    /**
     * Hahmon kannossa olevat esineet.
     */
    private String[] inventory;
    
    /**
     * Luo hahmon peliin.
     * 
     * @param name      Hahmon nimi.
     * @param stats     Hahmon attribuutit.
     * @param items     Hahmon kannossa olevat esineet.
     */
    public Character (String name, boolean[] stats, String[] items){
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
    public void setAttribute (int stat, boolean value) {
        charAttributes[stat] = value;
    }
    
    /**
     * Lisää hahmon inventaarioon yhden esineen.
     * 
     * @param item Esine, joka lisätään inventaarioon.
     */
    public void setItem (String item) {
        for (int i =0; i <inventory.length;i++) {
            if (inventory[i]== null) {
                inventory[i]= item;
                i = inventory.length;
            }
        }
    }
    
    /**
     * Palauttaa hahmon inventaarion.
     * 
     * @return Inventaariolista.
     */
    public String[] getItems() {
        return inventory;
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
            if (charAttributes[i]) {
                System.out.println(charAttributeNames[i]);
            }
        }
        System.out.println("Your characters weak points are:");
        for (int i =0;i<7;i++) {
            if (!charAttributes[i]) {
                System.out.println(charAttributeNames[i]);
            }
        }
    }
    
    /**
     * Palauttaa hahmon attribuutit.
     * 
     * @return Hahmon attribuutit.
     */
    public boolean[] getAttributes() {
        return charAttributes;
    }
}


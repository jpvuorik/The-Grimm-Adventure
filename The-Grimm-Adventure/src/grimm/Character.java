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
    
    private String charName;
    private String charDescription;
    private String[] charAttributes;
    
    private boolean sportsmanship;
    private boolean brawn;
    private boolean booksmarts;
    private boolean storyLore;
    private boolean bravery;
    private boolean cowardice;
    private boolean overweight;
    private boolean charismatic;
    
    public Character (String name, String[] attributes){
        charName = name;
        charAttributes = attributes;
    }
}

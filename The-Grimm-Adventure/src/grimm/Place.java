/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
/**
 *
 * @author John
 */
public class Place {
    private String placeName;
    private String placeDescription;
    private String[] exits;
    
    public Place (String name, String description) {
        placeName = name;
        placeDescription = description;
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
        return placeName;
    }
    public String getDescription() {
        return placeDescription;
    }
    public void setDescription(String description) {
        placeDescription = description;
    }
    public void setName(String name) {
        placeName = name;
    }
}

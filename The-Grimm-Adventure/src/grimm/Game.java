/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author John
 */
public class Game {
    private Scanner scan = new Scanner(System.in);
    //private Command userInput;
    public static Location[] locations;
    public static int playerLocation;
    private ArrayList<String> items = new ArrayList();
    public static Character player;
    private String name;
    
    public Game(String characterName) {
        locations = new Location [10];
        name = characterName;
    }
    public void startGame() {
        createGameArea();
        createCharacter(name);
        while (!TheGrimmAdventure.quit && !TheGrimmAdventure.win) {
            System.out.println("\n"+locations[playerLocation].getDescription());
            //userInput = new Command();
            System.out.println(Command.checkCommand(scan.nextLine()));           
        }
    }
    
    public void createGameArea() {
        
        locations[0] = new Location("Lake","You are on a tiny raft floating in the middle of a lake.\n"
                + "A large fish keeps swimming around the raft in circles and\n"
                + "there is some rope with one end free on the raft.\n"
                + "The shore seems really far away except for some cliffs to the north.\n"
                + "You think you see a cave opening on the cliffside.");
        locations[0].addObject("WATER");
        locations[0].addObject("RAFT");
        locations[0].addObject("FREE FISH");
        locations[0].addObject("ROPE");
        locations[1] = new Location("Watery Cave", "You are in a cave with a waterway leading to the south.\n"
                + "To the east there seems to be a tunnel leading outside.");
        locations[1].addExit(0, 2);
        locations[1].addExit(2, 6);
        locations[1].addObject("SNAKE");
        locations[1].addObject("WALL");
        locations[1].addObject("STONE");
        locations[1].addObject("WATER");
        locations[2] = new Location("Hillside","You see a beautiful hillside stretching out infront of you.\n"
                + "To the west on the side of the hill there is a cave entrance and to the north\n" 
                + "there seems to be fields of some kind.");
        locations[2].addExit(1, 4);
        locations[2].addExit(3, 8);
        locations[2].addObject("BUSHES");
        locations[2].addObject("GROUND");
        locations[3] = new Location("Fields","You seem to bee in somekind of a farmers field.\n"
                + "There are some hills to the south.");
        locations[3].addExit(2, 2);
        locations[3].addObject("FIELD");
        locations[3].addObject("HEDGEHOG");
        locations[0].addObject("WELL");
        playerLocation = 0;
    }
    
    public void createCharacter(String name) {
        if (name.equals("Klaus")) {
            int[] attributes ={2,3,1,1,3,1,3};
            items.add("CLOTHES");
            items.add("CIGARETTES");
            items.add("LIGHTER");
            items.add("BASEBALL BAT");
            player = new Character(name,attributes,items);
        }
        if (name.equals("Albrecht")) {
            int[] attributes ={1,2,3,3,1,2,2};
            items.add("CLOTHES");
            items.add("SANDWICH");
            items.add("POCKET KNIFE");
            items.add("MAGNIFYING GLASS");
            player = new Character(name,attributes,items);
        }
        if (name.equals("Axel")) {
            int[] attributes ={3,1,2,2,2,3,1};
            items.add("CLOTHES");
            items.add("COMB");
            items.add("CELLPHONE");
            items.add("FRISBEE");
            player = new Character(name,attributes,items);
        }
    }
    public int currentLocation() {
        return playerLocation;
    }
    
    public Location[] gameBoard() {
        return locations;
    }
    
    public void changePlayerLocation(int direction) {
        playerLocation = direction;
    }
    public Character getPlayer() {
        return player;
    }
            
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *Game on se luokka, mikä määrittelee mitä alueita, hahmoja ja esineitä peliin luodaan. Siellä myös sijaitsee
 * pelin pää while-loop, joka jatkuu kunnes peli loppuu.
 * 
 * @author John
 */
public class Game {
    /**
     * Käyttäjän syöte.
     */
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Pelialue. Taulukon indeksit kuvaavat alueiden sijaintia.
     */
    public static Location[] locations;
    
    /**
     * Kertoo missä locations taulun indeksissä pelaaja tällä hetkellä on.
     */
    public static int playerLocation;
    
    /**
     * Hahmojen esineet.
     */
    private ArrayList<String> items = new ArrayList();
    
    /**
     * Pelaajahahmo.
     */
    public static Character player;
    
    /**
     * Pelaajahahmon nimi.
     */
    private String name;
    
    /**
     * Alustaa pelin.
     * 
     * @param characterName Valittu pelaajahahmo.
     */
    public Game(String characterName) {
        locations = new Location [10];
        name = characterName;
    }
    
    /**
     * Luo pelialueen createGameArea metodin kautta, luo pelaajahahmon createCharacter metodin kautta
     *  ja aloittaa pelin pää while-loopin.
     */
    public void startGame() {
        createGameArea();
        createCharacter(name);
        while (!TheGrimmAdventure.quit) {
            System.out.println("\n"+locations[playerLocation].getDescription());
            checkForEvent();
            System.out.println(Command.checkCommand(scan.nextLine()));           
        }
        if (TheGrimmAdventure.win) {
            System.out.println("Congratulations! You have won the game!");
        }
    }
    
    /**
     * Luo kaikki alueet, niiden objektit ja uĺoskäynnit. Määrittelee pelaajan aloitusalueen.
     */
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
        locations[1] = new Location("Cave", "You are in a cave with a waterway leading to the south.\n"
                + "The far wall is covered in darkness and you can't see a way out.");
        locations[1].addObject("DARK");
        locations[1].addObject("WALL");
        locations[1].addObject("STONE");
        locations[1].addObject("WATER");
        locations[2] = new Location("Hillside","You see a beautiful hillside stretching out infront of you.\n"
                + "To the west on the side of the hill there is a cave entrance and to the north\n" 
                + "there seems to be fields of some kind.");
        locations[2].addExit(Command.CAVE, Command.WEST);
        locations[2].addExit(Command.FIELDS, Command.NORTH);
        locations[2].addObject("BUSHES");
        locations[2].addObject("GROUND");
        locations[3] = new Location("Fields","You seem to be in a farmers field. "
                +"The field is filled with furrows and somekind of plants.\n"
                + "There's a hedgehog drinking brandy nearby and some hills to the south."
                + " There's also a well with a lid on it next to the fields.");
        locations[3].addExit(Command.HILLSIDE, Command.SOUTH);
        locations[3].addObject("FIELD");
        locations[3].addObject("HEDGEHOG");
        locations[3].addObject("CLOSED WELL");
        locations[3].addObject("LID");
        locations[3].addObject("FURROWS");
        locations[3].addObject("PLANT");
        playerLocation = Command.LAKE;
    }
    
    /**
     * Luo yhden kolmesta hahmosta. Määrittelee niiden attribuutit ja inventaarion.
     * 
     * @param name Valitun hahmon etunimi.
     */
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

    /**
     * Tarkistaa pitäisikö jotakin erikoista tapahtua. Esimerkiksi, onko hahmo niin fiksu, että tietää
     * tilanteesta enemmän kuin tyhmempi hahmo.
     */
    private void checkForEvent() {
        if (locations[playerLocation].isObjectHere("DARK") && player.getAttributes(Command.BRAVERY)==Command.BAD) {
            System.out.println("You shiver.");
        }
        if (locations[playerLocation].isObjectHere("SNAKE") && player.getAttributes(Command.FABLELORE)==Command.GOOD) {
            System.out.println("You remember the story of the magical snake that gives a person who eats "
                    + "it, the ability to talk to animals.");
        }
        if (playerLocation==Command.FIELDS && player.getAttributes(Command.FABLELORE)!=Command.BAD) {
            if (locations[Command.FIELDS].isObjectHere("FURROWS")){
                System.out.println("This looks just like the field from The Hare and The Hedgehog."
                        + "You see the hedgehog, but where's the hare?");
            }
        }
    }
            
}

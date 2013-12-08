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
     * Pelialue. Taulukon indeksit kuvaavat alueiden sijaintia.
     */
    public static Location[] locations;
    
    /**
     * Kertoo missä locations taulun indeksissä pelaaja tällä hetkellä on.
     */
    public static int playerLocation = 0;
    
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
        createGameArea();
        createCharacter(characterName);
        
        }
        
     /**
    * Metodi tulostaa näytölle valitun hahmon taustatarinan
    */
    public String choice(int input) {
        if (input == 1){
            return "\nYour name is Klaus Heinrich and you are 11 years old and you've lived your entire "
                + "life in the town of Buxtehude. Orphaned at a young age, you were raised by your grandmother. "
                + "She has always been nice to you, but losing your parents has made you jaded for your age. "
                + "Because you're big for your age, this has led to you becoming something of a school bully. "
                + "You're big, good in a fight and you've always loved the stories grandma tells you at night. "
                + "You're also not very good at studying and your childhood traumas have left you easily scared at times. "
                + "You always carry with you your cigarette lighter, a pack of cigarettes and a baseball bat. "
                + "You were walking back home from detention, taking a shortcut through the park, when suddenly "
                + "You heard a noise coming from the trees. You went to investigate and blacked out. You "
                + "are awakened by the sound of waves...\n";
        } 
        if (input == 2) {
            return "\nYour name is Albrecht Kleisner and you are 11 years old and from Buxtehude, Germany. "
                    + "Both of your parents are scientists and partly thanks to their influence and partly "
                    + "thanks to your own talents, you've always excelled at academic pursuits. You aren't "
                    + "in great shape and you're really bad in a fight, but you always stick up for what you "
                    + "believe in and have been in the boy scouts for a few years. You always carry with you "
                    + "lunch (a sandwich this time), a pocket knife given to you by your scout leader and a "
                    + "magnifying glass. You were walking back home from the library, going through the park "
                    + "like usual when suddenly you heard a noise coming from the trees. You went to investigate "
                    + "if someone was in trouble... and then blacked out. You are awakened by the sound of waves...\n";
        }
        if (input == 3) {
            return "\nYour name is Axel Brenner and you are a 11 year old child from the German town of"
                    + " Buxtehude. You're parents are poor and spend a lot of time working so you've"
                    + " spent most of your time playing with the neighborhood kids. You've always been"
                    + " physically gifted and a natural leader, so the other children look up to you,"
                    + " despite the fact that you're quite small for your age. Your love of sports and games"
                    + " has left little time for studying and you propably would've had to repeat a year"
                    + " if the teachers wouldn't like you so much. When you were 5 your parents bought you"
                    + " a frisbee for christmas, and since then it's been your favourite possession, even"
                    + " after they recently saved money and got you a cellphone. You also always carry a"
                    + " comb with you. You were returning home late after swimming a few laps at the pool"
                    + " one night, when, while jogging through the park, you heard a strange noice from"
                    + " the trees. You decided to investigate... and blacked out. Later, you are awakened"
                    + " by the sound of waves...";
        }
        return null;                    
    }
    
    /**
     * Luo kaikki alueet, niiden objektit ja uĺoskäynnit. Määrittelee pelaajan aloitusalueen.
     */
    public void createGameArea() {
        
        locations[0] = new Location("Lake","\nYou are on a tiny raft floating in the middle of a lake. "
                + "A large fish keeps swimming around the raft in circles and "
                + "there is some rope with one end free on the raft. "
                + "The shore seems really far away except for some cliffs to the north. "
                + "You think you see a cave opening on the cliffside.");
        locations[0].addObject("WATER");
        locations[0].addObject("RAFT");
        locations[0].addObject("FREE FISH");
        locations[0].addObject("ROPE");
        locations[1] = new Location("Cave", "\nYou are in a cave with a waterway leading to the south. "
                + "The far wall is covered in darkness and you can't see a way out.");
        locations[1].addObject("DARK");
        locations[1].addObject("WALL");
        locations[1].addObject("STONE");
        locations[1].addObject("WATER");
        locations[2] = new Location("Hillside","You see a beautiful hillside stretching out infront of you. "
                + "To the west on the side of the hill there is a cave entrance and to the north " 
                + "there seems to be fields of some kind.");
        locations[2].addExit(Command.CAVE, Command.WEST);
        locations[2].addExit(Command.FIELDS, Command.NORTH);
        locations[2].addObject("BUSHES");
        locations[2].addObject("GROUND");
        locations[3] = new Location("Fields","You seem to be in a farmers field. "
                +"The field is filled with furrows and somekind of plants. "
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
            items.add("KNIFE");
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
    public void checkForEvent() {
        if (locations[playerLocation].isObjectHere("DARK") && player.getAttributes(Command.BRAVERY)==Command.BAD) {
            RunGame.gameScreen.textArea.append("\nYou shiver.\n");
        }
        if (locations[playerLocation].isObjectHere("DEAD SNAKE") && player.getAttributes(Command.FABLELORE)==Command.GOOD) {
            RunGame.gameScreen.textArea.append("\nYou remember the story with the magical snake that gives a person who eats " 
                    +  "it, the ability to talk to animals.\n");          
        }
        if (playerLocation==Command.FIELDS && player.getAttributes(Command.FABLELORE)!=Command.BAD) {
            if (locations[Command.FIELDS].isObjectHere("FURROWS")){
                RunGame.gameScreen.textArea.append("\nThis looks just like the field from The Hare and The Hedgehog. " 
                    +  "You see the hedgehog, but where's the hare?\n");
            }
        }
    }
            
}

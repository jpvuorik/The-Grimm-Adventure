/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
/**
 *Command on luokka, joka käsittelee kaikkea käyttäjän antamaa tekstiä ja yrittää toteuttaa, mitä
 * hän haluaa tehdä. Tämän pelin parseri siis. Toteutus osittain kesken, pitäisi olla enemmän huomautuksia
 * epäonnistuneista toimista.
 * 
 * @author John
 */
public class Command {
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int UP = 0;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int SOUTHWEST = 1;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int SOUTH = 2;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int SOUTHEAST = 3;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int WEST  = 4;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int DOWN  = 5;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int EAST  = 6;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int NORTHWEST = 7;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int NORTH = 8;
    /**
     * Kuvastaa suunnan indeksiä mm. exits taulukossa. Koodin lukemisen helpoittamiseksi.
     */
    public static final int NORTHEAST = 9;
    
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int ATHLETICS = 0;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int SIZE = 1;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int SMARTS = 2;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int BRAVERY = 3;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int BRAWN = 4;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int CHARISMA = 5;
    /**
     * Pelaajan attribuuttien indeksien nimet koodin lukemisen helpoittamiseksi. Numerot kuvastavat sitä indeksiä
     * missä kyseinen attribuutti on hahmojen attribuuttitaulussa.
     */
    public static final int FABLELORE = 6;
        
    /**
     * Paikkojen sijaintien numeerisille arvoille nimet koodin lukemisen helpoittamiseksi. Numero on indeksi
     * missä paikka on pelin locations taulussa.
     */
    public static final int LAKE = 0;
    /**
     * Paikkojen sijaintien numeerisille arvoille nimet koodin lukemisen helpoittamiseksi. Numero on indeksi
     * missä paikka on pelin locations taulussa.
     */
    public static final int CAVE = 1;
    /**
     * Paikkojen sijaintien numeerisille arvoille nimet koodin lukemisen helpoittamiseksi. Numero on indeksi
     * missä paikka on pelin locations taulussa.
     */
    public static final int HILLSIDE = 2;
    /**
     * Paikkojen sijaintien numeerisille arvoille nimet koodin lukemisen helpoittamiseksi. Numero on indeksi
     * missä paikka on pelin locations taulussa.
     */
    public static final int FIELDS = 3;
    
    /**
     * Attribuuttien numeroarvoille intuitiiviset nimet koodin lukemisen helpoittamiseksi.
     */
    public static final int BAD = 1;
    /**
     * Attribuuttien numeroarvoille intuitiiviset nimet koodin lukemisen helpoittamiseksi.
     */
    public static final int AVERAGE = 2;
    /**
     * Attribuuttien numeroarvoille intuitiiviset nimet koodin lukemisen helpoittamiseksi.
     */
    public static final int GOOD = 3;
    
    /**
     * Suuntien nimet oikeassa järjestyksessä.
     */
    public static final String[] directionName = 
	{ 
            "UP",
            "SOUTHWEST",
            "SOUTH",
            "SOUTHEAST",
            "WEST",
            "DOWN",
            "EAST",
            "NORTHWEST",
            "NORTH",
            "NORTHEAST",
	};

    /**
     * Suuntien nimien lyhenteet oikeassa järjestyksessä.
     */
    public static final String[] shortDirectionName = 
	{
            "U",
            "SW",
            "S",
            "SE",
            "W",
            "D",                
            "E",
            "NW",
            "N",
            "NE",	
	};
    
    /**
     * Vastaus pelaajan syötteeseen.
     */
    private static String response;
    
    /**
     * Kuvaus paikasta, jota päivitetään sen mukaan kun asiat muuttuvat.
     */
    private static String description = "";
    
    /**
     * Cave lokaation kuvauksen perusosa, joka ei muutu. .
     */
    private static String cave = "You are in a cave with a waterway leading to the south.";
    
    /**
     * Kuvaus nälkäisestä käärmeestä. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String hungrySnake = "\nThere is a hungry white snake in the corner.";
    
    /**
     * Kuvaus syövästä käärmeestä. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String eatingSnake = "\nThere is a white snake eating a hare in the corner.";
    
    /**
     * Kuvaus kuolleesta käärmeestä. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String deadSnake = "\nThere is a dead snake on the cave floor.";
    
    /**
     * Kuvaus lautasta. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String raft = "\nThere is a raft on the waterway.";
    
    /**
     * Kuvaus lautasta, jossa on kala kiinni. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String raftFish = "\nThere is a raft on the waterway with a fish harnessed to it.";    
    
    /**
     * Kuvaus lautasta, jossa on köysi. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String raftRope = "\nThere is a raft on the waterway with some rope tied to it.";
    
    /**
     * Kuvaus luolan uloskäynnistä. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String caveExit = "\nThere's an exit to the east hidden in the shadows.";
    
    /**
     * Kuvaus luolan uloskäynnistä, kun sitä ei ole löydetty. Lisätään description Stringiin, jos on tarvetta.
     */
    private static String noCaveExit = "\nThe far wall is hidden in shadows and you see no exits.";
       
    /**
     * Ottaa vastaan pelaajan syötteen, lähettää sen kaikille muille Command luokan metodeille, jotka tarkistavat
     * mikä käsky se on.
     * 
     * @param command Pelaajan syöte.
     * @return  Vastaus syötteeseen.
     */    
    public static String checkCommand(String command) {
        response = "You cannot do that.";
        command = command.toUpperCase();
        build(command);
        cut(command);
        describe(command);
        dig(command);
        eatOrDrink(command);
        examine(command);
        feed(command);
        help(command);
        hit(command);
        inventory(command);
        move(command); 
        open(command);
        pickUp(command);
        pull(command);
        quit(command);
        search(command);
        smoke(command);
        talk(command);
        tie(command);
        throwItem(command);
        use(command);
        return response;
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja rakentaa jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void build(String userCommand) {
         if (userCommand.startsWith("BUILD") || userCommand.startsWith("MAKE")) {
             if (userCommand.contains("SAIL") && Game.player.getAttributes(SMARTS) == 3) {            
                response = "With a little ingenuity, you make sails out of your clothes for the raft. The wind"
                        + " blows your raft to the north into a cave.";
                Game.playerLocation = 1;
                Game.locations[LAKE].removeObject("RAFT");
                Game.locations[CAVE].addObject("RAFT");
                if (Game.locations[LAKE].isObjectHere("ROPE")) {
                    Game.locations[LAKE].removeObject("ROPE");
                    Game.locations[CAVE].addObject("ROPE");
                    description = noCaveExit + raftRope;
                    Game.locations[CAVE].setDescription(cave + description);
                } else {
                    description = noCaveExit + raft;
                    Game.locations[CAVE].setDescription(cave + description);}
            }
        }
     }
    
    /**
     * Tarkistaa yrittääkö pelaaja leikata jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void cut(String userCommand) {
         if (userCommand.startsWith("CUT") || userCommand.startsWith("USE")) {
             if (Game.player.checkInventory("KNIFE") && userCommand.contains("ROPE")) {            
                response = "You cut the rope free of the raft and take it with you.";
                Game.player.addItem("ROPE");
                Game.locations[Game.playerLocation].removeObject("ROPE");
                if (Game.playerLocation == CAVE) {
                    if (Game.locations[CAVE].isObjectHere("EXIT")){
                        description = caveExit;
                    } else { description = noCaveExit;}
                    description = description + raft;                    
                    Game.locations[CAVE].setDescription(cave + description);
                } else {
                    Game.locations[CAVE].setDescription("You are on a tiny raft floating in the middle of a lake. "
                + "A large fish keeps swimming around the raft in circles. "
                + "The shore seems really far away except for some cliffs to the north. "
                + "You think you see a cave opening on the cliffside.");
                }
            }
        }
     }
    
    /**
     * Tarkistaa yrittääkö pelaaja tarkastaa pelihahmon kykyjä.
     * 
     * @param userCommand Pelaajan syöte.
     */
    
    public static void describe(String userCommand) {
        if (userCommand.startsWith("DESCRIBE")) {
            response = "Your name is "+ Game.player.getName();
            Game.player.describeAttributes();
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja kaivaa jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    private static void dig(String command) {
        
    }

    /**
     * Tarkistaa yrittääkö pelaaja syödä tai juoda jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void eatOrDrink (String userCommand) {
        if (userCommand.startsWith("EAT") || userCommand.startsWith("CONSUME")) {
            if (userCommand.contains("SNAKE") && Game.player.checkInventory("DEAD SNAKE")) {
                response = "You take a bite out of the snake. It's pretty tasty."
                        + " Suddenly your mind is filled with strange information";
                Character.animalFriend =true;
            }
                
        }
        if (userCommand.startsWith("DRINK")) {
            if (userCommand.contains("WATER") && Game.locations[Game.playerLocation].isObjectHere("WATER")) {                
                        response = "You drink some water. It is refreshing.";
            }
        }   
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja tutkia jotain.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void examine (String userCommand) {
        boolean check = false;     
        if (userCommand.startsWith("EXAMINE") || userCommand.startsWith("SEARCH")) {
             if (Game.player.checkInventory("MAGNIFYING GLASS") && userCommand.contains("MAGNIFYING GLASS")) {
            check =true;
             }
        }
        if (userCommand.startsWith("USE") && userCommand.contains("MAGNIFYING GLASS")) {
            if (Game.player.checkInventory("MAGNIFYING GLASS")) {
               check =true;
             }
        }        
        if (userCommand.contains("WELL") || userCommand.contains("LID")) {
            if (Game.locations[FIELDS].isObjectHere("CLOSED WELL")) {
                if (check) {
                    response = "You start investigating the well using your magnifying glass. "
                            + "After some searching you find clear signs that people have been "
                            + "entering the well.";
                    Game.locations[FIELDS].removeObject("CLOSED WELL");
                    Game.locations[FIELDS].addObject("INTERESTING WELL");
                } 
            }
        }
    }
    /**
     * Tarkistaa yrittääkö pelaaja ruokkia jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void feed(String userCommand) {
        if (userCommand.startsWith("FEED") || userCommand.startsWith("GIVE")) {
            if (userCommand.contains("SNAKE") && Game.locations[Game.playerLocation].isObjectHere("HUNGRY SNAKE")) {
                if (userCommand.contains("HARE") && Game.player.checkInventory("HARE")) {
                    response = "You give the hare to the snake. It starts slowly eating it.";
                    Game.locations[Game.playerLocation].removeObject("HUNGRY SNAKE");
                    Game.locations[Game.playerLocation].addObject("WELL-FED SNAKE");
                    Game.player.removeItem("HARE");
                    description = "";
                    if (Game.locations[CAVE].isObjectHere("HARNESSED FISH")) {                        
                        description = caveExit + raftFish + eatingSnake;
                    }                       
                            Game.locations[CAVE].setDescription(cave + description);
                }                
            } else if (userCommand.contains("HEDGEHOG") || userCommand.contains("SNAKE")) {
                if (Game.playerLocation==FIELDS && Game.player.checkInventory("DEAD SNAKE")); {
                    if (Game.locations[FIELDS].isObjectHere("ANGRY HEDGEHOG")) {
                        response = "The hedgehog seems to be angry at you for some reason and viciously"
                                + " attacks you. You stumble back and hit your head on a rock. You die.";
                        TheGrimmAdventure.quit = true;
                    } else {
                    response = "You give the snake to the hedgehog. It starts slowly eating it.";
                    Game.locations[Game.playerLocation].removeObject("HEDGEHOG");
                    Game.locations[Game.playerLocation].addObject("HAPPY HEDGEHOG");
                    Game.player.removeItem("DEAD SNAKE");
                    Game.locations[FIELDS].setDescription("You seem to be in a farmers field. " 
                            + "The field is filled with furrows and somekind of plants. "
                            + "There's a hedgehog eating a snake nearby and some hills to the south."
                            + " There's also a well with a lid on it next to the fields.");
                    }  
                }        
            }            
        }
    }
    
    /**
     * Tarkistaa haluaako pelaaja tarkistaa komentoja.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void help(String userCommand) {
        if(userCommand.equals("HELP") || userCommand.equals("H")) {
            response = "Commands:\n quit: Leave the game\n"
                    + "inventory or i: Lists your inventory\n"
                    + "describe: Describes your character\n"
                    + "north or n: Walk north(same for other directions also in and out)\n"
                    + "Other commands: feed, use, swim, pick up, hit, give, search, tie, eat, drink, "
                    + "light, quit, talk, pull, jump, go, pull, dig, throw, examine";
        }
    }
        
    /**
     * Tarkistaa yrittääkö pelaaja lyödä jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
   public static void hit (String userCommand) {
        if (userCommand.startsWith("BEAT") || userCommand.startsWith("ATTACK") || userCommand.startsWith("HIT")) {
            if (userCommand.contains("FISH") && Game.locations[LAKE].isObjectHere("FREE FISH")) {
                if (userCommand.contains("BAT")) {
                    if (Game.player.checkInventory("BASEBALL BAT")) {
                        response = "You hit the fish with the bat, breaking the bat stunning the fish. It floats closer.";
                        Game.player.removeItem("BASEBALL BAT");
                        Game.locations[LAKE].removeObject("FREE FISH");
                        Game.locations[LAKE].addObject("STUNNED FISH");
                        Game.locations[LAKE].setDescription("You are on a tiny raft floating in the middle of a lake. "
                                + "A large fish is floating stunned next to the raft and there is some rope with one end free on "
                                + "the raft. The shore seems really far away except for some cliffs to the north and you "
                                + "think you see a cave opening on the cliffside.");
                    } else { response = "You do not have a bat.";}
                } else {response = "Your reach isn't long enough to attack the fish.";}
            } else if (userCommand.contains("SNAKE") && Game.locations[CAVE].isObjectHere("HUNGRY SNAKE")) {
                response = "That snake looks way too dangerous";
            } else if (userCommand.contains("SNAKE") && Game.locations[CAVE].isObjectHere("WELL-FED SNAKE")) {
                if (Game.player.getAttributes(BRAVERY)!=BAD && Game.player.getAttributes(BRAWN)==GOOD) {
                    response = "You expertly attack the distracted snake, killing it.";
                    description = "" + caveExit + raftFish + deadSnake;
                    Game.locations[CAVE].setDescription(cave + description);
                    Game.locations[CAVE].removeObject("WELL-FED SNAKE");
                    Game.locations[CAVE].addObject("DEAD SNAKE");
                }
                if(Game.player.getAttributes(BRAVERY)==BAD) {
                    response = "That's a real snake! You're too afraid of it to attack it.";
                }
                if (Game.player.getAttributes(FABLELORE)!=GOOD) 
                        { response = "You have no reason to attack the snake.";}                 
            }
        }           
   } 
   
   /**
     * Tarkistaa yrittääkö pelaaja tarkistaa inventaariotaan..
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void inventory (String userCommand) {
        if (userCommand.equals("INVENTORY") || userCommand.equals("I")) {
            String inv = "";
            for (String s:Game.player.getItems()) {
                inv = inv + s +"\n";
            }
            response = inv;
        }        
    }
    
   /**
     * Tarkistaa yrittääkö pelaaja liikkua jonnekin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void move(String userCommand) {
        for (int i=0;i<10;i++) {
            if(userCommand.equals(Exit.directionName[i]) || userCommand.equals(Exit.shortDirectionName[i])) {
                if(Game.locations[Game.playerLocation].getExits()[i]!=10) {
                    Game.playerLocation=Game.locations[Game.playerLocation].getExits()[i];
                    response = "";
                } else { response = "You cannot go into that direction."; }
            }
        }
        if (userCommand.startsWith("SWIM") && Game.playerLocation == LAKE) {
            if (userCommand.contains("NORTH") || userCommand.contains("CAVE")) {
                if (Game.player.getAttributes(ATHLETICS) == GOOD){
                    response = "You always liked swimming. You jump into the water and start swimming "
                            + "towards the cave in the north. After a few minutes of brisk swimming, you're there.";
                    Game.playerLocation = CAVE;
            } else if (Game.player.getAttributes(ATHLETICS) == AVERAGE){
                    response = "You jump into the water desperate to get to shore. You almost make it,"
                            +" but your strength gives in only meters away from shore. You die.";
                    TheGrimmAdventure.quit=true;
                } else {
                    response = "You jump into the water desperate to get to shore. Alas, you cannot swim."
                            + " You drown.";
                    TheGrimmAdventure.quit=true;
                }
            }            
        }
        if (userCommand.startsWith("GO") || userCommand.startsWith("JUMP")) {
             if (userCommand.contains("WELL") && Game.locations[Game.playerLocation].isObjectHere("OPEN WELL")) {
                 response = "You're scared, and the well is deep and dark, but it's getting late "
                         + "and you really want to go home. You close you're eyes and jump down into the well."
                         + " You fall and expect to hit the bottom at any moment, but it doesn't happen."
                         + " Suddenly you realize that you're not falling anymore. You open you're eyes "
                         + " and you see that you're in Buxtehude park. Home.";
                 TheGrimmAdventure.win =true;
                 TheGrimmAdventure.quit =true;
             }
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja avata jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void open(String userCommand) {
        if (userCommand.startsWith("OPEN") && userCommand.contains("WELL")) {
            if (Game.locations[Game.playerLocation].isObjectHere("CLOSED WELL")) {
                response = "The lid seems really heavy and the well really high."
                        + "You'd hate to go through that much trouble for no reason.";
            }
            if (Game.locations[Game.playerLocation].isObjectHere("INTERESTING WELL")) {
                if (Game.player.getAttributes(SIZE)!=1 && Game.player.getAttributes(BRAWN)!=1) {
                    response = "With a big effort you pull the lid off the well.";
                    Game.locations[FIELDS].removeObject("INTERESTING WELL");
                    Game.locations[FIELDS].addObject("OPEN WELL");
                    Game.locations[FIELDS].setDescription("You seem to be in a farmers field." 
                            + "The field is filled with furrows and somekind of plants."
                            + "There's a hedgehog eating a snake nearby and some hills to the south."
                            + " There's also an open well next to the fields.");
                } else if (userCommand.contains("STICK")){
                    response = "With some effort you pry open the lid with the stick";
                    Game.locations[FIELDS].removeObject("INTERESTING WELL");
                    Game.locations[FIELDS].addObject("OPEN WELL");
                    Game.locations[FIELDS].setDescription("You seem to be in a farmers field." 
                            + "The field is filled with furrows and some kinds of plants."
                            + "There's a hedgehog drinking brandy nearby and some hills to the south."
                            + " There's also an open well next to the fields.");                    
                } else {
                    response = "You're not big and strong enough to open the well bare handed.";
                }                    
            }
         }
    }            

    /**
     * Tarkistaa yrittääkö nostaa jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void pickUp (String userCommand) {
        if (userCommand.startsWith("TAKE") || userCommand.startsWith("PICK UP") || userCommand.startsWith("GET")) {
            if (userCommand.contains("PLANT") && Game.locations[Game.playerLocation].isObjectHere("PLANT")) {
                if (Game.player.getAttributes(BRAWN) !=BAD) {
                    response = "You pull out the plant from the field. It's a turnip.";
                    Game.player.addItem("TURNIP");
                    if (Game.locations[Game.playerLocation].isObjectHere("HEDGEHOG")) {
                        Game.locations[FIELDS].removeObject("HEDGEHOG");
                        Game.locations[FIELDS].addObject("ANGRY HEDGEHOG");
                        Game.locations[FIELDS].removeObject("PLANT");
                        Game.locations[FIELDS].addObject("TURNIP");
                    }
                } else { response = "You're too weak to pull out the plant.";}   
            }
            if (userCommand.contains("SNAKE")) {
                 if(Game.locations[Game.playerLocation].isObjectHere("WELL-FED SNAKE")) {
                     if (Game.player.getAttributes(BRAVERY) != BAD && Game.player.getAttributes(CHARISMA)==GOOD) {
                         response = "You gently pick up the snake and suddenly the snake speaks:\n"
                                 + "Thank you for feeding me, friend. As compensation I will gift you "
                                 + "with the ability to speak with animals";
                         Character.animalFriend = true;
                         Game.player.addItem("LIVE SNAKE");
                         Game.locations[CAVE].removeObject("WELL-FED SNAKE");                         
                     } else {response = "You're still too afraid to pick up the snake.";}
                 } else if (Game.locations[Game.playerLocation].isObjectHere("HUNGRY SNAKE")) {
                     response = "As you ponder on the wisdom of picking up a live snake, it attacks you."
                             + "You remember wondering previosly if the snake was venomous. Well now you know."
                             + "You die.";
                     TheGrimmAdventure.quit= true;
                 } if (Game.locations[CAVE].isObjectHere("DEAD SNAKE")) {
                Game.player.addItem("DEAD SNAKE");
                Game.locations[CAVE].removeObject("DEAD SNAKE");
                response = "You pick up the snake.";
                description = caveExit + raftFish;
                Game.locations[CAVE].setDescription(cave + description);
            }
            } 
            if (userCommand.contains("HEDGEHOG") && Game.playerLocation == FIELDS) {
                response = "The hedgehogs prickly spines pierce your flesh. You fail.";
            }
            if (userCommand.contains("STICK") && Game.locations[Game.playerLocation].isObjectHere("STICK")) {
                Game.locations[HILLSIDE].removeObject("STICK");
                Game.player.addItem("STICK");
                Game.locations[HILLSIDE].setDescription("You see a beautiful hillside stretching out infront of you. "
                        + "To the west on the side of the hill there is a cave entrance and to the north " 
                        + "there seems to be fields of some kind.");
                response = "You pick up the stick";
            }
        } 
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja vetää jotain.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void pull (String userCommand) {
        if (userCommand.startsWith("PULL") && userCommand.contains("ROPE")) {
            if (Game.locations[Game.playerLocation].isObjectHere("ROPE")) {
                if (Game.playerLocation== FIELDS) {
                    response = "After a lot of work you manage to pull of the lid to the well.";
                    Game.locations[FIELDS].removeObject("INTERESTING WELL");
                    Game.locations[FIELDS].addObject("OPEN WELL");
                    Game.locations[FIELDS].setDescription("You seem to be in a farmers field." 
                            + "The field is filled with furrows and some kinds of plants."
                            + "There's a hedgehog drinking brandy nearby and some hills to the south."
                            + " There's also an open well next to the fields.");
                } else {
                    response = "You pull on the rope achieving nothing.";
                }                                     
            }
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja lopettaa peliä.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void quit(String userCommand) {
        if (userCommand.equals("QUIT") || userCommand.equals("EXIT")) {
            TheGrimmAdventure.quit = true;
            response = "Goodbye.";
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja etsiä jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void search(String userCommand) {
        if (userCommand.startsWith("SEARCH") || userCommand.startsWith("LOOK")) {
            if (userCommand.contains("WALL") && Game.playerLocation == CAVE) {
                if (Game.locations[Game.playerLocation].isObjectHere("DARK") && Game.player.getAttributes(BRAVERY)==1) {
                    response = "It's too creepy. There could be something dangerous there";
                } else {
                    response = "After a few minutes of searching, you find an opening to the east.";
                    Game.locations[CAVE].addExit(HILLSIDE, EAST);
                    Game.locations[CAVE].addObject("EXIT");
                    description = caveExit;
                    if (Game.locations[CAVE].isObjectHere("HUNGRY SNAKE")) {
                        description = description + hungrySnake;
                    }
                    if (Game.locations[CAVE].isObjectHere("HARNESSED FISH")) {
                        description = description + raftFish;
                    } else if (Game.locations[CAVE].isObjectHere("ROPE")) {
                        description = description + raftRope;
                    } else if (Game.locations[CAVE].isObjectHere("RAFT")) {
                        description = description + raft;
                    }
                    Game.locations[CAVE].setDescription(cave + description);                      
                }
            }            
            if (userCommand.contains("FURROW") || userCommand.contains("FIELD")) {
                if (Game.player.getAttributes(FABLELORE) != BAD) {
                    response = "Remembering the fate of the hare in the story you search the furrows."
                            + " After some searching you find it's dead corpse.";
                    Game.player.addItem("HARE");
                    Game.locations[FIELDS].removeObject("FURROWS");
                }
            }
            if (userCommand.contains("WELL") || userCommand.contains("LID")) {
                if (!userCommand.contains("MAGNIFYING GLASS")) {
                    if (!Game.locations[Game.playerLocation].isObjectHere("OPEN WELL")) {
                        response = "The well is high and the lid is heavy.";
                    } else { response = "The well is very deep, you cannot see the bottom.";}     
                }
            }
        }
    }    
        
    /**
     * Tarkistaa yrittääkö pelaaja tupakoida.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void smoke(String userCommand) {
        if (userCommand.startsWith("SMOKE") && userCommand.contains("CIGARETTE")) {
            if (Game.player.checkInventory("CIGARETTES") && Game.player.checkInventory("LIGHTER")) {
                response = "Smoking the cigarette calms down your nerves, but you feel winded.";
                Game.player.setAttribute(ATHLETICS, BAD);
                Game.player.setAttribute(BRAVERY, AVERAGE);
            }
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja puhua jollekin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void talk(String userCommand) {
         if (userCommand.startsWith("TALK") && (Character.animalFriend)) {
             if (userCommand.contains("FREE FISH") && Game.locations[Game.playerLocation].isObjectHere("FREE FISH")) {            
                response = "Well met child, ";
                Game.player.describeAttributes();
            } else if (userCommand.contains("HEDGEHOG") && Game.playerLocation == FIELDS) {
                if (Game.locations[Game.playerLocation].isObjectHere("ANGRY HEDGEHOG")) {
                    response = "The hedgehog shouts: You thief! You stole my turnips!";
                }
                if (Game.locations[Game.playerLocation].isObjectHere("HEDGEHOG")) {
                    if (Game.player.getAttributes(CHARISMA)==BAD) {
                        response = "The hedgehog says: Please leave, you're ruining my good mood.";
                    } else {
                        response = "The hedgehog says: Stop bothering me. An exit? Try the well, for all I care";
                        Game.locations[FIELDS].removeObject("CLOSED WELL");
                        Game.locations[FIELDS].addObject("INTERESTING WELL");
                    }
                }
                if (Game.locations[Game.playerLocation].isObjectHere("HAPPY HEDGEHOG")) {
                    response = "The hedgehog says: Thank you for that delectable meal. Snake goes so well with brandy. "
                            +"Talking of wells, if you're looking for a way home, try the well.";
                    Game.locations[FIELDS].removeObject("CLOSED WELL");
                    Game.locations[FIELDS].addObject("INTERESTING WELL");
                }
            }
        }
     }
    
    /**
     * Tarkistaa yrittääkö heittää jotain.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void throwItem(String userCommand) {
        if (userCommand.startsWith("THROW") && userCommand.contains("FRISBEE")) {
            if(Game.playerLocation == LAKE) {
                response = "You throw the frisbee into the lake, then swim to it, retrieve it and swim"
                        + " back to the raft.";
            }
            if(Game.playerLocation == CAVE) {
                    response = "You decide not to throw the frisbee, it's not cool to throw frisbees in caves.";                    
            }
            if(Game.playerLocation == HILLSIDE && Game.locations[HILLSIDE].isObjectHere("BUSHES")) {
                    response = "You throw the frisbee into some bushes. When you go get it, you notice a stick "
                            + "there.";
                    Game.locations[HILLSIDE].addObject("STICK");
                    Game.locations[HILLSIDE].removeObject("BUSHES");
                    Game.locations[HILLSIDE].setDescription("You see a beautiful hillside stretching out infront of you. "
                        + "To the west on the side of the hill there is a cave entrance and to the north " 
                        + "there seems to be fields of some kind. There's a stick here.");
            }
            if(Game.playerLocation == FIELDS) {
                response = "You happily throw your frisbee in the open fields and into some furrows. You hear"
                        + " a strange thud and when you go to retrieve, you find a dead hare.\n"
                        + "You must have killed it! Shocked you pick up it's corpse.";
                Game.player.addItem("HARE");
            }
        }
    }
    /**
     * Tarkistaa yrittääkö pelaaja sitoa jotain.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void tie(String userCommand) {
        if (userCommand.startsWith("TIE")) {
            if (userCommand.contains("ROPE")) {
                if (userCommand.contains("FISH") && Game.locations[Game.playerLocation].isObjectHere("STUNNED FISH")) {
                    response = "You tie the end of the rope to the fish. After a while the fish comes out of "
                            + "it's stupor and tries to swim away. The raft starts speeding to the north "
                            + "and after a few hectic moments it comes to a stop inside a cave";
                    Game.locations[LAKE].removeObject("STUNNED FISH");
                    Game.locations[LAKE].removeObject("RAFT");
                    Game.locations[LAKE].removeObject("ROPE");
                    Game.playerLocation = CAVE;
                    Game.locations[CAVE].addObject("RAFT");
                    Game.locations[CAVE].addObject("HARNESSED FISH");
                    description = noCaveExit + raftFish;
                    Game.locations[CAVE].setDescription(cave + description);
                }
                if (userCommand.contains("WELL") || userCommand.contains("LID")) {
                        if (Game.locations[Game.playerLocation].isObjectHere("INTERESTING WELL") && Game.player.checkInventory("ROPE")) {
                            response = "With some difficulty you tie the rope to the lid of the well.";
                            Game.locations[FIELDS].setDescription("You seem to be in a farmers field." 
                                + " The field is filled with furrows and somekind of plants."
                                + " There's a hedgehog eating a snake nearby and some hills to the south."
                                + " There's also a well with a lid on it next to the fields."
                                + " The lid has a rope tied to it.");
                            Game.locations[FIELDS].addObject("ROPE");
                            Game.player.removeItem("ROPE");
                        }
                }
            }
        }
    }
    
    /**
     * Tarkistaa yrittääkö pelaaja käyttää jotakin.
     * 
     * @param userCommand Pelaajan syöte.
     */
    public static void use(String userCommand) {
        if (userCommand.startsWith("USE") || userCommand.startsWith("LIGHT") ) {
            if (Game.playerLocation == CAVE && Game.locations[CAVE].isObjectHere("DARK")) {
                if (userCommand.contains("LIGHTER") || userCommand.contains("CELLPHONE")) {
                    if (Game.player.checkInventory("LIGHTER") || Game.player.checkInventory("CELLPHONE")) {
                        response = "You light up the cave a bit. With the added light you can make out "
                                + "a white snake in the corner.";
                        Game.locations[Game.playerLocation].removeObject("DARK");
                        Game.locations[Game.playerLocation].addObject("HUNGRY SNAKE");
                        if (Game.locations[CAVE].isObjectHere("EXIT")) {
                            description = caveExit;
                        } else { description = noCaveExit;}
                            if (Game.locations[CAVE].isObjectHere("HARNESSED FISH")) { description = description + raftFish + hungrySnake;}
                        Game.locations[CAVE].setDescription(cave + description);                                                               
                        }
                    }
                }
            }
        }
}
    


        
        

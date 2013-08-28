/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
/**
 *
 * @author John
 */
public class Command {
    public static final int UP = 0;
    public static final int SOUTHWEST = 1;
    public static final int SOUTH = 2;
    public static final int SOUTHEAST = 3;
    public static final int WEST  = 4;
    public static final int DOWN  = 5;
    public static final int EAST  = 6;
    public static final int NORTHWEST = 7;
    public static final int NORTH = 8;
    public static final int NORTHEAST = 9;
        

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
    
    private static String response;
    
    public Command(String input) {
       
       System.out.println("RECEIVED INPUT:" +input);
        checkCommand(input);
    }
    
    
    public static String checkCommand(String command) {
        response = "?";
        command = command.toUpperCase();
        hit(command);
        search(command);
        move(command); 
        eatOrDrink(command);
        pickUp(command);
        quit(command);
        inventory(command);
        tie(command);
        return response;
    }
    
   public static void hit (String userCommand) {
        if (userCommand.startsWith("BEAT") || userCommand.startsWith("ATTACK") || userCommand.startsWith("HIT")) {
            if (userCommand.contains("FISH") && Game.locations[Game.playerLocation].isObjetHere("FREE FISH")) {
                if (userCommand.contains("BAT")) {
                    if (Game.player.checkInventory("BASEBALL BAT")) {
                        response = "You hit the fish with the bat, stunning it. It floats closer.";
                        Game.locations[Game.playerLocation].removeObject("FREE FISH");
                        Game.locations[Game.playerLocation].addObject("STUNNED FISH");
                        Game.locations[Game.playerLocation].setDescription("You are on a tiny raft floating in the middle of a lake.\n"
                                + "A large fish is floating stunned next to the raft and there is some rope with one end free on\n"
                                + "the raft. The shore seems really far away except for some cliffs to the north and you\n"
                                + "think you see a cave opening on the cliffside.");
                    } else { response = "You do not have a bat.";}
                } else {response = "Your reach isn't long enough to attack the fish.";}
            } else if (userCommand.contains("SNAKE") && Game.locations[Game.playerLocation].isObjetHere("SNAKE")) {                             
                if(Game.player.getAttributes()[3] ==1) {
                    response = "You do not have a bat.";
                }
            }
                    }           
   } 
    
    public static void move(String userCommand) {
        for (int i=0;i<10;i++) {
            if(userCommand.equals(Exit.directionName[i]) || userCommand.equals(Exit.shortDirectionName[i])) {
                if(Game.locations[Game.playerLocation].getExits()[i]!=10) {
                    Game.playerLocation=Game.locations[Game.playerLocation].getExits()[i];
                } else { response = "You cannot go into that direction."; }
            }
        }
        if (userCommand.startsWith("SWIM")) {
            
        }
    }
    
    public static void eatOrDrink (String userCommand) {
        if (userCommand.startsWith("EAT") || userCommand.startsWith("CONSUME")) {
            
        }
        if (userCommand.startsWith("DRINK")) {
            if (userCommand.contains("WATER") && Game.locations[Game.playerLocation].isObjetHere("WATER")) {                
                        response = "You drink some water. It is refreshing.";
                    }
                }   
            }            

    public static void pickUp (String userCommand) {
        if (userCommand.startsWith("TAKE") || userCommand.startsWith("PICK UP") || userCommand.startsWith("GET")) {
            
        }
    }
    
    public static void search(String userCommand) {
        if (userCommand.startsWith("SEARCH") || userCommand.startsWith("LOOK")) {
            
        }        
    }
    
    public static void quit(String userCommand) {
        if (userCommand.equals("QUIT") || userCommand.equals("EXIT")) {
            TheGrimmAdventure.quit = true;
            response = "Goodbye.";
        }
    }
    public static void inventory (String userCommand) {
        if (userCommand.equals("INVENTORY") || userCommand.equals("I")) {
            for (String s:Game.player.getItems()) {
                System.out.println(s);
            }
            response = "";
        }
        
    }
    public static void tie(String userCommand) {
        if (userCommand.startsWith("TIE")) {
            if (userCommand.contains("ROPE")) {
                if (userCommand.contains("FISH") && Game.locations[Game.playerLocation].isObjetHere("STUNNED FISH")) {
                    response = "You tie the end of the rope to the fish. After awhile the fish comes out of\n"
                            + "it's stupor and tries to swim away. The raft starts speeding to the north\n"
                            + "and after a few hectic moments it comes to a stop inside a cave";
                    Game.locations[Game.playerLocation].removeObject("STUNNED FISH");
                    Game.locations[Game.playerLocation].removeObject("RAFT");
                    Game.locations[Game.playerLocation].removeObject("ROPE");
                    Game.playerLocation = Game.playerLocation + 1;
                    Game.locations[Game.playerLocation].addObject("RAFT");
                    Game.locations[Game.playerLocation].addObject("HARNESSED FISH");
                    
                }
            }
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import grimm.Location;
import grimm.Character;
import grimm.Command;
import grimm.Game;
import grimm.TheGrimmAdventure;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author John
 */
public class GrimmTest {
    
    public GrimmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void characterCreationName() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");            
        helmut = new Character ("Helmut", attributes, inv);
        Assert.assertEquals(helmut.getName(), "Helmut");
    }
     
    @Test
    public void characterCreationInventory() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");
        helmut = new Character ("Helmut", attributes, inv);
        Assert.assertEquals(helmut.getItems().get(0), "pen");
    }
    
    @Test
    public void characterCreationAttributes() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");
        helmut = new Character ("Helmut", attributes, inv);
        Assert.assertEquals(helmut.getAttributes(0), 2);
    }
    
    @Test
    public void testAttributeSetting() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");
        helmut = new Character ("Helmut", attributes, inv);
        helmut.setAttribute(0, 1);
        Assert.assertEquals(helmut.getAttributes(0), 1);
    }
    
    @Test
    public void testInventorySetting() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");
        helmut = new Character ("Helmut", attributes, inv);
        helmut.addItem("lighter");
        Assert.assertEquals(helmut.getItems().get(0), "pen");
        Assert.assertEquals(helmut.getItems().get(1), "lighter");
    }
    
    @Test
    public void testAttributeDescribing() {
        Character helmut;
        int[] attributes ={2,3,1,1,3,1,3};
        ArrayList<String> inv = new ArrayList();
        inv.add("pen");
        helmut = new Character ("Helmut", attributes, inv);
        helmut.describeAttributes();
    }
      
    @Test
    public void constructorsNamingWorks() {
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        Assert.assertEquals(cave.getName(), "Cave");
    }
    @Test
    public void constructorsDescriptionWorks() {
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        Assert.assertEquals(cave.getDescription(), "You are in a cave.");
    }
    
    @Test
    public void constructTwoPlaces() {
        Location cave,mine;
        cave = new Location("Cave", "You are in a cave.");
        mine = new Location("Mine", "You are in a mine.");
        Assert.assertEquals(cave.getName(), "Cave");
        Assert.assertEquals(mine.getName(), "Mine");
        Assert.assertEquals(cave.getDescription(), "You are in a cave.");
        Assert.assertEquals(mine.getDescription(), "You are in a mine.");
    }
    
    @Test
    public void setNameWorks() {
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.setName ("Collapsed Cave");
        Assert.assertEquals(cave.getName(), "Collapsed Cave");
    }
    
    @Test
    public void setDescriptionWorks() {
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.setDescription("It's dark.");
        Assert.assertEquals(cave.getDescription(), "It's dark.");
    }
    
    @Test
    public void noExits() {
        int [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        testi = cave.getExits();
        for (int i=0;i<10;i++) {
            Assert.assertEquals(testi[i], 10);
        }
     }
    
    @Test
    public void oneExit() {
        int [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit (1, 5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], 1); 
        }
        
    @Test
    public void multipleExits() {
        int [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit (1, 5);
        cave.addExit (2, 1);
        cave.addExit (3, 9);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], 1); 
        Assert.assertEquals(testi[1], 2); 
        Assert.assertEquals(testi[9], 3); 
    }
    
    @Test
    public void removeOneExit() {
        int [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit (0, 5);
        cave.removeExit(5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], 10); 
        }

    @Test
    public void removeAllExits() {
        int [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit (0, 5);
        cave.addExit (1, 1);
        cave.addExit (2, 9);
        for (int i=0;i<10;i++) {
            cave.removeExit(i);
        }
        testi = cave.getExits();
        Assert.assertEquals(testi[1], 10);
        Assert.assertEquals(testi[5], 10);
        Assert.assertEquals(testi[9], 10);
    }
    
    @Test
    public void gameNamingTest() {
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Assert.assertEquals(Game.locations[0].getName(),"Lake");
    }
    
    @Test
    public void gameCharacterTest() {
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Assert.assertEquals(Game.player.getName(),"Klaus");
    }
    
    @Test
    public void gameWalkingTest() {
        String input = "NORTH";
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Game.locations[0].addExit(1, 8);
            Assert.assertEquals(Game.locations[Game.playerLocation].getName(),"Lake");
        Command.checkCommand(input);
        Assert.assertEquals(Game.locations[Game.playerLocation].getName(),"Cave");
    }
    
    @Test
    public void gameWalkingBlockedTest() {
        String input = "SOUTH";
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Game.locations[0].addExit(1, 8);
        Assert.assertEquals(Game.locations[Game.playerLocation].getName(),"Lake");
        Command.checkCommand(input);
        Assert.assertEquals(Game.locations[Game.playerLocation].getName(),"Lake");
    }
    
    @Test
    public void parserTest() {
        String input = "HIT FISH WITH BAT";
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Game.locations[0].addExit(1, 8);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("FREE FISH"), true);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("STUNNED FISH"), false);
        Command.checkCommand(input);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("FREE FISH"), false);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("STUNNED FISH"), true);    
    }
    
    @Test
    public void parserSmallLettersTest() {
        String input = "hit fish with bat";
        Game testGrimm = new Game("Klaus");
        testGrimm.createGameArea();
        testGrimm.createCharacter("Klaus");
        Game.locations[0].addExit(1, 8);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("FREE FISH"), true);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("STUNNED FISH"), false);
        Command.checkCommand(input);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("FREE FISH"), false);
        Assert.assertEquals(Game.locations[Game.playerLocation].isObjectHere("STUNNED FISH"), true);    
    }
}
    
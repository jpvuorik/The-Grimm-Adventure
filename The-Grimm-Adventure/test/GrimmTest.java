/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import grimm.Location;
import grimm.Character;
import grimm.TheGrimmAdventure;
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
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = new String[10];
        inv[0] ="pen";            
        helmut = new Character ("Helmut", attr, inv);
        Assert.assertEquals(helmut.getName(), "Helmut");
    }
     
    @Test
    public void characterCreationInventory() {
        Character helmut;
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = new String[10];
        inv[0] ="pen";            
        helmut = new Character ("Helmut", attr, inv);
        Assert.assertEquals(helmut.getItems()[0], "pen");
    }
    
    @Test
    public void characterCreationAttributes() {
        Character helmut;
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = new String[10];
        inv[0] ="pen";            
        helmut = new Character ("Helmut", attr, inv);
        Assert.assertEquals(helmut.getAttributes()[0], true);
    }
    
    @Test
    public void testAttributeSetting() {
        Character helmut;
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = new String[10];
        inv[0] ="pen";            
        helmut = new Character ("Helmut", attr, inv);
        helmut.setAttribute(0, false);
        Assert.assertEquals(helmut.getAttributes()[0], false);
    }
    
    @Test
    public void testInventorySetting() {
        Character helmut;
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = new String[10];
        inv[0] ="pen";
        helmut = new Character ("Helmut", attr, inv);
        helmut.setItem("lighter");
        Assert.assertEquals(helmut.getItems()[0], "pen");
        Assert.assertEquals(helmut.getItems()[1], "lighter");
    }
    
    @Test
    public void testAttributeDescribing() {
        Character helmut;
        boolean [] attr =  {true,false,true,true,true,true,true}; 
        String [] inv = {"pen"};            
        helmut = new Character ("Helmut", attr, inv);
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
        String [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        testi = cave.getExits();
        for (int i=0;i<10;i++) {
            Assert.assertEquals(testi[i], null);
        }
     }
    
    @Test
    public void oneExit() {
        String [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], "Mine"); 
        }
        
    @Test
    public void multipleExits() {
        String [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        cave.addExit ("Cave Entrance", 1);
        cave.addExit ("Dead-end", 9);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], "Mine"); 
        Assert.assertEquals(testi[1], "Cave Entrance"); 
        Assert.assertEquals(testi[9], "Dead-end"); 
    }
    
    @Test
    public void removeOneExit() {
        String [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        cave.removeExit(5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], null); 
        }

    @Test
    public void removeAllExits() {
        String [] testi;
        Location cave;
        cave = new Location("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        cave.addExit ("Cave Entrance", 1);
        cave.addExit ("Dead-end", 9);
        for (int i=0;i<10;i++) {
            cave.removeExit(i);
        }
        testi = cave.getExits();
        Assert.assertEquals(testi[1], null);
        Assert.assertEquals(testi[5], null);
        Assert.assertEquals(testi[9], null);
    }
    
    @Test
    public void testMain() {
        System.out.println("testMain");
        String[] test;
        test = new String[3];
        TheGrimmAdventure.main(test);
        System.out.println();
    }
    
    @Test
    public void testStartGame() {
        System.out.println("testStartGame");
        Location[] testGame;
        testGame = new Location [20];
        testGame[0] = new Location ("Old Woods", "You are at the entrance of an ancient forest.");
        testGame[0].addExit("Tall Tree", 0);
        testGame[1] = new Location ("Tall Tree", "You are in a tree.");
        testGame[1].addExit("Old Woods", 5);
        testGame[1].startGame(testGame, 1);
        String[] testi;
        testi = testGame[1].getExits();
        Assert.assertEquals(testi[5], "Old Woods");
        testi = testGame[0].getExits();
        Assert.assertEquals(testi[0], "Tall Tree");
        System.out.println();
    }
    
    @Test
    public void printExitsTest() {
        System.out.println("printExitsTest");
        Location[] testGame;
        testGame = new Location [20];
        testGame[0] = new Location ("Old Woods", "You are at the entrance of an ancient forest.");
        testGame[0].addExit("Tall Tree", 0);
        testGame[0].addExit("Forest Road", 8);
        testGame[1] = new Location ("Tall Tree", "You are in a tree.");
        testGame[1].addExit("Old Woods", 5);
        testGame[0].printExits();
        testGame[1].printExits();
        System.out.println();
    }
}
    
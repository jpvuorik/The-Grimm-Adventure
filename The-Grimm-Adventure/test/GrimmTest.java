/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import grimm.Place;
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
    public void constructorsNamingWorks() {
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        Assert.assertEquals(cave.getName(), "Cave");
    }
    @Test
    public void constructorsDescriptionWorks() {
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        Assert.assertEquals(cave.getDescription(), "You are in a cave.");
    }
    
    @Test
    public void constructTwoPlaces() {
        Place cave,mine;
        cave = new Place("Cave", "You are in a cave.");
        mine = new Place("Mine", "You are in a mine.");
        Assert.assertEquals(cave.getName(), "Cave");
        Assert.assertEquals(mine.getName(), "Mine");
        Assert.assertEquals(cave.getDescription(), "You are in a cave.");
        Assert.assertEquals(mine.getDescription(), "You are in a mine.");
    }
    
    @Test
    public void setNameWorks() {
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        cave.setName ("Collapsed Cave");
        Assert.assertEquals(cave.getName(), "Collapsed Cave");
    }
    
    @Test
    public void setDescriptionWorks() {
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        cave.setDescription("It's dark.");
        Assert.assertEquals(cave.getDescription(), "It's dark.");
    }
    
    @Test
    public void noExits() {
        String [] testi;
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        testi = cave.getExits();
        for (int i=0;i<10;i++) {
            Assert.assertEquals(testi[i], null);
        }
     }
    
    @Test
    public void oneExit() {
        String [] testi;
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], "Mine"); 
        }
        
    @Test
    public void multipleExits() {
        String [] testi;
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
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
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
        cave.addExit ("Mine", 5);
        cave.removeExit(5);
        testi = cave.getExits();
        Assert.assertEquals(testi[5], null); 
        }

    @Test
    public void removeAllExits() {
        String [] testi;
        Place cave;
        cave = new Place("Cave", "You are in a cave.");
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
    
}
    
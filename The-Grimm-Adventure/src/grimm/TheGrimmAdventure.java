/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

/**
 *
 * @author John
 */
public class TheGrimmAdventure {
    public static boolean quit;
    public static boolean win;
    
    static Location[] game;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        game = new Location[20];
        game[0] = new Location ("Old Woods", "You are at the entrance of an ancient forest.");
        game[0].addExit("Tall Tree", 0);
        game[0].startGame(game, 0);
        
    }
}

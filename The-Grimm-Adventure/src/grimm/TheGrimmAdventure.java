/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
import java.util.Scanner;

/**
 *
 * @author John
 */
public class TheGrimmAdventure {
    public static boolean quit;
    public static boolean win;
    private static String choice;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner start = new Scanner(System.in);
        Game grimm = null;
        System.out.println("Choose your character:\n (1) Klaus \n (2) Jürgen \n (3) Hans");
        choice = start.nextLine();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){ 
            System.out.println("Choose 1, 2 or 3");
            choice = start.nextLine();
            }            
        if (choice.equals("1")) {
                klausStory();
                grimm = new Game("Klaus");
        }
        if (choice.equals("2")) {
                grimm = new Game("Albrecht");
            }   
        if (choice.equals("3")) {
            grimm = new Game("Axel");
        }
        grimm.startGame();
        /*
        game = new Location[20];
        game[0] = new Location ("Old Woods", "You are at the entrance of an ancient forest.");
        game[0].addExit("Tall Tree", 0);
        game[0].startGame(game, 0);
        */
    }

    private static void klausStory() {
        System.out.println("Your name is Klaus Heinrich and you are 11 years old and you've lived your entire\n"
                + "life in the town of Buxtehude. Orphaned at a young age, you were raised by your grandmother.\n"
                + "She has always been nice to you, but losing your parents has made you jaded for your age.\n"
                + "Because you're big for your age, this has led to you becoming something of a school bully.\n"
                + "You're big, good in a fight and you've always loved the stories grandma tells you at night.\n"
                + "You're also not very good at studying and you're childhood traumas have left you easily scared at times.\n"
                + "You always carry with you your cigarette lighter, a pack of cigarettes and a baseball bat.");
    }
}

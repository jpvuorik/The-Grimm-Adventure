/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;
import java.util.Scanner;

/**
 * Käynnistää pelin, sisältää hahmojen valitsemisen ja taustatarinan. Vain Klausin taustatarina valmis ja
 * vain Klausilla voi pelata pelin läpi. Albrechtilla ja Axelilla voi edetä jonkin verran, mutta Albrechtilla
 * ei varsinkaan ole hirveästi sisältöä.
 *
 * @author John
 */
public class TheGrimmAdventure {
    /**
     * Niinkauan kuin quit on totta, peli jatkuu.
     */
    public static boolean quit;
    
    /**
     * Onko pelaaja voittanut?
     */
    public static boolean win;
    
    /**
     * Pelaajan valitsema hahmo.
     */
    private static String choice;
    
    /**
     * Laittaa käyttäjän valitsemaan pelattavan hahmon ja aloittaa pelin.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner start = new Scanner(System.in);
        Game grimm = null;
        System.out.println("Choose your character:\n (1) Klaus \n (2) Albrecht \n (3) Axel");
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
            albrechtStory();
            grimm = new Game("Albrecht");
            }   
        if (choice.equals("3")) {
            axelStory();
            grimm = new Game("Axel");
        }
        grimm.startGame();        
    }
    
    /**
    * Metodi tulostaa näytölle Klaus Heinrichin taustatarinan
    */
    private static void klausStory() {
        System.out.println("Your name is Klaus Heinrich and you are 11 years old and you've lived your entire\n"
                + "life in the town of Buxtehude. Orphaned at a young age, you were raised by your grandmother.\n"
                + "She has always been nice to you, but losing your parents has made you jaded for your age.\n"
                + "Because you're big for your age, this has led to you becoming something of a school bully.\n"
                + "You're big, good in a fight and you've always loved the stories grandma tells you at night.\n"
                + "You're also not very good at studying and your childhood traumas have left you easily scared at times.\n"
                + "You always carry with you your cigarette lighter, a pack of cigarettes and a baseball bat.\n"
                + "You were walking back home from detention, taking a shortcut through the park, when suddenly\n"
                + "You heard a noise coming from the trees. You went to investigate and blacked out. You \n"
                + "are awakened by the sound of waves...");
    }
    
    /**
    * Metodi tulostaa näytölle Albrecht Kleisnerin taustatarinan.
    */
    private static void albrechtStory() {
        System.out.println("Your name is Albrecht Kleisner");
    }
    
    /**
    * Metodi tulostaa näytölle Axel Brennerin taustatarinan.
    */
    private static void axelStory() {
        System.out.println("Your name is Axel Brenner");
    }
}

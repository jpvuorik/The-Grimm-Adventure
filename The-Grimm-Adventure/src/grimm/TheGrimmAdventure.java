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
    
    /**
     * Laittaa käyttäjän valitsemaan pelattavan hahmon ja aloittaa pelin.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RunGame.start();        
    }   
}

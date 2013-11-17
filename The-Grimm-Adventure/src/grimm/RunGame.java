/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

/**
 *
 * @author John
 */
public class RunGame {
    /**
     * Peliruutu.
     */
    static GUI gameScreen;
    
    /**
     * Itse peli.
     */
    static Game grimm;
    
    /**
     * Muuttuja, joka kertoo onko peli jo alkanut (onko pelialue luotu jne.)
     */
    private static boolean start = true;
    
    /**
     * Aloittaa pelin luomalla pelin UI:n ja tekemällä se näkyväksi.
     */
    public static void start(){
        gameScreen = new GUI();
        gameScreen.showGUI();
    }
    
    /**
     * Tämä luokka tuo ruutuun kaikki tarvittavat tekstit ja ottaa käyttäjän syötteen ja välittää sen edelleen
     * Command-luokalle käsiteltäväksi.
     * 
     * @param text On käyttäjän antama syöte.
     */
    public static void checkInput(String text) {
        if (!start) {
            gameScreen.textArea.append("\n"+grimm.locations[grimm.playerLocation].getDescription()+ "\n");
            gameScreen.textArea.append("\n"+Command.checkCommand(text)+ "\n");
                if (TheGrimmAdventure.win) {
                    gameScreen.textArea.append("Congratulations! You have won the game!");
                }
                grimm.checkForEvent();
            }
        
    
        if (start) {
            if (!text.equals("1") && !text.equals("2") && !text.equals("3")){ 
            gameScreen.textArea.append("\nChoose 1, 2 or 3\n");
            }
            if (text.equals("1")) {
                grimm = new Game("Klaus");
                gameScreen.textArea.append(grimm.choice(1));
                start = false;
            }
            if (text.equals("2")) {                
                gameScreen.textArea.append(text);
                grimm = new Game("Albrecht");
                gameScreen.textArea.append(grimm.choice(2));
                start = false;
            }   
            if (text.equals("3")) {
                gameScreen.textArea.append(text);
                grimm = new Game("Axel");
                gameScreen.textArea.append(grimm.choice(3));
                start = false;
            }
            gameScreen.textArea.append("\n"+grimm.locations[grimm.playerLocation].getDescription()+ "\n");
        }
    }
}
        
    
    
    


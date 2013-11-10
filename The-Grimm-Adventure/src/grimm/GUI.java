/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grimm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author John
 */
public class GUI extends JPanel implements ActionListener {
    public JTextField textField;
    public JTextArea textArea;
    private boolean beginning = true;
    JPanel panel = new JPanel();
    Game grimm;
    JFrame frame = new JFrame("The Grim Adventure");
    
    public GUI() {
        BorderLayout layout = new BorderLayout();
	panel.setLayout (layout);
	add(panel);
		
	// Define UI items
	textField  = new JTextField(60);
        textField.addActionListener(this);
        
	textArea = new JTextArea(30, 60);
	textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane (textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.PAGE_END);
        textArea.append("Choose your character:\n (1) Klaus \n (2) Albrecht \n (3) Axel\n");

        }

    public void addTextToArea(String t) {
        textArea.append("\n"+ t +"\n");
    }
    
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textField.setText("");

        
        if (!beginning) {
            textArea.append("\n"+grimm.locations[grimm.playerLocation].getDescription()+ "\n");
            textArea.append("\n"+Command.checkCommand(text));
            if (TheGrimmAdventure.win) {
                textArea.append("Congratulations! You have won the game!");
            }
        }
        if(beginning){
            if (!text.equals("1") && !text.equals("2") && !text.equals("3")){ 
            textArea.append("\nChoose 1, 2 or 3\n");
            }
            if (text.equals("1")) {
                textArea.append("\nKlaus\n");
                //grimm = new Game("Klaus");
                beginning = false;
            }
            if (text.equals("2")) {
                //text = Game.choice(2);
                //textArea.append(text);
                //grimm = new Game("Albrecht");
                beginning = false;
            }   
            if (text.equals("3")) {
                //textArea.append(grimm.choice(3));
                //grimm = new Game("Axel");
                beginning = false;
            }
        }
        textField.selectAll();
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public void createAndShowGUI(Game grimm) {
        //Create and set up the window.
        
        grimm.startGame();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new GUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
}





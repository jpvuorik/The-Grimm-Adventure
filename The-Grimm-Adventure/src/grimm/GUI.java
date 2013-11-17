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
    /**
     * Kenttä käyttäjän syötteelle.
     */
    public JTextField textField;
    
    /**
     * Kenttä pelin tapahtumien kuvauksille.
     */
    public JTextArea textArea;
         
    /**
     * Jpanel johon textField ja textArea laitetaan.
     */  
    JPanel panel = new JPanel();
    
    /**
     *  JFrame johon panel laitetaan.
     */
    JFrame frame = new JFrame("The Grim Adventure");
    
    /**
     * Konstruktori, joka luo pelin perus käyttöjärjestelmän. Asettaa tarvittavan layoutin, koon textArealle 
     * ja textFieldille ja kiinnittää skrollbarin TextAreaan.
     */
    public GUI() {
        BorderLayout layout = new BorderLayout();
	panel.setLayout (layout);
	add(panel);
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
  
    /**
     * Metodi, joka ottaa käyttäjän syötteen, lähettää sen eteenpäin RunGame luokkaan ja tyhjentää
     * syöttökentän.
     * 
     * @param evt Käyttäjän syöte.
     */
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textField.setText("");
        RunGame.checkInput(text);        
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    /**
     * Tekee käyttöjärjestelmästä näkyvän 
     */
    public void showGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(this);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
}






package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasa Kategoria dziedzicząca po JPanel
 * Wyświetla przyciski umożliwiające wybór danej kategorii i ładuje tło
 * @author Olga Krezymon
 */

public class Kategoria extends JPanel{
    
    JButton zwierzetab;
    JButton jedzenieb;
    JButton cialob;
    
    JLabel n2;
    
    /**
     * Konstruktor klasy Kategoria
     * Ładuje obrazy do przycisków i dodaje je do panelu.
     * Wywołuje funkcję ładująca tło
     */
    
    public Kategoria(){
        
        n2=new JLabel("Wybierz kategorię słówek");
        zwierzetab=new JButton(new ImageIcon("images/footprint.png"));
        jedzenieb=new JButton(new ImageIcon("images/food.png"));
        cialob=new JButton(new ImageIcon("images/body.png"));
        
        setLayout(null);
        
        add(zwierzetab);
        add(jedzenieb);
        add(cialob);
        add(n2);
        
        // wywołanie funkcji odpowiadającej za odpowiednie ustawienie przycisków 
        przyciski();
        //wywolanie funkcji ładującej obraz tła
        Obrazy.loadInitialImages();
        
    }
    
    /**
     * Metoda odpowiedzialna za odrysowanie tła na panelu
     * @param gs 
     */
    
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.bgImage, 0, 0, null);
    }  
    
    /**
     * Metoda odpowiedzialna za ustawienie przycisków i ich właściwości
     */
    
    protected void przyciski(){
        
        zwierzetab.setBackground(Color.blue);
        zwierzetab.setBounds(200,550,250,150);
        zwierzetab.setFont(new Font("Comic Sans",Font.BOLD, 20));
        
        jedzenieb.setBackground(Color.ORANGE);
        jedzenieb.setBounds(500,550,250,150);
        jedzenieb.setFont(new Font("Comic Sans",Font.BOLD, 20));
        
        cialob.setBackground(Color.GREEN);
        cialob.setBounds(800,550,250,150); 
        cialob.setFont(new Font("Comic Sans",Font.BOLD, 20));
        
        n2.setBounds(130,100,1200,400);
        n2.setFont(new Font("Courier New",Font.PLAIN, 70));
        n2.setForeground(Color.cyan);
        
       
    }
}

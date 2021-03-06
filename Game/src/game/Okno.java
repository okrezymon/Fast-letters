
package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;

/**
 * Klasa Okno dziedzicząca po JFrame
 * Tworzy obiekty wszystkich paneli użytych w grze, relizuje ActionListenery 
 * przycisków odpowiadające za przejścia pomiędzy panelami
 * @author Olga Krezymon
 */

public class Okno extends JFrame {
    
    /** Utworzenie obiektu poczatek typu InitGUI */
    InitGUI poczatek=new InitGUI();
    
    /** Utworzenie obiektu menu typu Menu */
    Menu menu=new Menu();
    
    /** Utworzenie obiektu kategoria typu Kategoria */
    Kategoria kategoria=new Kategoria();
    
    /** Utworzenie obiektu zwierzeta typu Zwierzeta */
    Zwierzeta zwierzeta=new Zwierzeta();
    
    /** Utworzenie obiektu jedzenie typu Jedzenie */
    Jedzenie jedzenie=new Jedzenie();
    
    /** Utworzenie obiektu cialo typu Cialo */
    Cialo cialo=new Cialo();
    
    /** Utworzenie obiektu info typu Info */
    Info info=new Info();
    
    /** Utworzenie obiektu cardPanel typu JPanel */
    JPanel cardPanel;
    
    /** Utworzenie obiektu cl typu CardLayout */
    CardLayout cl;
    
    public static boolean doliterek;
    
    /**
     * Konstruktor klasy pola graficznego gry.
     * Ustawienia początkowe rozmiaru, położenia, widoczności
     * Wywołanie funkcji panele realizującej cardLayout paneli 
     * @param width Szerokość pola graficznego gry
     * @param height Wysokość pola graficznego gry
     */
    
    public Okno(int width, int height, int x, int y){
        
        super();
        setSize(width, height); 
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        setUndecorated(false);
        setVisible(true);
        
        panele();  
        
    }
    
    /**
     * Metoda odpowiedzialna za dodanie paneli do cardPanelu oraz obsługę zdarzeń
     * wciśnięcia przycisków
     */
    
    public void panele(){
        
        cardPanel=new JPanel(new CardLayout());
        getContentPane().add(cardPanel);
        cardPanel.add(poczatek,"POCZATEK");
        cardPanel.add(kategoria,"WYBIERZ");
        cardPanel.add(zwierzeta,"ZWIERZETA");
        cardPanel.add(jedzenie,"JEDZENIE");
        cardPanel.add(cialo,"CIALO");
        cardPanel.add(menu,"MENU");
        cardPanel.add(info,"INFO");
        
        cl=(CardLayout)cardPanel.getLayout();
        cl.show(cardPanel,"POCZATEK");
        
        poczatek.gra.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"WYBIERZ");
            }
        });
        
        kategoria.zwierzetab.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"ZWIERZETA");
                //wywołanie funkcji restartz() powodującej wyczyszczenie wszystkich zmiennych przed ponownym wybraniem kategorii
                Zwierzeta.restartz();
                //tworzenie obiektu slowoz typu Slowoz, który odpowiada za wyświetlenie słowa w formie JDialog
                Slowoz slowoz = new Slowoz();
                
            }
            
        });
        
        kategoria.jedzenieb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"JEDZENIE");
                Jedzenie.restartj();
                Slowoj slowoj = new Slowoj();
            }
            
        });
        
        kategoria.cialob.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"CIALO");
                Cialo.restartc();
                Slowoc slowoc = new Slowoc();
            }
            
        });
        
        zwierzeta.menub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"MENU");
            }
            
        });
        
        cialo.menub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"MENU");
            }
            
        });
        
        jedzenie.menub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"MENU");
            }
            
        });
        
        menu.odnowa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"WYBIERZ");
            }
            
        });
        
        menu.infob.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"INFO");
            }
            
        });
        
        info.powrotmenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"MENU");
            }
            
        });
        
        
        Przegrana.dokat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"WYBIERZ");
            }
            
        });
        
        Wygrana.dokat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardPanel,"WYBIERZ");
            }
            
        });
        
        
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//panel początkowy wywoływany wraz z włączeniem gry

public class InitGUI extends JPanel  {
    
    JButton gra;
    JButton wyjdz;
    JLabel n1;
    
    public InitGUI(){
        
        //zdefiniowanie i dodanie do panelu napisu i przycisków
        
        n1=new JLabel("Fast Letters");
        gra=new JButton(new ImageIcon("images/puzzle.png"));
        wyjdz=new JButton(new ImageIcon("images/exit.png"));
        
        setLayout(null);
 
        add(gra);
        add(wyjdz);
        add(n1);
        
        przyciski();
        Obrazy.loadInitialImages();
        
        //dodanie ActionListenera do przycisku wyjdź powodującego wyjście z programu
        wyjdz.addActionListener(new End());
        
    }
    
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(Obrazy.bgImage, 0, 0, null);
    };
    
    public class End implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    protected void przyciski(){
        
        gra.setBounds(270,500,250,150);
        gra.setBackground(Color.cyan);
        
        
        wyjdz.setBounds(720,500,250,150);
        wyjdz.setBackground(Color.cyan);
        
        
        n1.setBounds(320,150,900,200);
        n1.setForeground(Color.cyan);
        n1.setFont(new Font("Courier New",Font.PLAIN, 90));
    }
}

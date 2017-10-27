package inlämningsuppgift3; 

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Inlämningsuppgift3 extends JFrame {
	private GamePanel gamePanel;
	private Meny meny;
	
	public Inlämningsuppgift3() {
		setInstanceVariables();
		addComponents();
	}
	
	protected void setInstanceVariables() {
		gamePanel = new GamePanel();
		meny = new Meny("New game", "Cancel");
	}
	
	protected void addComponents() {
//		Dimension dim = new Dimension(100, 50);
		getContentPane().setBackground(Color.BLACK);
		setLayout(new FlowLayout());

		
		add(gamePanel);
		add(meny);
		pack();
		setSize(220,310);
		this.setLocation(900, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) {
        Inlämningsuppgift3 start = new Inlämningsuppgift3();
    }
}

/**
 * Array med Flabel objekt med bilder på sifrror
 * Blandare
 * Kontrollerare som kollar ordningen på siffrorna
 * kontrollerare som kollar att siffran som vi vill byta kan bytas
 * bytare som byter plats
 */

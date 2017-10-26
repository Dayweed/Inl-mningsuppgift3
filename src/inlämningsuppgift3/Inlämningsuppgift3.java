package inlämningsuppgift3; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Inlämningsuppgift3 extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel meny = new JPanel();
	private NumberButtons[][] numericButtons = new NumberButtons[4][4];
	private List<String> imageFileNames = new ArrayList<>();
	private final String path = "C:\\Users\\David\\Documents\\Skola\\Nackademin\\Objektorienterad programmering\\Inlämningar\\Inlämningsuppgift3\\Images buttons\\";
	private final Path imageFolderPath = Paths.get(path);
	
	
	public Inlämningsuppgift3() {
		loadImagesFromFolder(imageFolderPath);
		setInstanceVariables();
		addComponents();
	}
	
	protected void setInstanceVariables() {
		GamePanel gamePanel = new GamePanel();
		Meny meny = new Meny("New game", "Cancel");
	}
	
	protected void addComponents() {
		meny.setLayout(new GridLayout(1,2));
		Dimension dim = new Dimension(100, 50);
		newGame.setPreferredSize(dim);
		avbryt.setPreferredSize(dim);

		add(panel);
		add(meny);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.BLACK);
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

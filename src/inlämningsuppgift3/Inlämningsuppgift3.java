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
import static javax.swing.JOptionPane.showMessageDialog;

public class Inlämningsuppgift3 extends JFrame {
	private JPanel panel = new JPanel();
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
		int imageCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == 15) {
					numericButtons[i][j] = new NumberButtons(i);
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setContentAreaFilled(false);
				}
				else {
					numericButtons[i][j] = new NumberButtons(i, new ImageIcon(path + imageFileNames.get(imageCounter)));
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setContentAreaFilled(false);
				}
				imageCounter++;
			}
		}
	}
	
	protected List<String> loadImagesFromFolder(Path imagesFolder) {
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(imagesFolder)) {
			for(Path currentFile: stream) {
				imageFileNames.add(currentFile.getFileName().toString());
			}
		}
		catch(IOException | DirectoryIteratorException x) {
			showMessageDialog(null, "No folder was found", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return imageFileNames;
	}
	
	protected void addComponents() {
		panel.setLayout(new GridLayout(4, 4));
		panel.add(numericButtons[0][0]);
		panel.add(numericButtons[0][1]);
		panel.add(numericButtons[0][2]);
		panel.add(numericButtons[0][3]);
		panel.add(numericButtons[1][0]);
		panel.add(numericButtons[1][1]);
		panel.add(numericButtons[1][2]);
		panel.add(numericButtons[1][3]);
		panel.add(numericButtons[2][0]);
		panel.add(numericButtons[2][1]);
		panel.add(numericButtons[2][2]);
		panel.add(numericButtons[2][3]);
		panel.add(numericButtons[3][0]);
		panel.add(numericButtons[3][1]);
		panel.add(numericButtons[3][2]);
		panel.add(numericButtons[3][3]);

		add(panel);
		getContentPane().setBackground(Color.BLACK);
		pack();
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

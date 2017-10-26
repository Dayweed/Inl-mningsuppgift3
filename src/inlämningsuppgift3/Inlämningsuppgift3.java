package inlämningsuppgift3; 

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Inlämningsuppgift3 extends JFrame {
	private JPanel panel = new JPanel();
	private NumberButtons[] numericButtons = new NumberButtons[16];
	private List<String> imageFileNames = new ArrayList<>();
	private final String path = "C:\\Users\\David\\Documents\\Skola\\Nackademin\\Objektorienterad programmering\\Inlämningar\\Inlämningsuppgift3\\Images buttons\\";
	private final Path imageFolderPath = Paths.get(path);
	
	public Inlämningsuppgift3() {
		loadImagesFromFolder(imageFolderPath);
		setInstanceVariables();
		addComponents();
	}
	
	protected void setInstanceVariables() {
		for(int i = 0; i < numericButtons.length; i++) {
			if(i == 0) {
				numericButtons[i] = new NumberButtons(i);
				numericButtons[i].setBorder(null);
			}
			else {
				numericButtons[i] = new NumberButtons(i, new ImageIcon(path + imageFileNames.get(i)));
				numericButtons[i].setBorder(null);
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
		panel.setLayout(new FlowLayout());
		panel.add(numericButtons[0]);
		panel.add(numericButtons[1]);
		panel.add(numericButtons[2]);
		panel.add(numericButtons[3]);
		panel.add(numericButtons[4]);
		panel.add(numericButtons[5]);
		panel.add(numericButtons[6]);
		panel.add(numericButtons[7]);
		panel.add(numericButtons[8]);
		panel.add(numericButtons[9]);
		panel.add(numericButtons[10]);
		panel.add(numericButtons[11]);
		panel.add(numericButtons[12]);
		panel.add(numericButtons[13]);
		panel.add(numericButtons[14]);
//		panel.add(numericButtons[15]);
//		panel.add(numericButtons[16]);
//		panel.add(numericButtons[17]);
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

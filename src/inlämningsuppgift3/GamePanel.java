package inlämningsuppgift3;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class GamePanel extends JPanel{
	private NumberButtons[][] numericButtons = new NumberButtons[4][4];
	private List<String> imageFileNames = new ArrayList<>();
	private final String path = "C:\\Users\\David\\Documents\\Skola\\Nackademin\\Objektorienterad programmering\\Inlämningar\\Inlämningsuppgift3\\Images buttons\\";
	private final Path imageFolderPath = Paths.get(path);
	
	public GamePanel() {
		loadImagesFromFolder(imageFolderPath);
		setInstanceVariables();
		addComponents();
	}
	
	protected void setInstanceVariables() {
		int imageCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == 3 && j == 3) {
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
		setLayout(new GridLayout(4, 4));
		setBackground(Color.BLACK);
		add(numericButtons[0][0]);
		add(numericButtons[0][1]);
		add(numericButtons[0][2]);
		add(numericButtons[0][3]);
		add(numericButtons[1][0]);
		add(numericButtons[1][1]);
		add(numericButtons[1][2]);
		add(numericButtons[1][3]);
		add(numericButtons[2][0]);
		add(numericButtons[2][1]);
		add(numericButtons[2][2]);
		add(numericButtons[2][3]);
		add(numericButtons[3][0]);
		add(numericButtons[3][1]);
		add(numericButtons[3][2]);
		add(numericButtons[3][3]);
		
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 4; j++) {
//				add(numericButtons[i][j]);
//			}
//		}
	}
}

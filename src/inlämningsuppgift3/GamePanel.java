package inlämningsuppgift3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class GamePanel extends JPanel{
	public NumberButtons[][] numericButtons = new NumberButtons[4][4];
	private ButtonListener buttonEventListener = new ButtonListener();
	private List<String> imageFileNames = new ArrayList<>();
	private final String path = "C:\\Users\\David\\Documents\\Skola\\Nackademin\\Objektorienterad programmering\\Inlämningar\\Inlämningsuppgift3\\Images buttons\\";
	private final Path imageFolderPath = Paths.get(path);
	
	public GamePanel() {
		loadImagesFromFolder(imageFolderPath);
		setInstanceVariables();
//		numericButtons = shuffleDoubleArray(numericButtons);
		addComponents();
		setLayout();
	}
	
	protected void setInstanceVariables() {
		int imageCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == 3 && j == 3) {
					numericButtons[i][j] = new NumberButtons(i);
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setFocusPainted(false);
					numericButtons[i][j].setContentAreaFilled(false);
					numericButtons[i][j].addActionListener(buttonEventListener);
				}
				else {
					numericButtons[i][j] = new NumberButtons(i, new ImageIcon(path + imageFileNames.get(imageCounter)));
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setFocusPainted(false);
					numericButtons[i][j].setContentAreaFilled(false);
					numericButtons[i][j].addActionListener(buttonEventListener);
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
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				add(numericButtons[i][j]);
			}
		}
	}
	
	protected void setLayout() {		
		setLayout(new GridLayout(4, 4, 0, 0));
		setBackground(Color.BLACK);
	}
	
	public static NumberButtons[][] shuffleDoubleArray(NumberButtons[][] arrayToshuffle) {
		NumberButtons temp = new NumberButtons();
		for(int i = 0; i < 100; i++) {
			int randomIndex1 = (int) Math.random() * 4;
			int randomIndex2 = (int) Math.random() * 4;
			temp = arrayToshuffle[randomIndex1][randomIndex2];
			arrayToshuffle[randomIndex1][randomIndex2] = arrayToshuffle[randomIndex2][randomIndex1];
			arrayToshuffle[randomIndex2][randomIndex1] = temp;
		}
		return arrayToshuffle;
	}
}

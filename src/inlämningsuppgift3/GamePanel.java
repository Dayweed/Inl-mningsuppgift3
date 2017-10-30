package inlämningsuppgift3;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class GamePanel extends JPanel{
	protected NumberButtons[][] numericButtons = new NumberButtons[4][4];
	private ButtonListener buttonEventListener = new ButtonListener();
	private List<String> imageFileNames = new ArrayList<>();
	private final String path = "C:\\Users\\David\\Documents\\Skola\\Nackademin\\Objektorienterad programmering\\Inlämningar\\Inlämningsuppgift3\\Images buttons\\";
	protected final Path imageFolderPath = Paths.get(path);
	private Position positionOfEmpty = new Position();
	
	public GamePanel() {
		loadImagesFromFolder(imageFolderPath);
		setInstanceVariables();
		setNextToEmpty();
		numericButtons = shuffleDoubleArray();
		addComponents();
		setLayout();
	}
	
	protected void setInstanceVariables() {
		int imageCounter = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(i == 3 && j == 3) {
					numericButtons[i][j] = new NumberButtons();
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setFocusPainted(false);
					numericButtons[i][j].setContentAreaFilled(false);
					numericButtons[i][j].addActionListener(buttonEventListener);
					numericButtons[i][j].setActionCommand(imageCounter + 1 + "");
				}
				else {
					numericButtons[i][j] = new NumberButtons(imageCounter + 1, false, new ImageIcon(path + imageFileNames.get(imageCounter)));
					numericButtons[i][j].setBorder(null);
					numericButtons[i][j].setFocusPainted(false);
					numericButtons[i][j].setContentAreaFilled(false);
					numericButtons[i][j].addActionListener(buttonEventListener);
					numericButtons[i][j].setActionCommand(imageCounter + 1 + "");
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
	
	public NumberButtons[][] shuffleDoubleArray() {
		Random firstRandomButton = new Random();
		Random secondRandomButton = new Random();
		NumberButtons temp = new NumberButtons();
		for(int i = 0; i < 100; i++) {
			int randomIndex1 = firstRandomButton.nextInt(4);
			int randomIndex2 = firstRandomButton.nextInt(4);
			int randomIndex3 = secondRandomButton.nextInt(4);
			int randomIndex4 = secondRandomButton.nextInt(4);
			temp = numericButtons[randomIndex1][randomIndex2];
			numericButtons[randomIndex1][randomIndex2] = numericButtons[randomIndex3][randomIndex4];
			numericButtons[randomIndex3][randomIndex4] = temp;
		}
		return numericButtons;
	}
	
	public void resetter() {
		numericButtons = shuffleDoubleArray();
		addComponents();
	}
	
	public void setPositionOfEmpty() {
		int i;
		int j;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4; j++)
				if(numericButtons[i][j].getValue() == -1)
					positionOfEmpty.setFirstPosition(i);
					positionOfEmpty.setSecondPosition(j);
		}
	}
	
	public void setToFalse() {
		int i;
		int j;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 4; j++)
				numericButtons[i][j].setNextTo(false);
		}
	}
	
	public void setNextToEmpty() {
		if(positionOfEmpty.getFirstPosition() == 0 && positionOfEmpty.getSecondPosition() == 0) {
			numericButtons[1][0].setNextTo(true);
			numericButtons[0][1].setNextTo(true);
		}
		else if(positionOfEmpty.getFirstPosition() == 3 && positionOfEmpty.getSecondPosition() == 3) {
			numericButtons[3][2].setNextTo(true);
			numericButtons[2][3].setNextTo(true);
		}
		else if(positionOfEmpty.getFirstPosition() == 3 && positionOfEmpty.getSecondPosition() == 0) {
			numericButtons[2][0].setNextTo(true);
			numericButtons[3][1].setNextTo(true);
		}
		else if(positionOfEmpty.getFirstPosition() == 0 && positionOfEmpty.getSecondPosition() == 3) {
			numericButtons[0][2].setNextTo(true);
			numericButtons[1][3].setNextTo(true);
		}
		else if(positionOfEmpty.getFirstPosition() == 0) {
			numericButtons[positionOfEmpty.getFirstPosition()][positionOfEmpty.getSecondPosition() - 1].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition()][positionOfEmpty.getSecondPosition() + 1].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() + 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
		}
		else if(positionOfEmpty.getFirstPosition() == 3) {
			numericButtons[positionOfEmpty.getFirstPosition()][positionOfEmpty.getSecondPosition() - 1].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition()][positionOfEmpty.getSecondPosition() + 1].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
		}
		else if(positionOfEmpty.getSecondPosition() == 0) {
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() + 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition() + 1].setNextTo(true);
		}
		else if(positionOfEmpty.getSecondPosition() == 3) {
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() + 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition() - 1].setNextTo(true);
		}
		else
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() + 1][positionOfEmpty.getSecondPosition()].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() - 1][positionOfEmpty.getSecondPosition() - 1].setNextTo(true);
			numericButtons[positionOfEmpty.getFirstPosition() + 1][positionOfEmpty.getSecondPosition() - 1].setNextTo(true);
		
		
		
	}
}

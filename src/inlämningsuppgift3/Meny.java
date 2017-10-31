package inlämningsuppgift3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Meny extends JPanel{
	private GamePanel gamePanel;
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JLabel gameInfoText;
	private JButton newGame;
	private JButton cancel;
	private final Dimension buttonDimension = new Dimension(100, 50);
	
	public Meny(String newGameText, String cancelText, GamePanel gamePanel) {
		setInstanceVariables(newGameText, cancelText, gamePanel);
		addComponents();
		setLayout();
	}
	
	protected void setInstanceVariables(String newGameText, String cancelText, GamePanel gamePanel) {
		gameInfoText = new JLabel("Try to get all the bricks in order :)");
		newGame = new JButton(newGameText);
		cancel = new JButton(cancelText);
		newGame.addActionListener(l -> {
			gamePanel.resetter();
			gamePanel.revalidate();
		});
		cancel.addActionListener(l -> {System.exit(0);});
	}
	
	protected void addComponents() {
		add(topPanel);
		add(bottomPanel);
		topPanel.add(gameInfoText);
		bottomPanel.add(newGame);
		bottomPanel.add(cancel);
	}
	
	protected void setLayout() {
		setLayout(new GridLayout(2, 1));
		bottomPanel.setLayout(new GridLayout(1, 2));
		topPanel.setBackground(Color.BLACK);
		topPanel.setForeground(Color.red);
		newGame.setPreferredSize(buttonDimension);
		cancel.setPreferredSize(buttonDimension);
		newGame.setBorderPainted(false);
		cancel.setBorderPainted(false);
	}
}

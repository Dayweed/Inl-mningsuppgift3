package inlämningsuppgift3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Meny extends JPanel{
	private JButton newGame;
	private JButton cancel;
	private final Dimension buttonDimension = new Dimension(100, 50);
	
	public Meny(String newGameText, String cancelText) {
		setInstanceVariables(newGameText, cancelText);
		addComponents();
		setLayout();
	}
	
	protected void setInstanceVariables(String newGameText, String cancelText) {
		newGame = new JButton(newGameText);
		cancel = new JButton(cancelText);
		newGame.addActionListener(l -> {System.exit(0);});
		cancel.addActionListener(l -> {System.exit(0);});
	}
	
	protected void addComponents() {
		add(newGame);
		add(cancel);
	}
	
	protected void setLayout() {
		setLayout(new GridLayout(1, 2));
		setBackground(Color.BLACK);
		newGame.setPreferredSize(buttonDimension);
		cancel.setPreferredSize(buttonDimension);
	}
}

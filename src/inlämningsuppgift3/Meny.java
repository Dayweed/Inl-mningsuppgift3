package inlämningsuppgift3;

import javax.swing.*;

public class Meny extends JPanel{
	private JButton newGame;
	private JButton cancel;
	
	public Meny(String newGameText, String cancelText) {
		setInstanceVariables(newGameText, cancelText);
		addComponents();
	}
	
	protected void setInstanceVariables(String newGameText, String cancelText) {
		this.newGame = new JButton(newGameText);
		this.cancel = new JButton(cancelText);
	}
	
	protected void addComponents() {
		add(newGame);
		add(cancel);
	}
}

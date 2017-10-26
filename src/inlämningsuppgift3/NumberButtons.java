package inlämningsuppgift3;

import javax.swing.Icon;
import javax.swing.JButton;

public class NumberButtons extends JButton{
	private int value;
	
	public NumberButtons(int value) {
		this.value = value;
	}
	public NumberButtons(int value, Icon numberIcon) {
		super(numberIcon);
		this.value = value;
	}
}

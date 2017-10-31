package inlämningsuppgift3;

import javax.swing.Icon;
import javax.swing.JButton;

public class NumberButtons extends JButton{
	private boolean nextToEmpty;
	private int value;
	
	public NumberButtons(){
		value = 16;
		nextToEmpty = false;
	}
	
	public NumberButtons(int value, boolean setFalse, Icon numberIcon) {
		super(numberIcon);
		this.value = value;
		nextToEmpty = setFalse;
	}
	
	public void setNextTo(boolean isNextToEmpty) {
		nextToEmpty = isNextToEmpty;
	}
	
	public boolean getIfNextTo() {
		return nextToEmpty;
	}
	
	public int getValue() {
		return value;
	}
}

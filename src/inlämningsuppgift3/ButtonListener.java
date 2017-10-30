package inlämningsuppgift3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("3"))
			System.out.println("HEj");
		else
			System.out.println("Tja");
	}
}

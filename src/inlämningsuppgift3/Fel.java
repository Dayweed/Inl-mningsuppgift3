package inlämningsuppgift3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fel implements ActionListener{
	public static GamePanel gamePanel;
	
	public Fel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++)
				if(e.getSource() == gamePanel.numericButtons[i][j])
					if(gamePanel.numericButtons[i][j].getIfNextTo())
						gamePanel.updater(gamePanel.numericButtons[i][j]);
		}
		gamePanel.revalidate();
		gamePanel.repaint();
	}
}

package miApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiEvento implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().toString().equals("btnVolver")) {
		Login frame = new Login();
		frame.setVisible(true);
		}

	}

}

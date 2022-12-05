package pos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pageHeader extends JPanel{
	JButton btn_backMain;
	JLabel label_currentTime;
	public pageHeader() {

		setLayout(new BorderLayout());
		setBackground(final_Layout.HEADER_BACKGROUND);
		btn_backMain=new JButton(final_String.HEADER_BACKMENU);
		label_currentTime=new JLabel("현재시간");
		add(label_currentTime,BorderLayout.CENTER);
		add(btn_backMain,BorderLayout.EAST);
		setBounds(0,0,1200,30);
	}
}

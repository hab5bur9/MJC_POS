package pos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pageHeader extends JFrame{
	JButton btn_backMain;
	JLabel label_currentTime;
	JPanel header;
	public pageHeader() {
		
		header = new JPanel();
		//header.setPreferredSize(new Dimension(final_Layout.PAGE_WIDTH,final_Layout.HEADER_HEIGHT));
		header.setLayout(new BorderLayout());
		header.setBackground(final_Layout.HEADER_BACKGROUND);
		
		
		btn_backMain=new JButton(final_String.HEADER_BACKMENU);
		label_currentTime=new JLabel("현재시간");
		
		header.add(label_currentTime,BorderLayout.CENTER);
		header.add(btn_backMain,BorderLayout.EAST);
		header.setBounds(0,0,1200,30);
	}
}

package p1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Delete_Staff_Frame extends JFrame {
	
	String info[]= {"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi"};//임의로 넣은 값임.나중에 db에서 가져오기
	
	JPanel main_panel=new JPanel();
	JPanel staff_main_panel= new JPanel();
	JButton btn_backMain=new JButton("돌아가기");
	JPanel btn_panel=new JPanel();
	
	Delete_Staff_Frame(){
	
		add(main_panel);
		add(btn_panel,BorderLayout.EAST);
		
		
		main_panel.setLayout(null);
		main_panel.add(staff_main_panel);
		
		staff_main_panel.setLayout(new FlowLayout(FlowLayout.LEFT,80,50));
		staff_main_panel.setBounds(50,25,800,800);
		staff_main_panel.setBackground(Color.LIGHT_GRAY);
		btn_panel.setLayout(new GridLayout(0,1));
		
		for(int i=0;i<info.length;i++) {
			JRadioButton staff_button=new JRadioButton();
			JPanel staff_paneli=new JPanel();
		
			staff_paneli.add(staff_button);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1200,900);
		setPreferredSize(new Dimension(1200,900));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Delete_Staff_Frame();
	}

}

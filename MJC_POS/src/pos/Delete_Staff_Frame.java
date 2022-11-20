package pos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

class DeleteEvent2 implements ItemListener{
	
	String []info;
	JCheckBox staff_btni;
	ArrayList<String> listA;
	
	DeleteEvent2(ArrayList<String> listA,JCheckBox staff_btni){
		
		this.staff_btni=staff_btni;
		this.listA=listA;
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		for(int i=0;i<info.length;i++) {
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				
				listA.remove(i);
				
			}
			
			new Delete_Staff_Frame();
		}
		
		
	}
	
}

public class Delete_Staff_Frame extends JFrame {
	
	ArrayList<String> listA = new ArrayList<String>();
	 
	String info[]= {"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi"};//임의로 넣은 값임.나중에 db에서 가져오기
	
	JPanel main_panel=new JPanel();
	JPanel staff_main_panel= new JPanel();
	JButton btn_backMain=new JButton("돌아가기");
	JButton Delete= new JButton("삭제하기");
	JPanel btn_panel=new JPanel();
	
	JLabel[]lis=new JLabel[info.length];
	JList info2=new JList(info); 
	
	Delete_Staff_Frame(){
	
		add(main_panel);
		add(btn_panel,BorderLayout.EAST);
		
		
		main_panel.setLayout(null);
		main_panel.add(staff_main_panel);
		
		staff_main_panel.setLayout(new FlowLayout(FlowLayout.LEFT,80,50));
		staff_main_panel.setBounds(50,25,800,800);
		staff_main_panel.setBackground(Color.LIGHT_GRAY);
		
		btn_panel.setLayout(new GridLayout(0,1));
		btn_panel.setBounds(875, 25, 300, 800);
		btn_panel.setBackground(Color.green);
		
		Delete.setPreferredSize(new Dimension(300,100));
		btn_backMain.setPreferredSize(new Dimension(300,100));
		
		
		btn_panel.add(Delete);
		btn_panel.add(btn_backMain);
		
		main_panel.add(btn_panel);
		
		for(int i=0;i<info.length;i++) {
			
			listA.add(info[i]);
			JCheckBox staff_checkBox=new JCheckBox();
			JPanel staff_paneli=new JPanel();
			
			
			
			staff_paneli.add(lis[i]=new JLabel(listA.get(i)));
			staff_checkBox.add(lis[i]);
			
			
			
			DeleteEvent2 Del2=new DeleteEvent2(listA,staff_checkBox);
			Delete.addItemListener(Del2);
			staff_paneli.add(staff_checkBox);
			staff_paneli.setPreferredSize(new Dimension(270,200));
			staff_main_panel.add(staff_paneli);
			
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

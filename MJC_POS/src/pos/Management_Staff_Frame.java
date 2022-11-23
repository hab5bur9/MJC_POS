package pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class AddEvent implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//직원추가
	}
}



class CalculateEvent implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		//급여정산
	}
}



//-----------실행프레임-----------------
public class Management_Staff_Frame extends JFrame{
	

	
	String info[]= {"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi"};//임의로 넣은 값임.나중에 db에서 가져오기
	//db에서 가져오기
	int db_workTime;
	int db_pay=9620*db_workTime;
	String db_name;
	String db_e_number;
	//db에서 받아와서 변수에 저장. 그리고 JLabel에 넣기
	
	
	JPanel main_panel=new JPanel();
	JPanel staff_main_panel=new JPanel();	
	JPanel btn_panel=new JPanel();
	
	JLabel workTime=new JLabel("근무시간:"+Integer.toString(db_workTime)+"시간"); 
	JLabel pay=new JLabel("월급:"+Integer.toString(db_pay)+"원");
	JLabel name=new JLabel(db_name);
	JLabel e_number=new JLabel("직원번호:"+db_e_number);
	JScrollPane sp=new JScrollPane();
	
	
	JButton Add=new JButton("직원 추가");
	JButton Delete=new JButton("직원 삭제");
	JButton Calculate=new JButton("급여 정산");
	JButton Revise=new JButton("정보 수정");
	JButton btn_backMain=new JButton("메인메뉴");
	
	JLabel lis[]=new JLabel[info.length];
	
	
	
	
	
	Management_Staff_Frame(){
	
		
		
		setTitle("직원 관리");
		
		add(main_panel);
		
		main_panel.add(sp);
		
		main_panel.setLayout(null);
		main_panel.add(staff_main_panel);
		
		staff_main_panel.setLayout(new FlowLayout(FlowLayout.LEFT,80,50));
		staff_main_panel.setBounds(50,25,800,800);
		staff_main_panel.setBackground(Color.LIGHT_GRAY);
		
		btn_panel.setLayout(new GridLayout(0,1));
		btn_panel.setBounds(875, 25, 300, 800);
		btn_panel.setBackground(Color.green);
		
		
		main_panel.add(btn_panel);
	
		
		btn_panel.add(Add);
		btn_panel.add(Delete);
		btn_panel.add(Calculate);
		btn_panel.add(Revise);
		btn_panel.add(btn_backMain);
		
		Delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Delete_Staff_Frame();
			}
			
		});
		
		btn_backMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new POS_main();
			}
		});
		
	Add.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Add_Staff_Frame();
		}
	});
		
		
		for(int i=0;i<info.length;i++) {
			
			
			JPanel staff_paneli=new JPanel();
			JPanel img_paneli=new JPanel();
			JLabel img_staff_i = new JLabel(new ImageIcon("img/anonymous.png"));
			
			staff_paneli.add(img_paneli);
			staff_paneli.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
			staff_paneli.setBackground(Color.white);
			
			img_paneli.add(img_staff_i);
			img_paneli.setBackground(Color.white);
			
			img_staff_i.setLayout(null);
			img_staff_i.setPreferredSize(new Dimension(55,55));	
			
			staff_paneli.add(lis[i]=new JLabel(info[i]));
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
		new Management_Staff_Frame();
	}

}

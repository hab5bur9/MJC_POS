package pos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Add_Staff_Frame extends JFrame{

	JPanel main_panel=new JPanel();
	JPanel text_panel=new JPanel();
	
	
	//JLabel ec=new JLabel(new ImageIcon("img/anonymous2.png"));
	JLabel name = new JLabel("이름(name):");
	JLabel age= new JLabel("나이(age):");
	JLabel phone_number=new JLabel("핸드폰 번호(phone):");
	JLabel Adress=new JLabel("자택주소:");
	JLabel namei=new JLabel();
	
	JButton btn_backMain=new JButton("돌아가기");
	JButton btn_save=new JButton("저장");
	JButton btn_empty=new JButton("다시 쓰기");
	
	JTextField name_txt=new JTextField();
	JTextField age_txt=new JTextField();
	JTextField phone_txt=new JTextField();
	JTextArea Adress_txt=new JTextArea();
	
	JScrollPane sp=new JScrollPane(Adress_txt);
	
	Add_Staff_Frame(){
		//어디 고쳐봐라 선지성 ㄹㅇㅋㅋ
		setTitle("직원 추가");
		add(main_panel);
		main_panel.setLayout(null);
		text_panel.setLayout(null);
		text_panel.setBounds(0 , 0, 500, 800);
		text_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.add(text_panel);
		
		
		//main_panel.add(ec);
		text_panel.add(sp);
		text_panel.add(name);
		text_panel.add(age);
		text_panel.add(phone_number);
		text_panel.add(Adress);
		text_panel.add(name_txt);
		text_panel.add(age_txt);
		text_panel.add(phone_txt);
		text_panel.add(Adress_txt);
		text_panel.add(btn_save);
		text_panel.add(btn_empty);
		text_panel.add(btn_backMain);
		
		//ec.setBounds(870, 27, 300, 300);
		btn_save.setBounds(290,650 , 140, 100);	
		btn_empty.setBounds(130, 650, 140, 100);
		btn_backMain.setBounds(335,15,140,30);
		name.setBounds(15, 50, 100, 100);
		age.setBounds(15, 200, 100, 100);
		phone_number.setBounds(15, 350, 300, 100);
		Adress.setBounds(15, 500, 100, 100);
		
		
		name_txt.setBounds(130, 90, 150, 30);
		age_txt.setBounds(130, 240, 150, 30);
		phone_txt.setBounds(130, 390,150 , 30);
		Adress_txt.setBounds(130, 540, 300, 100);
	
		
		
		
		btn_backMain.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Management_Staff_Frame();
			}
		});
		
		btn_empty.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name_txt.setText(" ");
				age_txt.setText(" ");
				phone_txt.setText(" ");
				Adress_txt.setText(" ");
			}
		});
		
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "저장되었습니다!", "MJC_POS", JOptionPane.INFORMATION_MESSAGE);
				//db, management프레임에 판넬 추가 기능 넣기
				dispose();
				new Management_Staff_Frame();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500,800);
		setPreferredSize(new Dimension(1200,900));
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Add_Staff_Frame();
	}

}

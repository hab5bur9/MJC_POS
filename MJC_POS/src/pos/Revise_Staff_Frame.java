package pos;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;

public class Revise_Staff_Frame extends JFrame{

	JPanel main_panel=new JPanel();
	JPanel text_panel=new JPanel();
	
	
	JLabel name = new JLabel("이름(name):");
	JLabel age= new JLabel("나이(age):");
	JLabel phone_number=new JLabel("핸드폰 번호(phone):");
	JLabel Adress=new JLabel("자택주소:");
	JLabel namei=new JLabel();
	
	JButton btn_backMain=new JButton("돌아가기");
	JButton btn_change=new JButton("수정");
	JButton btn_empty=new JButton("다시 쓰기");
	
	JTextField name_txt=new JTextField();
	JTextField age_txt=new JTextField();
	JTextField phone_txt=new JTextField();
	JTextArea Adress_txt=new JTextArea();
	
	JScrollPane sp=new JScrollPane(Adress_txt);
	
	Revise_Staff_Frame(){
		//프레임 기본 설정
		setTitle("정보 수정");
		setSize(500, 800);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌

		add(main_panel);
		main_panel.setLayout(null);
		text_panel.setLayout(null);
		text_panel.setBounds(0 , 0, 500, 800);
		text_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.add(text_panel);
		
		
		text_panel.add(sp);
		text_panel.add(name);
		text_panel.add(age);
		text_panel.add(phone_number);
		text_panel.add(Adress);
		text_panel.add(name_txt);
		text_panel.add(age_txt);
		text_panel.add(phone_txt);
		text_panel.add(Adress_txt);
		text_panel.add(btn_change);
		text_panel.add(btn_empty);
		text_panel.add(btn_backMain);
		
		//ec.setBounds(870, 27, 300, 300);
		btn_change.setBounds(290,650 , 140, 100);	
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
		
		btn_change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "수정되었습니다!", "MJC_POS", JOptionPane.INFORMATION_MESSAGE);
				//db, management프레임에 판넬 추가 기능 넣기
				dispose();
				new Management_Staff_Frame();
			}
		});
		
	}	
	
	public static void main(String[] args) {
		new Revise_Staff_Frame();
	}
	
}



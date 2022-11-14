package pos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LOGiN_Frame extends JFrame implements ActionListener{


		JTextField ID_tf = new JTextField(10);
		JPasswordField PW_tf = new JPasswordField(10);
<<<<<<< HEAD
		//��ư �̺�Ʈ�� ����ϱ� ���� ���������� ����
	LOGiN_Frame(){
=======
		//占쏙옙튼 占싱븝옙트占쏙옙 占쏙옙占쏙옙歐占� 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	LOGIN_Frame(){
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		
		setTitle("MJC Pos");
		
		JPanel Main_panel = new JPanel();
		JPanel MJC_panel = new JPanel();
		JPanel Button_panel = new JPanel();
		JPanel TextField_panel = new JPanel();
		
		JLabel Pos = new JLabel("MJC POS");
<<<<<<< HEAD
		JLabel ID = new JLabel("ID �Է� : ");
		JLabel PW = new JLabel("PW �Է� :");
		JLabel Img = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\��������.png"));
=======
		JLabel ID = new JLabel(final_String.LOGIN_ID);
		JLabel PW = new JLabel(final_String.LOGIN_PW);
		JLabel Img = new JLabel(new ImageIcon("C:\\Users\\user\\Desktop\\占쏙옙占쏙옙占쏙옙占쏙옙.png"));
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
			
<<<<<<< HEAD
		JButton Login = new JButton("   �α���    ");
		JButton Cancel = new JButton("     ���     ");		
		JButton Reset = new JButton("          ��й�ȣ  �ʱ�ȭ           ");
=======
		JButton Login = new JButton(final_String.LOGIN_LOGIN);
		JButton Cancel = new JButton(final_String.LOGIN_CANCLE);
		JButton Reset = new JButton(final_String.LOGIN_RESET);
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		
<<<<<<< HEAD
		PW_tf.setEchoChar('*'); //��й�ȣ �Է�â�� *�� ��� ����
=======
		PW_tf.setEchoChar('*'); //占쏙옙橘占싫� 占쌉뤄옙창占쏙옙 *占쏙옙 占쏙옙占� 占쏙옙占쏙옙
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		
		Login_ActionListener Login_A = new Login_ActionListener ();
	    Login.addActionListener(Login_A);
	    Cancel_ActionListener Cancel_A = new Cancel_ActionListener();
	    Cancel.addActionListener(Cancel_A);
	    PW_F_ActionListener PW_F = new PW_F_ActionListener();
	    Reset.addActionListener(PW_F);
	    
		add(Main_panel);
		Main_panel.setBackground(Color.white);
		Main_panel.add(MJC_panel);
		MJC_panel.setBackground(Color.white);
		Main_panel.add(Button_panel);
		Button_panel.setBackground(Color.white);
		Main_panel.add(TextField_panel);
		TextField_panel.setBackground(Color.white);
		Main_panel.setLayout(null);
<<<<<<< HEAD
		MJC_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 0 , 17)); // �̹��� �� ���� �ǳ�
		Button_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10 , 5)); // ��ư ���� �ǳ�
		TextField_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10, 10)); // ID , PW �Է� �� ���� �ǳ�
=======
		MJC_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 0 , 17)); // 占싱뱄옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占실놂옙
		Button_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10 , 5)); // 占쏙옙튼 占쏙옙占쏙옙 占실놂옙
		TextField_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10, 10)); // ID , PW 占쌉뤄옙 占쏙옙 占쏙옙占쏙옙 占실놂옙
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		
		MJC_panel.setBounds(40 , 40 , 120 , 200);
		MJC_panel.add(Img);
		MJC_panel.add(Pos);
<<<<<<< HEAD
		Pos.setFont(new Font("���� ���" , Font.BOLD , 22));
=======
		Pos.setFont(new Font("맑은 고딕" , Font.BOLD , 22));
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		
		TextField_panel.setBounds(160 , 60 , 210 , 100);
		TextField_panel.add(ID);
<<<<<<< HEAD
		ID.setFont(new Font("���� ���" , Font.BOLD , 15));
=======
		ID.setFont(new Font("맑은 고딕" , Font.BOLD , 15));
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		TextField_panel.add(ID_tf);
		TextField_panel.add(PW);
<<<<<<< HEAD
		PW.setFont(new Font("���� ���" , Font.BOLD , 15));
=======
		PW.setFont(new Font("맑은 고딕" , Font.BOLD , 15));
>>>>>>> branch 'master' of https://github.com/hab5bur9/MJC_POS.git
		TextField_panel.add(PW_tf);
			
		Button_panel.setBounds(160,145,210,100);
		Button_panel.add(Login);
		Button_panel.add(Cancel);
		Button_panel.add(Reset);
		
		Pos.setBounds(50,120,100,100);
		ID.setBounds(150,110,80,40);
		PW.setBounds(150,150,90,40);
		ID_tf.setBounds(260,110,70,30);
		PW_tf.setBounds(260,150,70,30);
	
		setSize(450 , 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
	}
	public void actionPerformed(ActionEvent ae) {
		
	}

class Login_ActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�.");
		JOptionPane.showMessageDialog(null, "로그인 되었습니다.");

		}
	}
class Cancel_ActionListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			
			ID_tf.setText("");
			PW_tf.setText("");	
		}
}
class PW_F_ActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			
		}
	}

	public static void main(String[] args) {
		
		new LOGiN_Frame();
	}

}


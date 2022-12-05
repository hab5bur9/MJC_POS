package pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Change_Staff_Frame extends JFrame implements ActionListener{

	Change_Staff_Frame(){
		//프레임 기본 설정
		setTitle("메인메뉴");
		setSize(400, 600);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌

		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());

		JPanel p_staff = new JPanel();
		p_staff.setPreferredSize(new Dimension(400, 400));
		p_staff.setBackground(Color.WHITE);
		ct.add(p_staff);

		JLabel temp = new JLabel("근무자 리스트 들어갈 곳");
		p_staff.add(temp);

		JPasswordField jtf_passwd = new JPasswordField();
		jtf_passwd.setPreferredSize(new Dimension(350, 50));
		jtf_passwd.setHorizontalAlignment(JTextField.CENTER);
		ct.add(jtf_passwd);

		JButton btn_change = new JButton("변경");

		btn_change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				;// 버튼 클릭 시 입력된 비밀번호와 선택된 근무자의 비밀번호가 일치하면 선택된 근무자로 변경되는 이벤트 처리
			}
		});
		ct.add(btn_change);

		JButton btn_cancel = new JButton("닫기");

		btn_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ct.add(btn_cancel);


		ct.revalidate();
		ct.repaint();


	}
	public static void main(String[] args) {
		new Change_Staff_Frame();
	}

}

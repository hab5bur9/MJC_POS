package pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Creators extends JFrame implements ActionListener{

	JButton btn_ER, btn_cancel;
	Creators(){
		//프레임 기본 설정
		setTitle("메인메뉴");
		setSize(300, 400);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌

		Container ct = getContentPane();
		ct.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));

		JLabel lab_team = new JLabel("무적함대");
		ct.add(lab_team);

		String[] students = {"2019081017 서현승", "2019081038 임경빈", "2021081042 박지환", "2021081048 선지성", "2021081064 유장호"};
		JLabel lab_creators[] = new JLabel[5];
		for(int i = 0;i<5 ; i++) {
			lab_creators[i] = new JLabel(students[i]);
			ct.add(lab_creators[i]);
		}

		btn_ER = new JButton("DB E-R 다이어그램");
		btn_ER.addActionListener(this); //버튼 클릭 시 E-R 다이어그램 창 출력
		ct.add(btn_ER);

		btn_cancel = new JButton("닫기");
		btn_cancel.addActionListener(this);
		ct.add(btn_cancel);


		ct.revalidate();
		ct.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  btn_ER)
			new DataBase();
		else if(e.getSource() == btn_cancel)
			dispose();
	}

}

class DataBase extends JFrame implements ActionListener{
	DataBase(){
		//프레임 기본 설정
		setTitle("메인메뉴");
		setSize(1200,900);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 안정적으로 JFrame이 종료되게 해줌

		//DataBase의 E-R 다이어그램을 화면에 출력
		ImageIcon img_ER = new ImageIcon("images/DB.png");
		Image ERChangeImg = img_ER.getImage().getScaledInstance(1150,850, Image.SCALE_SMOOTH);
		JButton btn_ER = new JButton(new ImageIcon(ERChangeImg));
		btn_ER.addActionListener(this); //화면 클릭 시 창 닫힘
		add(btn_ER);

		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}


}


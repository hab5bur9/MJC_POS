package pos;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;

public class Frame_SalesInquiry extends JFrame {
	JPanel pan1, pan2, pan3, pan_calendar;
	JLabel day_of_the_week, year_and_month, blank;
	JButton day, next, back;
	String[] week = {"일", "월", "화", "수", "목", "금", "토"};
	ImageIcon img = new ImageIcon("./images/next.png");
	ImageIcon img2 = new ImageIcon("./images/back.png");
	String y_str, m_str;
	int year, month, n, lastday;
	Calendar now;
	static String select_date;
	
	Frame_SalesInquiry(){
		
		//프레임 기본 설정
		setTitle("매출 조회");
		setSize(1200,900);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌
		
//		Container ct = getContentPane();
//		ct.setLayout(null); //setBounds 사용하기 위해 null
		setLayout(null);

		now = Calendar.getInstance();
		year = now.get(Calendar.YEAR); 
		y_str = year + "";
		month = now.get(Calendar.MONTH) +1; 
		m_str = month + "";
		
		pan1 = new JPanel();
		pan1.setBounds(0, 0, 330, 30);
		pan1.setBackground(Color.white);
		add(pan1);
		
		next = new JButton(img);
		next.setBorderPainted(false); // 버튼 테두리 설정 해제
		next.setPreferredSize(new Dimension(20, 20));
		
		back = new JButton(img2);
		back.setBorderPainted(false);
		back.setPreferredSize(new Dimension(20, 20));	
		
		year_and_month = new JLabel(y_str + "년 " + m_str + "월 ");
		
		// 년, 월, 전 월, 다음 월 component 있는 panel 생성
		pan1.add(back);
		pan1.add(year_and_month);
		pan1.add(next);

		
		
	}
	
		public static void main(String[] args) {
		new Frame_SalesInquiry();
	}
}


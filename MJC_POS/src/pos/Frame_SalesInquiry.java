package pos;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;

public class Frame_SalesInquiry extends JFrame {
	Frame_SalesInquiry(){
		//프레임 기본 설정
		setTitle("매출조회");
		setSize(500, 800);
		setVisible(true);
		setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
		setResizable(false);//정해진사이즈에서 변경불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌
				
		Container ct = getContentPane();
		ct.setLayout(null); //setBounds 사용하기 위해 null
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Frame_SalesInquiry();
	}
}

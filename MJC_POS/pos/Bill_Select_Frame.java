package pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import pos.SalesInquiry_Frame.MyActionListener;

public class Bill_Select_Frame extends JFrame implements ActionListener{
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
	   
	Bill_Select_Frame(){
		
		setTitle("영수증 조회");
		
		LineBorder lineb = new LineBorder(Color.black , 2);
		
		JPanel main_panel = new JPanel();
		
		JPanel deal_product_panel = new JPanel();
		JPanel deal_product_label_panel = new JPanel();
		JLabel deal_product_label = new JLabel("거래 상품 검색");
	
		deal_product_label_panel.setBorder(lineb);
		
		JPanel deal_breakdown_panel = new JPanel();
		JPanel deal_breakdown_label_panel = new JPanel();
		JLabel deal_breakdown_label = new JLabel("거래 내역 검색");
		deal_breakdown_label_panel.setBorder(lineb);
		
		JPanel calender_panel = new JPanel();
		JPanel product_detail_panel = new JPanel();
		
		JButton btn_back = new JButton("돌아가기");
		
		JPanel btn_panel = new JPanel();
		JButton bill_output = new JButton("영수증 출력");
		JButton refund = new JButton("환불");
		bill_output.setPreferredSize(new Dimension(230 , 110));
		refund.setPreferredSize(new Dimension(230 , 110));
		btn_panel.add(bill_output);
		btn_panel.add(refund);
		
		
		add(main_panel);
		main_panel.setLayout(null);
		main_panel.setBackground(Color.white);	
		main_panel.add(btn_back);
		btn_back.setBounds(1100,0,100,30);
		
		
		main_panel.add(deal_product_panel);
		deal_product_panel.setLayout(null);
		deal_product_panel.add(deal_product_label_panel);
		deal_product_panel.setBounds(50 , 50 , 350 , 790);
		deal_product_label_panel.add(deal_product_label);
		deal_product_label_panel.setBounds(0 , 0 , 350 , 80);
		deal_product_label_panel.setBackground(Color.white);
		deal_product_label_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,16));
		deal_product_label.setFont(new Font("맑은 고딕" , Font.BOLD , 30));
		
		
		
		main_panel.add(deal_breakdown_panel);
		deal_breakdown_panel.setLayout(null);
		deal_breakdown_panel.add(deal_breakdown_label_panel);
		deal_breakdown_panel.setBounds(450 , 50 , 350 , 790);
		deal_breakdown_label_panel.add(deal_breakdown_label);
		deal_breakdown_label_panel.setBounds(0,0,350,80);
		deal_breakdown_label_panel.setBackground(Color.white);
		deal_breakdown_label_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,16));
		deal_breakdown_label.setFont(new Font("맑은 고딕" , Font.BOLD , 30));
		
			
		
		main_panel.add(calender_panel);
		calender_panel.setBounds(840, 50 , 325 , 350);
		calender_panel.setLayout(null);
	      now = Calendar.getInstance();
	      year = now.get(Calendar.YEAR); 
	      y_str = year + "";
	      month = now.get(Calendar.MONTH) +1; 
	      m_str = month + "";

	      pan1 = new JPanel();
	      pan1.setBounds(0, 0, 330, 30);
	      pan1.setBackground(Color.lightGray);
	      calender_panel.add(pan1);

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

	      // 일~월 component 있는 panel 생성
	      pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	      pan2.setBackground(Color.lightGray);
	      pan2.setBounds(0, 30, 330, 30);
	      calender_panel.add(pan2);
	      for(int i = 0 ; i < 7 ; i++) {
	         day_of_the_week = new JLabel(week[i]);
	         day_of_the_week.setHorizontalAlignment(JLabel.CENTER);
	         day_of_the_week.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	         day_of_the_week.setPreferredSize(new Dimension(40, 20));
	         pan2.add(day_of_the_week);   
	      }

	      // 현재 날짜의 달력 출력
	      pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	      pan3.setBackground(Color.lightGray);
	      pan3.setBounds(0, 60, 330, 300);
	      calender_panel.add(pan3);
	      day = new JButton();
	      create_calendar();

	      // next 버튼 클릭 시 다음 달로 넘어가는 이벤트
	      next.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if(month == 12) {
	               month = 1; m_str = month + "";
	               year += 1; y_str = year + "";
	            }
	            else {
	               month += 1; m_str = month + "";
	            }
	            year_and_month.setText(y_str + "년 " + m_str + "월 ");
	            replace_calendar();
	         }
	      });

	      // back 버튼 클릭 시 이전 달로 넘어가는 이벤트
	      back.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            if(month == 1) {
	               month = 12; m_str = month + "";
	               year -= 1; y_str = year + "";
	            }
	            else {
	               month -= 1; m_str = month + "";
	            }
	            year_and_month.setText(y_str + "년 " + m_str + "월 ");
	            replace_calendar();
	         }
	      });

		main_panel.add(product_detail_panel);
		product_detail_panel.setBounds(840 , 410 , 325 , 180);
		
		main_panel.add(btn_panel);
		btn_panel.setBounds(850 , 580 , 300 , 300);
		btn_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10, 20));
		btn_panel.setBackground(Color.white);
		
		
		
		
		setResizable(false);
	    setVisible(true);
 	 	setSize(1200 , 900);
 	 	setPreferredSize(new Dimension(500 , 840 /12 * 9)); 
	 	setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	   // 달력 교체
	   void replace_calendar() {
	      pan3.removeAll();
	      create_calendar();
	      repaint();
	   }

	   //오늘 기준으로 전 날들은 선택 불가능
	   void create_calendar() {
	      now.set(year, month-1, 1);
	      n = now.get(Calendar.DAY_OF_WEEK)-1; // 달력에서 한주의 끝을 알기 위한 변수 설정
	      // 1일까지의 공백 출력
	      for(int i = 0; i<7; i++) {
	         if(n == i)
	            break;
	         blank = new JLabel();
	         blank.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	         blank.setPreferredSize(new Dimension(40, 40));
	         pan3.add(blank);
	      }
	      lastday = now.getActualMaximum(Calendar.DATE); // 입력 받은 월의 마지막 날
	      // 달력 출력
	      for(int i = 1; i <= lastday; i++) {
	         day = new JButton(i+"");
	         day.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	         day.setPreferredSize(new Dimension(40, 40));
	         pan3.add(day);
	         day.addActionListener(new MyActionListener());
	      }
	      day.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	      day.setPreferredSize(new Dimension(40, 40));
	   }

	   // 날짜 선택 시 메세지 창 출력
	   class MyActionListener implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	         JButton b = (JButton)e.getSource();
	         select_date = year + "년 " + month + "월 " + b.getText()+"일";
	         JOptionPane.showMessageDialog(null, "날짜가 선택 되었습니다.");
	      }     
	   }
	   
	public static void main(String[] args) {

		new Bill_Select_Frame();
	}

}	

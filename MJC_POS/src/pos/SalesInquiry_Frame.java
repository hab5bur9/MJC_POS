package pos;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;

public class SalesInquiry_Frame extends JFrame {
   JPanel pan1, pan2, pan3, pan_calendar, pan_periodSet;
   JLabel day_of_the_week, year_and_month, blank;
   JButton day, next, back;
   String[] week = {"일", "월", "화", "수", "목", "금", "토"};
   ImageIcon img = new ImageIcon("./images/next.png");
   ImageIcon img2 = new ImageIcon("./images/back.png");
   String y_str, m_str;
   int year, month, n, lastday;
   Calendar now;
   static String select_date;

   SalesInquiry_Frame(){

      //프레임 기본 설정
      setTitle("매출 조회");
      setSize(1200,900);
      setVisible(true);
      setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
      setResizable(false);//정해진사이즈에서 변경불가
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌

      Container ct = getContentPane();
      ct.setLayout(null); //setBounds 사용하기 위해 null

      JButton btn_back = new JButton("돌아가기");
      btn_back.setBounds(1090,0,100,30);
      btn_back.addActionListener(new Event_back());
      ct.add(btn_back);

      now = Calendar.getInstance();
      year = now.get(Calendar.YEAR); 
      y_str = year + "";
      month = now.get(Calendar.MONTH) +1; 
      m_str = month + "";

      pan1 = new JPanel();
      pan1.setBounds(100, 100, 330, 30);
      pan1.setBackground(Color.lightGray);
      ct.add(pan1);

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
      pan2.setBounds(100, 130, 330, 30);
      ct.add(pan2);
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
      pan3.setBounds(100, 160, 330, 300);
      ct.add(pan3);
      day = new JButton();
      create_calendar();

      //      Font font = new Font("맑은 고딕",Font.PLAIN , 5);
      //      day.setFont(font);

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

      String[] month_set = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
      String[] day_set = new String[31];
      for(int i=0; i<day_set.length; i++)
         day_set[i] = (i+1)+"일";

      pan_periodSet = new JPanel();
      pan_periodSet.setBounds(550, 50, 470, 200);
      pan_periodSet.setBackground(Color.lightGray);
      pan_periodSet.setLayout(null);
      ct.add(pan_periodSet);

      JLabel lab1 = new JLabel("조회 기간 설정");
      lab1.setBounds(200, 10, 150, 30);
      pan_periodSet.add(lab1);

      JComboBox jcb_month = new JComboBox(month_set);
      jcb_month.setBounds(50, 50, 70, 30);
      pan_periodSet.add(jcb_month);
      JComboBox jcb_day = new JComboBox(day_set);
      jcb_day.setBounds(150, 50, 70, 30);
      pan_periodSet.add(jcb_day);

      JLabel lab2 = new JLabel("~");
      lab2.setBounds(230, 50, 10, 30);
      pan_periodSet.add(lab2);

      JComboBox jcb_month2 = new JComboBox(month_set);
      jcb_month2.setBounds(250, 50, 70, 30);
      pan_periodSet.add(jcb_month2);
      JComboBox jcb_day2 = new JComboBox(day_set);
      jcb_day2.setBounds(350, 50, 70, 30);
      pan_periodSet.add(jcb_day2);

      JPanel pan_info = new JPanel();
      pan_info.setBounds(550, 300, 470, 400);
      pan_info.setBackground(Color.lightGray);
      ct.add(pan_info);

      JLabel lab3 = new JLabel("정보 나오는 패널");
      pan_info.add(lab3);

      JButton btn_search = new JButton("조   회");
      btn_search.setBounds(650, 720, 270, 50);
      ct.add(btn_search);
      ct.revalidate();
      ct.repaint();

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
   
   //메인메뉴로 돌아가는 이벤트
   class Event_back implements ActionListener{
	   @Override
	   public void actionPerformed(ActionEvent e) {
		   dispose();
		   new MainMenu_Frame();
	   }
   }

   public static void main(String[] args) {
      new SalesInquiry_Frame();
   }
}

package pos;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Frame_Calendar extends JFrame implements ActionListener {
   JPanel pan1, pan2, pan3, pan4;
   JLabel day_of_the_week, year_and_month, blank;
   JButton day, next, back, btn_cancel;
   String[] week = {"일", "월", "화", "수", "목", "금", "토"};
   ImageIcon img = new ImageIcon("./images/next.png");
   ImageIcon img2 = new ImageIcon("./images/back.png");
   String y_str, m_str;
   int year, month, n, lastday;
   Calendar now;
   static String select_date;

   Frame_Calendar(){
      setTitle("달력"); // 프레임 창 제목
      setLayout(new FlowLayout(FlowLayout.LEFT));
      now = Calendar.getInstance();
      year = now.get(Calendar.YEAR); y_str = year + "";
      month = now.get(Calendar.MONTH) +1; m_str = month + "";

      pan1 = new JPanel();
      pan1.setPreferredSize(new Dimension(330, 30));

      next = new JButton(img);
      next.setBorderPainted(false); // 버튼 테두리 설정 해제
      next.setPreferredSize(new Dimension(20, 20));

      back = new JButton(img2);
      back.setBorderPainted(false);
      back.setPreferredSize(new Dimension(20, 20));   

      year_and_month = new JLabel(y_str + "년 " + m_str + "월 ");

      // 년, 월, 전 월, 다음 월 component 있는 panel 생성
      add(pan1);
      pan1.add(back);
      pan1.add(year_and_month);
      pan1.add(next);

      // 일~월 component 있는 panel 생성
      pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pan2.setPreferredSize(new Dimension(345, 20));
      add(pan2);
      for(int i = 0 ; i < 7 ; i++) {
         day_of_the_week = new JLabel(week[i]);
         day_of_the_week.setHorizontalAlignment(JLabel.CENTER);
         day_of_the_week.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
         day_of_the_week.setPreferredSize(new Dimension(40, 20));
         pan2.add(day_of_the_week);   
      }

      // 현재 날짜의 달력 출력
      pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pan3.setPreferredSize(new Dimension(345, 280));
      add(pan3);
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

      pan4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      pan4.setPreferredSize(new Dimension(345, 100));
      add(pan4);
      btn_cancel = new JButton("닫기");
      btn_cancel.addActionListener(this);
      pan4.add(btn_cancel);

      // frame setting
      setSize(350, 425); // frame size
      setResizable(false); // 프레임 크기 변경 가능 여부
      setLocationRelativeTo(null); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 시 프로그램 종료
      setVisible(true); // 프레임 나타남 여부
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

   // 날짜 선택 시 선택된 날짜 출력
   class MyActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         JButton b = (JButton)e.getSource();
         select_date = year + "년 " + month + "월 " + b.getText()+"일";
         JOptionPane.showMessageDialog(null, select_date);
      }     
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      dispose();
   }

   public static void main(String[] args) {
      new Frame_Calendar();
   }
}

package pos;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.awt.*;

public class Frame_MainMenu extends JFrame{
   JButton[] btn_group, btn_group2;
   JButton btn_staffChange;
   Frame_MainMenu(){
      //프레임 기본 설정
      setTitle("메인메뉴");
      setSize(1200,900);
      setVisible(true);
      setLocationRelativeTo(null);// 화면 가운데서 창이 나옴
      setResizable(false);//정해진사이즈에서 변경불가
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 안정적으로 JFrame이 종료되게 해줌

      Container ct = getContentPane();
      ct.setLayout(null); //setBounds 사용하기 위해 null

      //관리자 전용 버튼을 위한 변수
      //true일 경우 관리자 전용 버튼 클릭 가능 , false일 경우 관리자 전용 버튼 클릭 불가능
      Boolean adminChecked = false;      

      JPanel p_notice = new JPanel();
      p_notice.setLayout(null);
      p_notice.setBackground(Color.red);
      p_notice.setBounds(30, 0, 570, 200);

      JPanel p_info = new JPanel();
      p_info.setLayout(null);
      p_info.setBackground(Color.green);
      p_info.setBounds(630, 0, 300, 200);

      ImageIcon staffImage = new ImageIcon("images/staff1.jpg");
      Image staffChangeImg = staffImage.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
      JButton btn_staff = new JButton(new ImageIcon(staffChangeImg));
      btn_staff.setBounds(1000,10,100,130);

      btn_staffChange = new JButton("근무자 변경");
      btn_staffChange.addActionListener(new Event_btn());
      btn_staffChange.setBounds(950, 150, 200, 50);

      ct.add(p_notice);
      ct.add(p_info);
      ct.add(btn_staff);
      ct.add(btn_staffChange);

      //알림창 패널 안에 알림 내용 출력하는 컴포넌트 추가
      JLabel lab_notice[] = new JLabel[4];
      for(int i = 0; i<4; i++) {
         lab_notice[i] = new JLabel("안녕하세요 알림창입니다아아아아ㅏ아아아아아아아아아아");
         lab_notice[i].setBounds(0, i*50, 570, 50);
         p_notice.add(lab_notice[i]);
      }

      //정보창 패널 안에 현재 시간, 근무 시간, 근무자 코드 출력하는 JLabel 생성
      JLabel lab_info[] = new JLabel[3]; // index 0 => 현재 시간, index 1 => 근무 시간, index 2 => 근무자 코드
      lab_info[0] = new JLabel("현재 시간");
      lab_info[1] = new JLabel("근무 시간");
      lab_info[2] = new JLabel("근무자 코드");
      for(int i = 0; i<3; i++) {
         lab_info[i].setBounds(0, i*60, 300, 60);
         p_info.add(lab_info[i]);
      }

      //두번째 열 버튼 공간 설정
      JPanel p_btnGroup = new JPanel();
      p_btnGroup.setBounds(30, 250, 1140, 250);
      p_btnGroup.setBackground(Color.DARK_GRAY);
      p_btnGroup.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 5));
      ct.add(p_btnGroup);

      //두번째 열 버튼 생성
      btn_group = new JButton[4];
      String[] btnNames = {"판매", "영수증 조회", "발주", "재고 관리"};
      for(int i=0; i<4; i++) {
         btn_group[i] = new JButton(btnNames[i]);
         btn_group[i].setPreferredSize(new Dimension(250, 240));
         btn_group[i].addActionListener(new Event_btn());
         p_btnGroup.add(btn_group[i]);
      }

      //상품 검색 영역 생성
      JPanel p_search = new JPanel();
      p_search.setBackground(Color.CYAN);
      p_search.setBounds(30, 550, 570, 300);
      p_search.setLayout(null);
      ct.add(p_search);

      HintTextField jtf_search = new HintTextField("상품 코드를 입력하세요.");
      jtf_search.setBounds(25, 10, 520, 50);
      p_search.add(jtf_search);

      JLabel lab_searchInfo = new JLabel("상세 정보");
      lab_searchInfo.setBounds(25, 80, 520, 200);
      p_search.add(lab_searchInfo);

      //직전 결제 내역을 확인할 수 있는 영역 생성
      JPanel p_previousPayment = new JPanel();
      p_previousPayment.setLayout(null);
      p_previousPayment.setBounds(630, 550, 540, 200);
      p_previousPayment.setBackground(Color.orange);
      ct.add(p_previousPayment);

      JLabel lab_previousPayment = new JLabel("직전 결제 내역");
      lab_previousPayment.setBounds(10, 10, 100, 20);
      p_previousPayment.add(lab_previousPayment);

      JButton btn_receiptPrint = new JButton("영수증 출력");
      btn_receiptPrint.setBounds(420, 10, 100, 30);
      p_previousPayment.add(btn_receiptPrint);

      JLabel[] lab_paymentInfo = new JLabel[2];
      String[] paymentInfo = {"결제 시간", "결제한 금액"};
      for(int i=0; i<2; i++) {
         lab_paymentInfo[i] = new JLabel(paymentInfo[i]);
         lab_paymentInfo[i].setBounds(20, 50*(i+1), 500, 60);
         p_previousPayment.add(lab_paymentInfo[i]);
      }

      btn_group2 = new JButton[6];
      String[] btnNames2 = {"관리자 전용", "되돌리기", "직원 관리", "캘린더", "매출 조회", "만든이들"};
      for(int i=0; i<btn_group2.length; i++) {
         btn_group2[i] = new JButton(btnNames2[i]);
         btn_group2[i].setBounds(630+(i/2*190), 770, 160, 80);
         if(i%2 == 1)
            btn_group2[i].setVisible(false);
         if(i>1)
            btn_group2[i].addActionListener(new Event_btn());
         ct.add(btn_group2[i]);
      }
      btn_group2[0].addActionListener(new Event_btnChange());
      btn_group2[1].addActionListener(new Event_btnChange());
      btn_group2[0].setEnabled(adminChecked);

      ct.revalidate();
      ct.repaint();

      //실시간 시간 출력
      while(true) {//무조건 실행
         Calendar t=Calendar.getInstance();
         int amPm = t.get(Calendar.AM_PM);//오전/오후를 받아온다
         int hour = t.get(Calendar.HOUR);//시를 받아온다
         int min = t.get(Calendar.MINUTE);//분을 받아온다
         int sec = t.get(Calendar.SECOND);//초를 받아온다
         String ampm=amPm==Calendar.AM? "PM":"AM";//비교해서 pm이나 am을 ampm에 저장
         String time=(ampm+" "+hour+":"+min+":"+sec+" sec");//time라는 문자열에 저장
         lab_info[0].setText(time);//second의 내용을 time(string)으로 설정한다.
         //실시간 시간을 반영하기 위해 0.1초마다 lab_time을 repaint
         try { //트라이 
            Thread.sleep(1000);//0.1초
            lab_info[0].repaint();
         } catch(Exception e) {} //예외처리
      }//while문 끝
   }

   //관리자 전용 버튼과 되돌리기 버튼 클릭 시 화면을 구성하는 버튼 변경
   private class Event_btnChange implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btn_group2[0]) {
            for(int i = 0; i<btn_group2.length; i++) {
               if(i%2 == 1)
                  btn_group2[i].setVisible(true);
               else
                  btn_group2[i].setVisible(false);   
            }
         }
         else if(e.getSource() == btn_group2[1]){
            for(int i = 0; i<btn_group2.length; i++) {
               if(i%2 == 1)
                  btn_group2[i].setVisible(false);
               else
                  btn_group2[i].setVisible(true);   
            }
         }   
      }
   }

   //각 버튼 클릭 시 화면에 해당하는 프레임 출력
   private class Event_btn implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btn_staffChange)
            new StaffChange();
         else if(e.getSource() ==  btn_group[0])
            ;//판매 프레임
         else if(e.getSource() == btn_group[1])
            ;//영수증 조회 프레임
         else if(e.getSource() == btn_group[2])
            ;//발주 프레임
         else if(e.getSource() == btn_group[3])
            ;//재고 관리 프레임
         else if(e.getSource() == btn_group2[2])
            ;//직원 관리 프레임
         else if(e.getSource() == btn_group2[3])
            new Frame_Calendar();//캘린더 프레임
         else if(e.getSource() == btn_group2[4])
            ;//매출 조회 프레임
         else if(e.getSource() == btn_group2[5])
            new Creators_Frame();//만든이들 프레임
      }
   }

   public static void main(String[] args) {
      new Frame_MainMenu();
   }
}
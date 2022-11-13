package pos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Frame_MainMenu extends JFrame{
	
	Frame_MainMenu(){
		//프레임 기본 설정
		setTitle("메인메뉴");
		setSize(1200,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(null); //setBounds 사용하기 위해 null
		
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
		
		JButton btn_staffChange = new JButton("근무자 변경");
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
		JButton[] btn_group = new JButton[4];
		String[] btnNames = {"판매", "영수증 조회", "발주", "재고 관리"};
		for(int i=0; i<4; i++) {
			btn_group[i] = new JButton(btnNames[i]);
			btn_group[i].setPreferredSize(new Dimension(250, 240));
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
		
		//관리자 전용, 직원 관리, 매출 조회, 캘린더, 만든이 버튼 생성
		JButton btn_admin = new JButton("관리자 전용");
		btn_admin.setBounds(630, 770, 160, 80);
		ct.add(btn_admin);
		
		JButton btn_staffManagement = new JButton("직원 관리");
		btn_staffManagement.setBounds(820, 770, 160, 80);
		ct.add(btn_staffManagement);
		
		JButton btn_salesInquiry = new JButton("매출 조회");
		btn_salesInquiry.setBounds(1010, 770, 160, 80);
		ct.add(btn_salesInquiry);
		
		JButton btn_calendar = new JButton("캘린더");
		btn_calendar.setBounds(820, 770, 160, 80);
		ct.add(btn_calendar);
		
		JButton btn_madeBy = new JButton("만든이들");
		btn_madeBy.setBounds(1010, 770, 160, 80);
		ct.add(btn_madeBy);
		
		ct.revalidate();
		ct.repaint();
	}
	
	public static void main(String[] args) {
		new Frame_MainMenu();
	}
	

public class HintTextField extends JTextField {  

	  

	  Font gainFont = new Font("굴림", Font.PLAIN, 15);  

	  Font lostFont = new Font("굴림", Font.ITALIC, 15);  

	  

	  public HintTextField(final String hint) {  

	  

	    setText(hint);  

	    setFont(lostFont);  

	    setForeground(Color.GRAY);  

	  

	    this.addFocusListener(new FocusAdapter() {  

	  

	      @Override  

	      public void focusGained(FocusEvent e) {  

	        if (getText().equals(hint)) {  

	          setText("");  

	          setFont(gainFont);  

	        } else {  

	          setText(getText());  

	          setFont(gainFont);  

	        }  

	      }  

	  

	      @Override  

	      public void focusLost(FocusEvent e) {  

	        if (getText().equals(hint)|| getText().length()==0) {  

	          setText(hint);  

	          setFont(lostFont);  

	          setForeground(Color.GRAY);  

	        } else {  

	          setText(getText());  

	          setFont(gainFont);  

	          setForeground(Color.BLACK);  

	        }  

	      }  



	    });  

	  

	  }  

	}  


}

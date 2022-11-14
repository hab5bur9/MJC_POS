package pos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class order_page extends JFrame{
	
	private JList 	list_orderList,
			list_checkedList;
		
	
	/*private JButton btn_add,
			btn_delete,
			btn_orderConfirm,
			btn_orderTap,
			btn_recommendTap,
			btn_calNum[] ;*/
	
	private JTextField 	jtf_searchProduct,
				jtf_inputNum,
				jtf_totalPrice;
	private JTextArea jta_productInformation;
	
	private JPanel panelWest,panelCenter,panelEast;
	
	public order_page() {
		mkSetting(); // make page setting
		mkSwings(); // make Swings components
	    mkPanels();//panel create and add
	}
	private JPanel mkCalculor() { // 계산 버튼 생성 메서드
		JPanel ex = new JPanel(new GridLayout(1,final_String.CALCULOR.length));
		btn_calNum = new JButton[final_String.CALCULOR.length];
		
		for(int i=0;i<final_String.CALCULOR.length;i++) {
			btn_calNum[i] = new JButton(final_String.CALCULOR[i]);
			ex.add(btn_calNum[i]);
		}
		return ex;
		
	}
	private void mkSetting() { // 페이지 크기 셋팅 메서드
		setSize(final_Layout.PAGE_WIDTH,final_Layout.PAGE_HEIGHT);
		setVisible(true); 
		setTitle(final_String.ORDERMENU_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void mkSwings() { // Swing 컴포넌트 생성 메서드
			// list create
			list_orderList = new JList(final_Test.EXLIST); // 발주 품목 list
			list_orderList.setPreferredSize(new Dimension(490,700));
			list_checkedList = new JList(final_Test.EXLIST); // 선택된 품목 list 
			list_checkedList.setPreferredSize(new Dimension(290,600));
			
				
			// button create
			btn_add = new JButton(final_String.ORDERMENU_ADD);// 추가 버튼
			btn_add.setPreferredSize(new Dimension(190,50));
			
			btn_delete = new JButton(final_String.ORDERMENU_DELETE); // 삭제 버튼
			btn_delete.setPreferredSize(new Dimension(190,50));
				
			btn_orderConfirm = new JButton(final_String.ORDERMENU_CONFRIM); 
			btn_orderConfirm.setPreferredSize(new Dimension(290,50));// 발주 버튼
				
			btn_orderTap=new JButton(final_String.ORDERMENU_ORDERR_TAP);				
			btn_orderTap.setPreferredSize(new Dimension(200,30));
				
			
			btn_recommendTap = new JButton(final_String.ORDERMENU_RECOMMEND_TAP);
			btn_recommendTap.setPreferredSize(new Dimension(200,30));
				
			//text field create
			jtf_searchProduct = new JTextField("품목 검색");
			jtf_searchProduct.setPreferredSize(new Dimension(490,50));
			jtf_inputNum = new JTextField("수량 입력");
			jtf_inputNum.setPreferredSize(new Dimension(390,50));
			jtf_totalPrice = new JTextField("총 금액");
			jtf_totalPrice.setEditable(false);
			
				
			jta_productInformation = new JTextArea(final_String.PLZ_COOSE_PRODUCT);
			jta_productInformation.setPreferredSize(new Dimension(390,500));
	}
	private void mkPanels() { // 패널 생성, 적용메서드 and panels Layout
		// header panel layout create
		pageHeader hd = new pageHeader();
		Border bd = BorderFactory.createEmptyBorder(final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER);
		
		JPanel btnColect = new JPanel(new GridLayout(1,2)); //추가 삭제 버튼 패널
		
		btnColect.add(btn_add);
		btnColect.add(btn_delete);
		btnColect.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		
		JPanel btnTap = new JPanel(new GridLayout(1,2));  // 발주,추천 메뉴 패
		btnTap.add(btn_orderTap);
		btnTap.add(btn_recommendTap);
		btnTap.setBackground(final_Layout.HEADER_BACKGROUND);
		hd.header.add(btnTap,BorderLayout.WEST);
		
			// make buttons of calculor
		JPanel btnCalculor = new JPanel(new GridLayout(1,4));
		btnCalculor = mkCalculor();
		btnCalculor.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		JPanel btnColect2 = new JPanel(new BorderLayout());
		btnColect2.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		btnColect2.add(btnCalculor,BorderLayout.NORTH);
		btnColect2.add(jtf_inputNum,BorderLayout.CENTER);
		btnColect2.add(btnColect,BorderLayout.SOUTH);
		//make west panel
		panelWest = new JPanel(new BorderLayout());  // West main panel
		panelWest.setBorder(bd);
		panelWest.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		panelWest.add(jtf_searchProduct,BorderLayout.NORTH);
		panelWest.add(list_orderList,BorderLayout.CENTER);
		
		//make center panel
		panelCenter = new JPanel(new BorderLayout()); // center main panel
		panelCenter.setBorder(bd);
		panelCenter.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		panelCenter.add(jta_productInformation,BorderLayout.NORTH);
		panelCenter.add(btnColect2,BorderLayout.SOUTH);
		
		//make east panel
		panelEast = new JPanel(new BorderLayout());// east main panel
		panelEast.setBorder(bd);
		panelEast.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		panelEast.add(list_checkedList,BorderLayout.NORTH);
		panelEast.add(jtf_totalPrice,BorderLayout.CENTER);
		panelEast.add(btn_orderConfirm,BorderLayout.SOUTH);
		
		
		Container ct = getContentPane();
		
		ct.setLayout(new BorderLayout());
		ct.add(hd.header,BorderLayout.NORTH);
		ct.add(panelWest,BorderLayout.WEST);
		ct.add(panelCenter,BorderLayout.CENTER);
		ct.add(panelEast,BorderLayout.EAST);
	}
		
}
package pos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Order_Frame extends JFrame {
	Connection con;
	private JPanel panelWest,panelCenter,panelEast;
	
	private JTextArea jta_productInformation;
	
	private JTextField jtf_inputNum,jtf_totalPrice;
					
	JList list_orderList;
	
	public Order_Frame() {
		try {
			con = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/POS" , "root" , "root");
			
			
			
			}catch(Exception e) {};
			Border bd = BorderFactory.createEmptyBorder(final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER,final_Layout.PANEL_BORDER);
			
			CardLayout cl = new CardLayout(10,10);
			panelWest = new JPanel(cl);
			panelWest.setBorder(bd);
			panelWest.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
			
			panelWest.add(orderTap());
			panelWest.add(recommendTap());
			
			//make center panel
			panelCenter = check(); // center main panel
			panelCenter.setBorder(bd);
			panelCenter.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
	
			
			//make east panel
			panelEast = conform();// east main panel
			panelEast.setBorder(bd);
			panelEast.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
			
			
			Container ct = getContentPane();
			ct.setLayout(new BorderLayout());
			ct.add(header(cl),BorderLayout.NORTH);
			ct.add(panelWest,BorderLayout.WEST);
			ct.add(panelCenter,BorderLayout.CENTER);
			ct.add(panelEast,BorderLayout.EAST);
			
			
			setSize(final_Layout.PAGE_WIDTH,final_Layout.PAGE_HEIGHT);
			setVisible(true); 
			setTitle(final_String.ORDERMENU_TITLE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private JPanel check() {
		JPanel result;
		jta_productInformation = new JTextArea(final_String.PLZ_COOSE_PRODUCT);
		jta_productInformation.setPreferredSize(new Dimension(390,500));
		
		result = new JPanel(new BorderLayout());
		result.add(jta_productInformation,BorderLayout.NORTH);
		result.add(btnColect(),BorderLayout.SOUTH);
		return result;
	}
	private JPanel orderTap() {
		JPanel result;
		JList list_orderList;
		JTextField jtf_searchProduct ;
		
		list_orderList= new JList(final_Test.EXLIST); // ?????? ?????? list
		list_orderList.setPreferredSize(new Dimension(490,700));
		
		
		jtf_searchProduct = new JTextField("?????? ??????");
		jtf_searchProduct.setPreferredSize(new Dimension(490,50));
		
		
		result = new JPanel(new BorderLayout());
		result.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		result.add(jtf_searchProduct,BorderLayout.NORTH);
		result.add(list_orderList,BorderLayout.CENTER);
		return result;
	}
	private JPanel recommendTap() {
		JPanel result;
		JList list_recommendBest;
		JList list_recommendWorst; 
		list_recommendBest= new JList();
		list_recommendBest.setPreferredSize(new Dimension(220,700));
		list_recommendWorst = new JList();
		list_recommendWorst.setPreferredSize(new Dimension(220,700));
		
		
		result = new JPanel(new BorderLayout());
		result.add(list_recommendBest,BorderLayout.WEST);
		result.add(list_recommendWorst,BorderLayout.EAST);
		return result;
	}
	
	private JPanel btnColect() {
		JPanel result,btnAddDelete,btnCalculor;
		JButton btn_add,btn_delete,btn_calNum[];
		
		// button create
		btn_add = new JButton(final_String.ORDERMENU_ADD);// ?????? ??????	
		btn_add.setPreferredSize(new Dimension(190,50));
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		btn_delete = new JButton(final_String.ORDERMENU_DELETE); // ?????? ??????
		btn_delete.setPreferredSize(new Dimension(190,50));
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		btnAddDelete = new JPanel(new GridLayout(1,2));
		btnAddDelete.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		btnAddDelete.add(btn_add);
		btnAddDelete.add(btn_delete);
		
		btnCalculor  = new JPanel(new GridLayout(1,final_String.CALCULOR.length)); //?????? ??????
		btnCalculor.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		
		btn_calNum = new JButton[final_String.CALCULOR.length];
		
		for(int i=0;i<final_String.CALCULOR.length;i++) {
			btn_calNum[i] = new JButton(final_String.CALCULOR[i]);
			btn_calNum[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					
				}
			});
			btnCalculor.add(btn_calNum[i]);
		}
		
		jtf_inputNum = new JTextField("?????? ??????");
		jtf_inputNum.setPreferredSize(new Dimension(390,50));
		
		jtf_inputNum.addFocusListener(new FocusAdapter() { //?????? ?????????
			@Override
			public void focusGained(FocusEvent fe) {
				if (jtf_inputNum.getText().equals("?????? ??????")) 
			         jtf_inputNum.setText("");  
			}
		});
		
		result = new JPanel(new BorderLayout());
		result.setBackground(final_Layout.ORDERMENU_PANELCOLOR);
		result.add(btnCalculor,BorderLayout.NORTH);
		result.add(jtf_inputNum,BorderLayout.CENTER);
		result.add(btnAddDelete,BorderLayout.SOUTH);
		return result;
	}
	private JPanel conform() {
		JPanel result;
		JButton btn_orderConfirm;
		JList list_checkedList;
		
		list_checkedList = new JList(final_Test.EXLIST); // ????????? ?????? list 
		list_checkedList.setPreferredSize(new Dimension(290,600)); 
		
		btn_orderConfirm = new JButton(final_String.ORDERMENU_CONFRIM); 
		btn_orderConfirm.setPreferredSize(new Dimension(290,50));// ?????? ??????
		btn_orderConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		jtf_totalPrice = new JTextField("??? ??????");
		jtf_totalPrice.setEditable(false);
		
		result = new JPanel(new GridLayout(3,1));
		result.add(list_checkedList);
		result.add(jtf_totalPrice);
		result.add(btn_orderConfirm);
		return result;
	}
	private JPanel header(CardLayout cl) {
		JPanel result;
		JButton btn_tap;
		
		btn_tap=new JButton("??????");				
		btn_tap.setPreferredSize(new Dimension(200,30));
		btn_tap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				cl.next(panelWest);
				if(ae.getActionCommand().equals("??????"))
					btn_tap.setText("??????");
				else
					btn_tap.setText("??????");
			}
		});
		
		result = new pageHeader();
		result.add(btn_tap,BorderLayout.WEST);
		
		return result;
	}
}

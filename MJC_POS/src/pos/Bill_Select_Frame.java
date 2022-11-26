package pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Bill_Select_Frame extends JFrame implements ActionListener{
	
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
		bill_output.setPreferredSize(new Dimension(200 , 100));
		refund.setPreferredSize(new Dimension(200 , 100));
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
		deal_product_panel.setBounds(100 , 50 , 350 , 790);
		deal_product_label_panel.add(deal_product_label);
		deal_product_label_panel.setBounds(0 , 0 , 350 , 80);
		deal_product_label_panel.setBackground(Color.white);
		deal_product_label_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,16));
		deal_product_label.setFont(new Font("맑은 고딕" , Font.BOLD , 30));
		
		
		
		main_panel.add(deal_breakdown_panel);
		deal_breakdown_panel.setLayout(null);
		deal_breakdown_panel.add(deal_breakdown_label_panel);
		deal_breakdown_panel.setBounds(500 , 50 , 350 , 790);
		deal_breakdown_label_panel.add(deal_breakdown_label);
		deal_breakdown_label_panel.setBounds(0,0,350,80);
		deal_breakdown_label_panel.setBackground(Color.white);
		deal_breakdown_label_panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,16));
		deal_breakdown_label.setFont(new Font("맑은 고딕" , Font.BOLD , 30));
		
			
		
		main_panel.add(calender_panel);
		calender_panel.setBounds(900, 50 , 200 , 300);
		
		main_panel.add(product_detail_panel);
		product_detail_panel.setBounds(900 , 390 , 200 , 180);
		
		main_panel.add(btn_panel);
		btn_panel.setBounds(900 , 580 , 200 , 300);
		btn_panel.setLayout(new FlowLayout(FlowLayout.CENTER , 10, 30));
		btn_panel.setBackground(Color.white);
		
		
		
		
		setResizable(false);
	    setVisible(true);
 	 	setSize(1200 , 900);
 	 	setPreferredSize(new Dimension(500 , 840 /12 * 9)); 
	 	setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new Bill_Select_Frame();
	}

}	

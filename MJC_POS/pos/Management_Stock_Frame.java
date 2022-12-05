package pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Management_Stock_Frame extends JFrame{

	Container ct;
	JButton btn_disposal, btn_backMain, btn_serch; //폐기,돌아가기,검색 버튼
	JLabel lab_name, lab_cnt, lab_price, lab_code, lab_company, lab_shelf_life;  //상품정보
	JLabel[] lab_in = new JLabel[6];//, lab_cnt_in, lab_price_in, lab_code_in, lab_company_in, lab_shelf_life_in;  //상품정보 내용
	JLabel lab_cnt_su, lab_price_won;  //상품정보 추가내용
	JRadioButton [] rbtn_ctg = new JRadioButton[8];  //카테고리 버튼
	String [] ctg = {"과자", "음료", "유제품", "빵", "주류", "라면", "즉석식품", "생활용품"};
	JRadioButton [] rbtn_use = new JRadioButton[2];  //카테고리 버튼_2
	String [] use = {"유통기한 임박 제품", "유통기한 지난 제품"};
	JTextField jtf_search;   //상품정보
	JList list_stock, list_disposal;  //상품재고,폐기리스트

	Management_Stock_Frame(){
		ct = getContentPane();
		ct.setLayout(null);  //가로, 세로, 가로길이, 세로길이

		//텍스트_상품정보
		lab_name = new JLabel("상품명");
		lab_cnt = new JLabel("개수");
		lab_price = new JLabel("가격");
		lab_code = new JLabel("상품코드");
		lab_company = new JLabel("제조업체");
		lab_shelf_life = new JLabel("유통기한");
		//텍스트_상품정보_내용
		lab_in[0] = new JLabel("허니버터칩");
		lab_in[1] = new JLabel("100");
		lab_in[2] = new JLabel("30,000,000");
		lab_in[3] = new JLabel("FA302030");
		lab_in[4] = new JLabel("롯데제과");
		lab_in[5] = new JLabel("2022-11-11");
		//텍스트_상품정보_추가내용
		lab_cnt_su = new JLabel("개");
		lab_price_won = new JLabel("원");
		//텍스트_상품검색
		jtf_search = new JTextField();
		//폐기정보
		list_disposal = new JList();
		//버튼
		btn_disposal = new JButton("폐기처리");
		btn_backMain = new JButton("돌아가기");
		btn_serch = new JButton("검색");
		//리스트
		list_stock = new JList();
		//카테고리 버튼
		ButtonGroup r = new ButtonGroup();
		for(int i = 0; i < 8; i++){
			rbtn_ctg[i] = new JRadioButton(ctg[i]);
			r.add(rbtn_ctg[i]);
		}//for
		//분류 버튼
		ButtonGroup u = new ButtonGroup();
		for(int i = 0; i < 2; i++){
			rbtn_use[i] = new JRadioButton(use[i]);
			u.add(rbtn_use[i]);
		}//for

		//돌아가기
		btn_backMain.setBounds(1030, 30, 100, 30);
		ct.add(btn_backMain);
		//검색하기
		jtf_search.setBounds(150, 60, 250, 30);
		btn_serch.setBounds(410, 65, 40, 20);
		ct.add(btn_serch); ct.add(jtf_search);
		//재고리스트
		list_stock.setBounds(70, 100, 480, 570);
		ct.add(list_stock);
		//상품정보
		lab_name.setBounds(580, 100, 50, 30);
		lab_cnt.setBounds(580, 150, 50, 30);
		lab_price.setBounds(580, 200, 50, 30);
		lab_shelf_life.setBounds(580, 250, 50, 30);
		lab_code.setBounds(580, 300, 50, 30);
		lab_company.setBounds(580, 350, 50, 30);
		ct.add(lab_name); ct.add(lab_cnt); ct.add(lab_price);
		ct.add(lab_shelf_life); ct.add(lab_code); ct.add(lab_company);
		//상품정보 내용
		lab_in[0].setBounds(660, 100, 100, 30);
		lab_in[1].setBounds(660, 150, 40, 30);
		lab_in[2].setBounds(660, 200, 90, 30);
		lab_in[3].setBounds(660, 250, 100, 30);
		lab_in[4].setBounds(660, 300, 100, 30);
		lab_in[5].setBounds(660, 350, 100, 30);
		for(int i = 0; i < lab_in.length; i++){
			ct.add(lab_in[i]);
		}
		//상품정보 추가내용
		lab_price_won.setBounds(750, 200, 30, 30);
		lab_cnt_su.setBounds(700, 150, 30, 30);
		ct.add(lab_price_won); ct.add(lab_cnt_su);
		//폐기
		list_disposal.setBounds(930, 100, 200, 530);
		btn_disposal.setBounds(930, 640, 200, 70);
		ct.add(list_disposal); ct.add(btn_disposal);
		//카테고리 버튼
		rbtn_ctg[0].setBounds(560, 450, 90, 40);
		rbtn_ctg[1].setBounds(650, 450, 90, 40);
		rbtn_ctg[2].setBounds(740, 450, 90, 40);
		rbtn_ctg[3].setBounds(830, 450, 90, 40);
		rbtn_ctg[4].setBounds(560, 500, 90, 40);
		rbtn_ctg[5].setBounds(650, 500, 90, 40);
		rbtn_ctg[6].setBounds(740, 500, 90, 40);
		rbtn_ctg[7].setBounds(830, 500, 90, 40);
		for(int i = 0; i < 8; i++)ct.add(rbtn_ctg[i]);
		rbtn_use[0].setBounds(560, 580, 150, 50);
		rbtn_use[1].setBounds(740, 580, 150, 50);
		ct.add(rbtn_use[0]); ct.add(rbtn_use[1]);

		//이벤트처리
		//검색하기
		serch_Event ser = new serch_Event(jtf_search);
		btn_serch.addActionListener(ser);
		jtf_search.addActionListener(ser);
		//카테고리 버튼
		for(int i = 0; i < rbtn_ctg.length; i++){
			cate_Event_1 ct_1 = new cate_Event_1(rbtn_ctg[i], list_stock);
			rbtn_ctg[i].addItemListener(ct_1);
		}//for
		for(int i = 0; i < rbtn_use.length; i++){
			cate_Event_2 ct_2 = new cate_Event_2(rbtn_use[i], list_stock);
			rbtn_use[i].addItemListener(ct_2);
		}//for
		//폐기처리
		disposal_Event dis = new disposal_Event(btn_disposal, list_disposal);
		btn_disposal.addActionListener(dis);
		//돌아가기
		backMain_Event back = new backMain_Event();
		btn_backMain.addActionListener(back);
		
		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("title");
	}//생성자

	public static void main(String[] args) {
		new Management_Stock_Frame();
	}//main
}//Stock

//이벤트 메소드
class serch_Event implements ActionListener{ //검색하기

	JTextField jf;

	serch_Event(JTextField jf){
		this.jf = jf;
	}//생성자
	@Override
	public void actionPerformed(ActionEvent e) {

	}//actionPerformed
}//serch_Event

class cate_Event_1 implements ItemListener{ //카테고리 버튼

	JRadioButton ctg = new JRadioButton();
	JList jl = new JList();
	cate_Event_1(JRadioButton ctg, JList jl){
		this.ctg = ctg;
		this.jl = jl;
	}//생성자
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(ctg.equals("과자")){

		} else if (ctg.equals("음료")) {

		} else if(ctg.equals("유제품")){

		} else if (ctg.equals("빵")) {

		} else if (ctg.equals("주류")) {

		} else if (ctg.equals("라면")) {

		} else if (ctg.equals("즉석식품")) {

		} else if (ctg.equals("생활용품")) {

		} else{

		}//if_else
	}//itemStateChanged
}//cate_Event_1

class cate_Event_2 implements ItemListener{

	JRadioButton ctg_2 = new JRadioButton();
	JList jl_2 = new JList();
	cate_Event_2(JRadioButton ctg_2, JList jl_2){
		this.ctg_2 = ctg_2;
		this.jl_2 = jl_2;
	}//생성자
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(ctg_2.equals("유통기한 임박 제품")){

		}else if(ctg_2.equals("유통기한 지난 제품")){

		}else{

		}//if_else
	}//itemStateChanged
}//cate_Event_2

//상품 상세보기
class stock_in implements ListSelectionListener{
	JList jl_in = new JList();
	JLabel[] jlabel_in = new JLabel[6];
	stock_in(JList jl_in, JLabel[] jlabel_in){
		this.jl_in = jl_in;
		this.jlabel_in = jlabel_in;
	}//생성자
	@Override
	public void valueChanged(ListSelectionEvent e) {

	}//valieChanged
}//stock_in

//폐기처리 버튼
class disposal_Event implements ActionListener{
	JButton jb;
	JList jl_di;
	disposal_Event(JButton jb, JList jl_di){
		this.jb = jb;
		this.jl_di = jl_di;
	}//생성자
	@Override
	public void actionPerformed(ActionEvent e) {


	}//actionPerformed
}//disposal_Event

//돌아가기 버튼
class backMain_Event implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {

	}//actionPerformed
}//backMain_Event
package p1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Delete_Staff_Frame extends JFrame {
	String info[]= {"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi",
			"10hours n만원 Park","20hours n만원 Lee","33hours n만원 Choi"};//임의로 넣은 값임.나중에 db에서 가져오기
	JPanel main_panel=new JPanel();
	
	Delete_Staff_Frame(){
	
		for(int i=0;i<info.length;i++) {
			JRadioButton staff_button=new JRadioButton();
			JPanel staff_paneli=new JPanel();//asdasd
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

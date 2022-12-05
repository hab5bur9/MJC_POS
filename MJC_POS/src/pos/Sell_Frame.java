package pos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Sell_Frame extends JFrame implements ActionListener {


			int total;
			int payment;
						
			String first;
			JLabel current_time;
		    JPanel time_panel;

		    

		    Sell_Frame(){

        	setTitle("판매 테이블");
	
        	EmptyBorder border_empty = new EmptyBorder(5,3,5,3); //테두리 없는 border
		    BevelBorder border_bevel = new BevelBorder(BevelBorder.RAISED); // 튀어나온듯한 border
		    
        	
        	
        		JPanel main_panel = new JPanel();
			    JPanel button_panel = new JPanel();
				JPanel Product_list_panel = new JPanel();
				JPanel buy_panel = new JPanel();
				JPanel price_label_panel = new JPanel();
				price_label_panel.setBorder(border_bevel);
				time_panel = new JPanel();
				
				JButton btn_back = new JButton("돌아가기");
				JButton btn_cash = new JButton("현금");
				JButton btn_card = new JButton("신용카드");
				JButton btn_traffic_card = new JButton("교통카드");
				JButton btn_mobile = new JButton("모바일페이");
				JLabel  total_price = new JLabel("총 금액 : ");
				JTextArea buy_product = new JTextArea(10,9);
			
				current_time = new JLabel();
				

			add(main_panel);
			main_panel.setLayout(null);
			main_panel.setBackground(Color.white);
			main_panel.add(time_panel);
			time_panel.setLayout(new GridLayout());
			time_panel.setBounds(550 , 0 , 150 , 50);
			time_panel.add(current_time);
			
		    Time t = new Time(current_time , time_panel);
		    t.start();

				
			main_panel.add(button_panel);
			button_panel.setLayout(new FlowLayout(FlowLayout.LEFT , 100 , 0));
			button_panel.setBounds(60,700,1000, 150); //가로위치,세로위치,가로길이,세로길이
			
			button_panel.setBackground(Color.white);
		
			main_panel.add(Product_list_panel);
			Product_list_panel.setLayout(null);
			Product_list_panel.setBounds(650 , 100 , 410 , 500);
			
			Product_list_panel.add(buy_product);
			buy_product.setBounds(0,0,410,500);
			buy_product.setBackground(Color.green);
			
			
			
			main_panel.add(buy_panel);
			buy_panel.setLayout(null);
			buy_panel.setBounds(160 , 100 , 410	 , 500);
			buy_panel.setBackground(Color.green);
			buy_panel.add(price_label_panel);
			price_label_panel.setLayout(null);
			price_label_panel.add(total_price);
			price_label_panel.setBounds(0,440,410,60);
			price_label_panel.setBackground(Color.white);
			total_price.setBounds(0,0,100,50);
			total_price.setBackground(Color.red);
			

			main_panel.add(btn_back);
			btn_back.setBorder(border_bevel);
			btn_back.setBackground(Color.white);
			btn_back.setBounds(1120,0,80,30);
			
			button_panel.add(btn_cash);
			btn_cash.setPreferredSize(new Dimension(150,70));
			button_panel.add(btn_card);
			btn_card.setPreferredSize(new Dimension(150,70));
			button_panel.add(btn_traffic_card);
			btn_traffic_card.setPreferredSize(new Dimension(150,70));
			button_panel.add(btn_mobile);
			btn_mobile.setPreferredSize(new Dimension(150,70));
			
			
			    
			

				
			//btn_cash.addActionListener();
			//btn_card.addActionListener();
			//btn_cancel.addActionListener();
			

			
			
			
			
			setResizable(false);
    	    setVisible(true);
     	 	setSize(1200 , 900);
     	 	setPreferredSize(new Dimension(500 , 840 /12 * 9)); 
    	 	setLocationRelativeTo(null);
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}		

/*class btn_cashActionListener implements ActionListener{}
		
				public void actionPerformed(ActionEvent e){
				 
				
				}
				
class btn_cardActionListener implements ActionListener{}
		
				public void actionPerformed(ActionEvent e){
				 
				
				}
				
class btn_cancleActionListener implements ActionListener{}
		
				public void actionPerformed(ActionEvent e){
				 
				
				}
	

} */
   class Time extends Thread{
	   
	   Time(JLabel t , JPanel time){
		   time_panel = time;
		   current_time = t;
	   }

	   public void paint() {

	   }
	   public void update() {
		   
		   paint(current_time);
		   
	   }
        	public void run() {
        		
        		Calendar c = Calendar.getInstance();
        		
        		int hour = c.get(Calendar.HOUR_OF_DAY);
        		int min = c.get(Calendar.MINUTE);
        		int sec = c.get(Calendar.SECOND);
        				
        		
        		while(true) {	



        			current_time.setText("현재시간 " + Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec));
        			
        		
        			current_time.revalidate();
        			current_time.repaint();
        	        	
        			try {Thread.sleep(1000); 
        			time_panel.repaint();
        			current_time.repaint();
        			}
        			catch(Exception e) {
        			}
        			
        		}
        	}
       
        }
       
public static void main(String[] args) {
    	
    		new Sell_Frame();

    		
    		
    	}
    }


package pos;

import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.RIGHT;

public class Add_Staff_Frame extends JFrame {

    JLabel[] label_info = new JLabel[5]; //삽입 정보
    JTextField text_name, text_age, text_phone, text_hour;  //삽입 텍스트
    JTextArea text_adress; //삽입 텍스트
    JButton btn_image, btn_check, btn_cancel; //이미지 선택, 확인, 취소
    JLabel image_label; //이미지
    ImageIcon icon = new ImageIcon("Image/unknown.JPG");

    String[] info_label = {"  이름          : ", "  나이          : ", "  전화번호  : ", "  주소          : ", "  시급          : "};

    Add_Staff_Frame(){
        Container ct = getContentPane();
        ct.setLayout(new BorderLayout(0, 0));

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon Img = new ImageIcon(changeImg);
        image_label = new JLabel(Img);
        btn_image = new JButton("이미지 선택");
        top.add(image_label); top.add(btn_image);

        JPanel left = new JPanel();
        left.setLayout(new GridLayout(5, 1));
        for(int i = 0 ; i < label_info.length; i++){   //정보 입력 레이블 생성
            label_info[i] = new JLabel(info_label[i]);
        }//for문
        //이름 패널
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        text_name = new JTextField(13);
        p1.add(label_info[0]); p1.add(text_name);
        //나이패널
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        text_age = new JTextField(13);
        p2.add(label_info[1]); p2.add(text_age);
        //핸드폰 패널
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        text_phone = new JTextField(13);
        p3.add(label_info[2]); p3.add(text_phone);
        //주소 패널
        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        text_adress = new JTextArea(2, 13);
        p4.add(label_info[3]); p4.add(text_adress);
        //시급 패널
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        text_hour = new JTextField(13);
        p5.add(label_info[4]); p5.add(text_hour);

        left.add(p1);
        left.add(p2);
        left.add(p3);
        left.add(p4);
        left.add(p5);

        //확인 취소 버튼
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(RIGHT));
        btn_check = new JButton("추가");
        btn_cancel = new JButton("취소");
        bottom.add(btn_check); bottom.add(btn_cancel);

        ct.add(top, BorderLayout.NORTH);
        ct.add(left, BorderLayout.WEST);
        ct.add(bottom, BorderLayout.SOUTH);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("직원 추가");
    }

    public static void main(String[] args) {
        new Add_Staff_Frame();

    }
}

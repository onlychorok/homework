package homework;
/*

5. 일반용 계산기를 만드세요.

*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Exam_05 extends JFrame implements ActionListener{
  private JButton bt[] = new JButton[16];
  private String[] aa = {"+","-","*","/"};
  private String[] bb = {"0","=","AC"};
  private JPanel p1 = new JPanel();
  private JPanel p2 = new JPanel();
  private JPanel p3 = new JPanel();
  private JPanel p4 = new JPanel();
  private JTextField jf = new JTextField(12);	
  String a ="";
  String num1 ="";
  String num2 ="";
  String yon ="";
  
  public Exam_05() {
  	
  	setTitle("건방진 계산기");
  	init();
  	start();
  	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  	Dimension frm = this.getSize();
    setSize(220,200);
    int x = (int)(screen.getWidth()/2 - frm.getWidth()/2);
    int y = (int)(screen.getHeight()/2 - frm.getHeight()/2);
    setLocation(x,y);
  	setResizable(false);
  	setVisible(true);
  	
  }
  
  private void init() {
  	
  	Container con = this.getContentPane();
  	con.setLayout(new BorderLayout());
  	
  	
  	this.add("North",jf);
  	
  	p1.setLayout(new FlowLayout());
  	p2.setLayout(new GridLayout(4,3,5,5));
  	for(int i=0; i<12; i++){
  		if(i==9){
  			bt[i] = new JButton(bb[0]);
  		}else if(i==10){
  			bt[i] = new JButton(bb[1]);
  		}else if(i==11){
  			bt[i] = new JButton(bb[2]);
  		}			
  		else{
  			bt[i] = new JButton(String.valueOf(i+1));
  		}
  		p2.add(bt[i]);
  	}
  	
  	p1.add(p2);
  	
  	p3.setLayout(new GridLayout(4,1,5,5));
  	for(int i=12; i<16; i++){
  		bt[i] = new JButton(aa[i-12]);
  		p3.add(bt[i]);
  	}
  	p1.add(p3);
  	this.add("Center",p1);
  
  	
  	
  }

  private void start() {
  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  	for(int i=0; i<bt.length; i++){
  		bt[i].addActionListener(this);
  	}
  }

  public static void main(String[] args) {
  
  	new Exam_05();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  	// TODO Auto-generated method stub
  	
  	if(e.getSource().equals(bt[0])){
  		a += "1";
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[1])){
  		a +="2";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[2])){
  		a +="3";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[3])){
  		a +="4";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[4])){
  		a +="5";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[5])){
  		a +="6";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[6])){
  		a +="7";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[7])){
  		a +="8";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[8])){
  		a +="9";			
  		jf.setText(a);
  	}else if(e.getSource().equals(bt[9])){
  	
  		a +="0";			
  		jf.setText(a);
  		
  	
  	}else if(e.getSource().equals(bt[10])){
  		if(yon.equals("+")){
  			StringTokenizer st = new StringTokenizer(a,"+");
  			num1=st.nextToken();
  			num2=st.nextToken();
  			int aa = Integer.parseInt(num1);
  			int bb = Integer.parseInt(num2);
  			jf.setText(String.valueOf(aa+bb));				
  		}else if(yon.equals("-")){
  			StringTokenizer st = new StringTokenizer(a,"-");
  			num1=st.nextToken();
  			num2=st.nextToken();
  			int aa = Integer.parseInt(num1);
  			int bb = Integer.parseInt(num2);
  			jf.setText(String.valueOf(aa-bb));		
  			
  		}else if(yon.equals("*")){
  			StringTokenizer st = new StringTokenizer(a,"*");
  			num1=st.nextToken();
  			num2=st.nextToken();
  			int aa = Integer.parseInt(num1);
  			int bb = Integer.parseInt(num2);
  			jf.setText(String.valueOf(aa*bb));	
  			
  		}else if(yon.equals("/")){

  			StringTokenizer st = new StringTokenizer(a,"/");
  			num1=st.nextToken();
  			num2=st.nextToken();
  			int aa = Integer.parseInt(num1);
  			int bb = Integer.parseInt(num2);
  			jf.setText(String.valueOf(aa/bb));	
  			
  		}
  		
  	}	
  	
  	else if(e.getSource().equals(bt[11])){
  		a ="";
  		jf.setText(a);
  	
  		
  	}else if(e.getSource().equals(bt[12])){

  		a +="+";				
  		jf.setText(a);
  		yon="+";
  		
  		
  	}else if(e.getSource().equals(bt[13])){
  		a +="-";
  		yon="-";
  		jf.setText(a);
  	}
  	else if(e.getSource().equals(bt[14])){
  		a +="*";	
  		yon="*";
  		jf.setText(a);
  					
  		
  	}
  	else if(e.getSource().equals(bt[16])){
  		
  		a +="/";
  		yon="/";
  		jf.setText(a);	
  		
  	}
  	
  	
  }
  
}

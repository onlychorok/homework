package homework;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*02.인터넷 게시판의 입력 창을 Swing 으로 만드세요.
값을 입력 한 후 [확인] 버튼을 눌렀을 때 파일로 저장 되게 하세요.
입력 내용은 제목, 작성자, 작성일, 비밀번호, 내용, E-Mail 등을 입력 받으세요.

03. [불러오기] 버튼을 눌렀을 때 저장된 파일의 내용을 불러와서 출력하도록 하세요.

*/
/*
class save extends JFrame{
  public save() {
  	
  	setSize(100,50);
  }
}*/
public class Exam_02 extends JFrame implements ActionListener {
  String str ="내용을 입력해주세요 ";	
  private JDialog diasave = new JDialog(this,"저장되었습니다",false);
  private JDialog dialode = new JDialog(this,"불러왔습니다",false);
  private JLabel jl = new JLabel("저장되었습니다",JLabel.CENTER);
  private JLabel jl2 = new JLabel("불러왔습니다",JLabel.CENTER);
  private JPanel p = new JPanel();
  private JPanel p2 = new JPanel();
  private JPanel p3 = new JPanel();
  private JPanel p4 = new JPanel();
  private GridLayout gl = new GridLayout(5,1) ;
  private GridLayout gl2 = new GridLayout(1,6) ;
  private GridLayout  gl3 = new GridLayout(1,2) ;
  private FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
  private FlowLayout fl2 = new FlowLayout(FlowLayout.LEFT);
  private JButton bt = new JButton("확인");
  private JButton bt3 = new JButton("확인");
  private JButton bt4 = new JButton("확인");
  private JButton bt2 = new JButton("불러오기");
  private JPanel jp1 = new JPanel();
  private JPanel jp2 = new JPanel();
  private JPanel jp3 = new JPanel();
  private JPanel jp4 = new JPanel();
  private JPanel jp5 = new JPanel();
  private JPanel jp6 = new JPanel();
  private JLabel l_title= new JLabel("제목 : ",JLabel.LEFT);
  private JLabel l_writer= new JLabel("작성자",JLabel.LEFT);
  private JLabel l_date= new JLabel("작성일",JLabel.LEFT);
  private JLabel l_password= new JLabel("비밀번호",JLabel.LEFT);
  private JLabel l_email= new JLabel("E-mail",JLabel.LEFT);
  private JLabel l_contents= new JLabel("내용",JLabel.LEFT);
  private JTextField j_title= new JTextField(37);
  private JTextField j_writer= new JTextField(8);
  private JTextField j_email= new JTextField(37);
  private JTextField j_date = new JTextField(10);
  JTextArea ta = new JTextArea(str, 25, 38);
  private JScrollPane j_contents = new JScrollPane(ta );
  private JPasswordField j_password = new JPasswordField(8);
  public Exam_02() throws IOException {
  	
  	setTitle("게시판");
  	
  	init();
  	start();
  	setSize(480,680);
  	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  	Dimension frm = this.getSize();
  	int x=(int)(screen.getWidth()/2 - frm.getWidth()/2);
  	int y=(int)(screen.getHeight()/2 - frm.getHeight()/2);
  	setLocation(x, y);
  	setResizable(false);
  	setVisible(true);
  	
  				
  }
  
  public void init(){
  	Container con = this.getContentPane();
  	con.setLayout(fl);
  	jp1.setLayout(fl2);
  	jp1.add(l_title); jp1.add(j_title);
  	this.add(jp1);
  	jp2.setLayout(fl2);
  	jp2.add(l_writer); jp2.add(j_writer);
  	jp2.add(l_password); jp2.add(j_password);
  	jp2.add(l_date); jp2.add(j_date);
  	this.add(jp2);
  	jp3.setLayout(fl2);
  	jp3.add(l_email); jp3.add(j_email);
  	this.add(jp3);
  	jp4.setLayout(fl2);
  	jp4.add(l_contents); jp4.add(j_contents);
  	this.add(jp4);
  	jp5.setLayout(fl);
  	jp5.add(bt);
  	jp5.add(bt2);
  	this.add(jp5);
  	
  

  	diasave.setLayout(new BorderLayout());
  	
  	p.setLayout(new GridLayout(2,1));
  	p.add(jl);
  	p2.add(bt3);
  	p2.setLayout(new GridBagLayout());
  	p.add(p2);
  	diasave.add("Center",p);
  	
  	
  	dialode.setLayout(new BorderLayout());
  	
  	p3.setLayout(new GridLayout(2,1));
  	p3.add(jl2);
  	p4.setLayout(new GridBagLayout());
  	p4.add(bt4);
  	p3.add(p4);
  	dialode.add("Center",p3);
  	
  	
  }
  public void start() throws IOException{

  	
  	
  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  	bt.addActionListener(this);
  	bt2.addActionListener(this);
  	bt3.addActionListener(this);	
  	bt4.addActionListener(this);
  }
  
  public static void main(String[] args) throws IOException{
  	
  	new Exam_02();
  	
  		
  	
  	
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  
  	if(e.getSource().equals(bt)){
  		diasave.setSize(200,140);
  		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
  		Dimension dia = diasave.getSize();
  		int x =(int)(screen.getWidth()/2 - dia.getWidth()/2);
  		int y =(int)(screen.getHeight()/2 -dia.getHeight()/2);
  		diasave.setLocation(x,y);
  		diasave.setVisible(true);
  		String uri="test.txt";
  		File file = new File(uri); 
  		if (!file.exists()){ 
  			System.out.println("파일이 존재하지 않습니다");
  			try {
  				if(file.createNewFile()){
  					System.out.println("파일 생성 완료!");
  				}
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			}
  		} else{	}
  		
  		try {
  			input();
  		} catch (IOException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
  		
  	}else if(e.getSource().equals(bt2)){

  		dialode.setSize(200,140);
  		Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
  		Dimension dia = dialode.getSize();
  		int x =(int)(screen.getWidth()/2 - dia.getWidth()/2);
  		int y =(int)(screen.getHeight()/2 -dia.getHeight()/2);
  		dialode.setLocation(x,y);
  		dialode.setVisible(true);
  		
  		System.out.println("불러오기");
  		try {
  			output();
  		} catch (IOException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
  		
  	}else if(e.getSource().equals(bt3)){
  		diasave.dispose();
  	}else if(e.getSource().equals(bt4)){
  		diasave.dispose();
  	}
  	
  }

  private void output() throws IOException{
  	

  	String uri="test.txt";
  	File f = new File(uri); 
  	if (!f.exists()){ 
  		System.out.println("파일이 존재하지 않습니다");
  		try {
  			if(f.createNewFile()){
  				System.out.println("파일 생성 완료!");
  			}
  		} catch (IOException e1) {
  			e1.printStackTrace();
  		}
  	} else{	}
  	FileReader fr = new FileReader(f);
  	BufferedReader in = new BufferedReader(fr);
  	String title = in.readLine();
  	String writer = in.readLine();
  	String date = in.readLine();
  	String password = in.readLine();
  	String email = in.readLine();
  	String contents = in.readLine();
  	
  	System.out.println(title);
  	j_title.setText(title);
  	j_writer.setText(writer);
  	j_date.setText(date);
  	j_password.setText(password);
  	j_email.setText(email);
  	ta.setText(contents);
  }

  private void input() throws IOException{
  File f = new File("test.txt");
  FileWriter fw = new FileWriter(f);
  BufferedWriter bw = new BufferedWriter(fw,1024);
  PrintWriter pw = new PrintWriter(bw);
  pw.println(j_title.getText());
  pw.println(j_writer.getText());
  pw.println(j_password.getText());
  pw.println(j_date.getText());
  pw.println(j_email.getText());
  pw.println(ta.getText());
  
  pw.close();
  System.out.println("저장되었습니다");		
  }

  
}


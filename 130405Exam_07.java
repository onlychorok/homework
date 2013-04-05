package homework;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*
7. 메모장 만들기 (불러오기/수정/저장)

*/

public class Exam_07 extends JFrame implements ActionListener{
  private JDialog diasave = new JDialog(this,"저장되었습니다",false);
  private JDialog dialode = new JDialog(this,"불러왔습니다",false);
  private JLabel jl = new JLabel("저장되었습니다",JLabel.CENTER);
  private JLabel jl2 = new JLabel("불러왔습니다",JLabel.CENTER);
  private JButton bt3 = new JButton("확인");
  private JButton bt4 = new JButton("확인");
  private JPanel p2 = new JPanel();
  private JPanel p = new JPanel();
  private JPanel dp = new JPanel();
  private JPanel dp2 = new JPanel();
  private JPanel dp3 = new JPanel();
  private JPanel dp4 = new JPanel();
  private JMenuBar mb = new JMenuBar();
  private JMenu file = new JMenu("FLIE");
  
  private JMenuItem renew = new JMenuItem("새문서");
  private JMenuItem lode = new JMenuItem("불러오기");
  private JMenuItem save = new JMenuItem("저장하기");
  private JTextArea ta = new JTextArea();
  private JScrollPane text = new JScrollPane(ta);
  public Exam_07() {
  	
  	setSize(640,480);
  	init();
  	start();
  	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
  	Dimension frm = this.getSize();
  	int x =(int)(screen.getWidth()/2 - frm.getWidth()/2);
  	int y =(int)(screen.getHeight()/2 - frm.getHeight()/2);
  	setLocation(x, y);
  	setResizable(false);
  	setVisible(true);
  }
  private void init() {
  	file.add(renew);
  	file.add(lode);
  	file.add(save);
  	mb.add(file);
  	setJMenuBar(mb);
  	this.add(text);		
  	
  	
  	diasave.setLayout(new BorderLayout());
  	
  	dp.setLayout(new GridLayout(2,1));
  	dp.add(jl);
  	dp2.add(bt3);
  	dp2.setLayout(new GridBagLayout());
  	dp.add(dp2);
  	diasave.add("Center",dp);
  	

  	dialode.setLayout(new BorderLayout());
  	
  	dp3.setLayout(new GridLayout(2,1));
  	dp3.add(jl2);
  	dp4.setLayout(new GridBagLayout());
  	dp4.add(bt4);
  	dp3.add(dp4);
  	dialode.add("Center",dp3);
  	
  }
  private void start() {
  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  	
  	renew.addActionListener(this);
  	lode.addActionListener(this);
  	save.addActionListener(this);
  	bt3.addActionListener(this);
  	bt4.addActionListener(this);
  	
  }
  public static void main(String[] args) {
  
  	new Exam_07();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
  	
  if(e.getSource().equals(lode)){		
  	dialode.setSize(200,140);
  	Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
  	Dimension dia = dialode.getSize();
  	int x =(int)(screen.getWidth()/2 - dia.getWidth()/2);
  	int y =(int)(screen.getHeight()/2 -dia.getHeight()/2);
  	dialode.setLocation(x,y);
  	dialode.setVisible(true);
  	try {lode();} 
  	catch (IOException e1) { e1.printStackTrace();}
  } 
  else if(e.getSource().equals(save)){
  	diasave.setSize(200,140);
  	Dimension screen= Toolkit.getDefaultToolkit().getScreenSize();
  	Dimension dia = diasave.getSize();
  	int x =(int)(screen.getWidth()/2 - dia.getWidth()/2);
  	int y =(int)(screen.getHeight()/2 -dia.getHeight()/2);
  	diasave.setLocation(x,y);
  	diasave.setVisible(true);
  	try {	save();	} 
  	catch (IOException e1) { e1.printStackTrace();}
  }
  else if(e.getSource().equals(renew)){
  	
  	ta.setText("");
  	
  }
  else if(e.getSource().equals(bt3)){
  	
  	diasave.dispose();
  	
  }else if(e.getSource().equals(bt4)){
  	
  	dialode.dispose();
  	
  }
  		
  }
  private void save() throws IOException {
  	String uri="memojang.txt";
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
  	} else{	
  		System.out.println("파일이 존재합니다");}
  	FileWriter fw = new FileWriter(f);
  	BufferedWriter bw = new BufferedWriter(fw,1024);
  	PrintWriter pw = new PrintWriter(bw);
  	
  	pw.print(ta.getText());
  	
  	pw.close();
  	System.out.println("저장되었습니다");}
  	
  private void lode() throws IOException {
  	
  	String uri="memojang.txt";
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
  	} else{	
  		System.out.println("파일이 존재합니다");
  	}
  	FileReader fr = new FileReader(f);
  	BufferedReader in = new BufferedReader(fr);
  	
  	String a="";
  	String b="";
  	while(true){
  		a=in.readLine();
  		if(a==null)break;
  		b+=a;
  	}
  	ta.setText(b);
}}
  	

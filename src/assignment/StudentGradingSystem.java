package assignment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class MarkTextField extends PlainDocument{
	  MarkTextField() {
	    super();
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;
	   
	    int length= getLength() ;
	    if (length + str.length() > 3) {
	     return;
	    }
	    
	    System.out.println(str);
	    for (int i = 0; i < str.length(); i++) {
	        char charAt = str.charAt(i);
	        System.out.println("char  "+charAt);
	        if (Character.isDigit(charAt)==false) {
	        return;    
	        }
	    }
           
	   	    
	    String m=getText(0, length)+str;
	    int mark=Integer.parseInt(m);
	    
	    System.out.println("mark  "+mark);
	    
	    if(mark >100){
	    	return;
	   }
	 
	    super.insertString(offset, str, attr);
	  }
}


public class StudentGradingSystem extends JFrame implements ActionListener {
	static JLabel lbSdetails,lbBlank,lbSScore,lbName,lbRegNo,lbEng,lbMaths,lbPhy,lbChem,lbBot,lbZoo,lbComp,lbTotal,lbPer,lbRem;
	static JTextField tfName,tfRegNo,tfEng,tfMaths,tfPhy,tfChem,tfBot,tfZoo,tfComp,tfTotal,tfPer,tfRem;
	static JButton btTotal,btPer,btRem,btExit;
	

	
	public static void main (String[] args) {
		StudentGradingSystem s=new StudentGradingSystem();
		s.setSize(500,500);
		GridLayout g=new GridLayout(20,2,1,1);
		s.setLayout(g);
		s.setLocationRelativeTo(null);
		s.setTitle("Student Grades");
		s.add(lbSdetails =new JLabel ("STUDENT DETAILS"));
		s.add(lbBlank =new JLabel(" "));
		s.add(lbName =new JLabel ("Student Name"));
		s.add(tfName =new JTextField ());
		s.add(lbRegNo =new JLabel ("Registration Number"));
		s.add(tfRegNo =new JTextField ());
		
		s.add(lbSScore =new JLabel ("SUBJECTS & SCORES"));
		s.add(lbBlank =new JLabel(" "));
		s.add(lbEng =new JLabel ("English Grammar"));
		s.add(tfEng =new JTextField ());
		s.add(lbMaths =new JLabel ("Mathematics"));
		s.add(tfMaths =new JTextField ());
		s.add(lbPhy =new JLabel ("Physics"));
		s.add(tfPhy =new JTextField ());
		s.add(lbChem =new JLabel ("Chemistry"));
		s.add(tfChem =new JTextField ());
		s.add(lbBot =new JLabel ("Botony"));
		s.add(tfBot =new JTextField ());
		s.add(lbZoo =new JLabel ("Zoology"));
		s.add(tfZoo =new JTextField ());
		s.add(lbComp =new JLabel ("Computer"));
		s.add(tfComp =new JTextField ());
		s.add(lbBlank =new JLabel(" "));
		s.add(lbBlank =new JLabel(" "));
		
		tfEng.setDocument(new MarkTextField());
		tfMaths.setDocument(new MarkTextField());
		tfPhy.setDocument(new MarkTextField());
		tfChem.setDocument(new MarkTextField());
		tfBot.setDocument(new MarkTextField());
		tfZoo.setDocument(new MarkTextField());
		tfComp.setDocument(new MarkTextField());
		s.add(lbTotal =new JLabel ("Total Score"));
		s.add(tfTotal =new JTextField ());
		s.add(lbPer =new JLabel ("Percentage"));
		s.add(tfPer =new JTextField ());
		s.add(lbRem =new JLabel ("Remarks"));
		s.add(tfRem =new JTextField ());
		s.add(lbBlank =new JLabel(" "));
		s.add(lbBlank =new JLabel(" "));
		
		
		tfRem.setEditable(false);
		tfTotal.setEditable(false);
		tfPer.setEditable(false);
		
		s.add(btTotal =new JButton("TOTAL SCORE"));
		s.add(btPer =new JButton("PERCENTAGE"));
		s.add(btRem =new JButton("REMARKS"));
		
		s.add(btExit =new JButton ("EXIT"));
		
		btTotal.addActionListener(s);
		btPer.addActionListener(s);
		btRem.addActionListener(s);
		
		btExit.addActionListener(s);
		
		
		s.setVisible(true);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent x) {
		// TODO Auto-generated method stub
		
		String name=(tfName.getText());
		String reg=(tfRegNo.getText());
		
		int eng=0;
		if(tfEng.getText().length()>0){
			eng=	Integer.parseInt(tfEng.getText());	
		}
		
		int math=0;
		
		if(tfMaths.getText().length()>0){
			math=	Integer.parseInt(tfMaths.getText());	
		}
		
        int phy=0;
		
		if(tfPhy.getText().length()>0){
			phy=	Integer.parseInt(tfPhy.getText());	
		}
		
        int che=0;
		
		if(tfChem.getText().length()>0){
			che=	Integer.parseInt(tfChem.getText());	
		}
		
        int bot=0;
		
		if(tfBot.getText().length()>0){
			bot=	Integer.parseInt(tfBot.getText());	
		}
		
        int zoo=0;
		
		if(tfZoo.getText().length()>0){
			zoo=	Integer.parseInt(tfZoo.getText());	
		}
		
        int com=0;
		
		if(tfComp.getText().length()>0){
			com=	Integer.parseInt(tfComp.getText());	
		}
		
		
		float totalScore=eng+math+phy+che+bot+zoo+com;
		float percentage=totalScore/7;
		
		
		
		if (x.getSource() ==btTotal) {
			tfTotal.setText(" "+Math.round(totalScore));
		}
		
		else if (x.getSource()==btPer) {
			tfPer.setText(String.format("%.2f", percentage)+ "%");
		}
		
				
		else if (x.getSource()==btRem) {
			if (percentage<50) {
				tfRem.setText("FAIL");
				
		}
			else  if (percentage<60) {
				tfRem.setText("FAIR");
		}
		
			else  if (percentage<70) {
				tfRem.setText("GOOD");
			}
			else  if (percentage<80) {
				tfRem.setText("VERY GOOD");
	}
	
			else  if (percentage<90) {
				tfRem.setText("EXCELLENT");

}
			else  if (percentage<=100) {
				tfRem.setText("OUT STANDING");
			}
			else if (x.getSource()==btExit) {
				System.exit(0);
			}
			
		}
		
	}
	
}




	

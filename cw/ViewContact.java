import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ViewContact extends JFrame{
	private ContactList contacts = ContactList.getInstante();
	private Cp method = Cp.getInstante();
	
	private JPanel head;
	private JPanel foot;
	private JPanel body;
	private JPanel bottom;
	
	private JButton Lname;
	private JButton Lsalary;
	private JButton Lbday;
	private JButton cancel;
	
	public static Viewby viewby;
	
	{
		setSize(500,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	ViewContact(){
		body = new JPanel();
		body.setLayout(new GridLayout(3,0,10,10));
		
		head = new JPanel();
		head.setLayout(new FlowLayout());
		
		bottom = new JPanel();
		
		foot = new JPanel();
		foot.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
		JLabel heading = new JLabel("CONTACT LIST");
		heading.setFont(new Font("",1,20));
		
		Lname = new JButton("List by Name");
		Lname.setFont(new Font("",1,20)); 
		Lname.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewby==null){
					contacts.sortName();
					viewby = new Viewby("LIST CONTACTS BY NAME");
				}
				viewby.setVisible(true);
				
			}
		});
		
		Lsalary = new JButton("List By Salary");
		Lsalary.setFont(new Font("",1,20)); 
		Lsalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewby==null){
					contacts.sortSalary();
					viewby = new Viewby("LIST CONTACTS BY SALARY");
				}
				
				viewby.setVisible(true);
				
			}
		});
		
		Lbday = new JButton("List by Birthday");
		Lbday.setFont(new Font("",1,20)); 
		Lbday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewby==null){
					contacts.sortBirthday();
					viewby = new Viewby("LIST CONTACTS BY BIRTHDAY");
				}
				viewby.setVisible(true);
			}
		});
		
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("",1,20)); 
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				HomePage.viewContactForm = null;
				setVisible(false);
			}
		});
		bottom.add("West",cancel);
		
		body.add(Lname);
		body.add(Lsalary);
		body.add(Lbday);
		
		head.add(heading);

		foot.add(bottom);
		
		add("Center",body);
		add("North",head);
		add("South",bottom);
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
					HomePage.viewContactForm=null;
            }
        });
	}
}

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class UpdateContact extends JFrame{
	private ContactList contacts = ContactList.getInstante();
	private Cmethod cmethod = new Cmethod();
	
	private JPanel left;
	private JPanel right;
	private JPanel label;
	private JPanel area;
	private JPanel head;
	private JPanel foot;
	private JPanel body;
	private JPanel bottom;
	
	private JTextField name = new JTextField(20);
	private JTextField phone = new JTextField(20);
	private JTextField cname = new JTextField(20);
	private JTextField salary = new JTextField(20);
	
	private JButton addc;
	private JButton cancel;
	private JButton back;
	private JButton search;
	private int index;
	private int index1;
	private String Cname;
	private String Cphone;
	private String Ccname;
	private String Csalary;
	private String Cbday;
	private String Cid;
	
	private JTextField txt = new JTextField(20);;
	
	UpdateContact(){
		
		search = new JButton("Search");
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				index=cmethod.search(txt);
				if(index!=-1){
					HomePage.updateContactForm = new UpdateContact(index);
					HomePage.updateContactForm.setVisible(true);
					setVisible(false);
				}	
			}
		});
		name.setText(Cname);
		phone.setText(Cphone);
		cname.setText(Ccname);
		salary.setText(Csalary);
		
		area.add(search);
		area.add(new JLabel(Cid));
		area.add(name);
		area.add(phone);
		area.add(cname);
		area.add(salary);
		area.add(new JLabel(Cbday));
	}
	UpdateContact(int index1){
		index = index1;
		search = new JButton("Search");
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				index = cmethod.search(txt); 
				HomePage.updateContactForm = new UpdateContact(index);
				HomePage.updateContactForm.setVisible(true);
				setVisible(false);
			}
		});
		
		addc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				cmethod.update(index,txt,name,phone,cname,salary);
				setVisible(false);
			}
		});
		
		if(index!=-1){
			Cname =contacts.returnName(index);
			Cphone =contacts.returnPhone(index);
			Ccname =contacts.returnCname(index);
			Cbday =contacts.returnBday(index);
			Cid =contacts.returnId(index);
			Csalary =contacts.returnSalary(index)+"";
		}
		
		name.setText(Cname);
		phone.setText(Cphone);
		cname.setText(Ccname);
		salary.setText(Csalary);
		
		area.add(search);
		area.add(new JLabel(Cid));
		area.add(name);
		area.add(phone);
		area.add(cname);
		area.add(salary);
		area.add(new JLabel(Cbday));
		
		
	}
	{
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		body = new JPanel();
		
		head = new JPanel();
		head.setLayout(new FlowLayout());
		
		bottom = new JPanel();
		
		foot = new JPanel();
		foot.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		left = new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		right = new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		label = new JPanel();
		label.setLayout(new GridLayout(7,0,2,15));
		label.setFont(new Font("",1,20)); 
		
		area = new JPanel();
		area.setLayout(new GridLayout(7,0,2,10));
	
		JLabel heading = new JLabel("UPDATE CONTACT");
		heading.setFont(new Font("",1,20));
		
		label.add(txt);
		label.add(new JLabel("Contact ID"));
		label.add(new JLabel("Name"));
		label.add(new JLabel("Contact Number"));
		label.add(new JLabel("Company"));
		label.add(new JLabel("Salary"));
		label.add(new JLabel("Birthday"));
		
		addc = new JButton("Update");
		addc.setFont(new Font("",1,20)); 
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("",1,20)); 
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(!txt.getText().equals("")){
					HomePage.updateContactForm = new UpdateContact();
					setVisible(false);
					HomePage.updateContactForm.setVisible(true);
				}
			}
		});
		
		back = new JButton("Back To HomePge");
		back.setFont(new Font("",1,20)); 
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				HomePage.updateContactForm = null;
				setVisible(false);
			}
		});
		
		bottom.add("East",addc);
		bottom.add("West",cancel);
		bottom.add("South",back);
	
		head.add(heading);
		left.add(label);
		right.add(area);
		
		foot.add(bottom);
		
		body.add("Center",left);
		body.add("East",right);
		add("Center",body);
		add("North",head);
		add("South",bottom);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				HomePage.updateContactForm=null;
			}
		});
	}	
}


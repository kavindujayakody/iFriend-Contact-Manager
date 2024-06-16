import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class SearchContact extends JFrame{
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
	private JTextField bday = new JTextField(20);
	
	private JButton addc;
	private JButton cancel;
	private JButton back;
	private JButton search;
	private String num;
	private JTextField txt = new JTextField(20);;
	private int index =-1;
	private int index1;
	private String Cname;
	private String Cphone;
	private String Ccname;
	private String Csalary;
	private String Cbday;
	private String Cid;
	
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
	
		JLabel heading = new JLabel("SEARCH CONTACT");
		heading.setFont(new Font("",1,20));
		
		label.add(txt);
		label.add(new JLabel("Contact ID"));
		label.add(new JLabel("Name"));
		label.add(new JLabel("Contact Number"));
		label.add(new JLabel("Company"));
		label.add(new JLabel("Salary"));
		label.add(new JLabel("Birthday"));
		
		back = new JButton("Back To HomePge");
		back.setFont(new Font("",1,20)); 
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				HomePage.searchContactForm = null;
				setVisible(false);
			}
		});
		
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
				HomePage.searchContactForm=null;
			}
		});
		
	}
	SearchContact(){
		search = new JButton("Search");
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				index = cmethod.search(txt);
				if(index!=-1){
					setVisible(false);
					HomePage.searchContactForm = new SearchContact(index);
					HomePage.searchContactForm.setVisible(true);
				}
			}
		});
		
		area.add(search);
		area.add(new JLabel(Cid));
		area.add(new JLabel(Cname));
		area.add(new JLabel(Cphone));
		area.add(new JLabel(Ccname));
		area.add(new JLabel(Csalary));
		area.add(new JLabel(Cbday));
		
		
	}
	SearchContact(int index1){
		index=index1;
		search = new JButton("Search");
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				index = cmethod.search(txt);
				setVisible(false);
				HomePage.searchContactForm = new SearchContact(index);
				HomePage.searchContactForm.setVisible(true);
				
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
		
		area.add(search);
		area.add(new JLabel(Cid));
		area.add(new JLabel(Cname));
		area.add(new JLabel(Cphone));
		area.add(new JLabel(Ccname));
		area.add(new JLabel(Csalary));
		area.add(new JLabel(Cbday));
		
		
	}
}


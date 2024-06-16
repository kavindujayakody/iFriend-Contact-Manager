import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class AddContact extends JFrame{
	private Cp method = Cp.getInstante();
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
	
	{
		setSize(500,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	AddContact(){
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
		label.setLayout(new GridLayout(6,0,2,15));
		label.setFont(new Font("",1,20)); 
		
		area = new JPanel();
		area.setLayout(new GridLayout(6,0,2,10));
	
		JLabel heading = new JLabel("ADD CONTACT");
		heading.setFont(new Font("",1,20));
		
		label.add(new JLabel("Contact ID - "+method.generateId()));
		label.add(new JLabel("Name"));
		label.add(new JLabel("Contact Number"));
		label.add(new JLabel("Company"));
		label.add(new JLabel("Salary"));
		label.add(new JLabel("Birthday"));
		
		area.add(new JLabel());
		area.add(name);
		area.add(phone);
		area.add(cname);
		area.add(salary);
		area.add(bday);
		
		addc = new JButton("Add Contact");
		addc.setFont(new Font("",1,20)); 
		addc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(cmethod.add(name,phone,cname,salary,bday)){
					setVisible(false);
				}
			}
		});
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("",1,20)); 
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				name.setText("");
				phone.setText("");
				cname.setText("");
				salary.setText("");
				bday.setText("");
			}
		});
		
		back = new JButton("Back To HomePge");
		back.setFont(new Font("",1,20)); 
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				HomePage.addContactForm = null;
				setVisible(false);
			}
		});
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
					HomePage.addContactForm=null;
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
	}
	
}

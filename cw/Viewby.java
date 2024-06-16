import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Viewby extends JFrame{
	private JButton btnback;
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;
	
	private ContactList contacts = ContactList.getInstante();
	private Cp method = Cp.getInstante();
	
	Viewby(String title){
		setSize(800,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLabel=new JLabel(title);
		titleLabel.setFont(new Font("",1,30)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnback=new JButton("Back To Home");
		btnback.setFont(new Font("",1,20)); 
		buttonPanel.add(btnback);
		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContact.viewby=null;
				setVisible(false);
			}
		});
		add("South",buttonPanel);
		
		//----------------------------------------------
		
		String[] columnName={"Customer ID", "Name","PhoneNumber","CompanyName","Salary","Birthday"};
		dtm=new DefaultTableModel(columnName,contacts.size());
		if(contacts.size()!=0){
			dtm.setRowCount(0);
			for (int i = 0; i < contacts.size(); i++){
				Object[] rowData={contacts.returnId(i),contacts.returnName(i),contacts.returnPhone(i),contacts.returnCname(i),contacts.returnSalary(i),contacts.returnBday(i)};
				dtm.addRow(rowData); 	
			}
		}
		tblCustomerDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		add("Center",tablePane);
		
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
					ViewContact.viewby=null;
            }
        });
		
	}
}

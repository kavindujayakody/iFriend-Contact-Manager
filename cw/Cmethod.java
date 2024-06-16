import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Cmethod{
	private ContactList contacts = ContactList.getInstante();
	private Cp method = Cp.getInstante();
	
	
	public boolean add(JTextField name,JTextField phone,JTextField cname,JTextField salary,JTextField bday){
		if(!name.getText().equals("")){
			double temp = Double.parseDouble(salary.getText());
			if(method.isValidBirthday(bday.getText())&method.isValidPhoneNumber(phone.getText())&method.isValidSalary(temp)&(method.searchByNameOrPhoneNumber(phone.getText())==-1)){
				method.contacts.add(method.generateId(),name.getText(),phone.getText(),cname.getText(),temp,bday.getText());
				JOptionPane.showMessageDialog(null,"Contact added successfully!");
				HomePage.addContactForm = new AddContact();
				HomePage.addContactForm.setVisible(true);
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null,"Contact didn't added successfully!");
			}
		}
		return false;
	}
	
	public void update(int index,JTextField txt,JTextField name,JTextField phone,JTextField cname,JTextField salary){
		if(!name.getText().equals("")){
			txt.setText("");
			double temp = Double.parseDouble(salary.getText());
			if(method.isValidPhoneNumber(phone.getText())& method.isValidSalary(temp)){
				contacts.SetName(index,name.getText());
				contacts.SetPhone(index,phone.getText());
				contacts.SetCname(index,cname.getText());
				contacts.SetSalary(index,temp);
				JOptionPane.showMessageDialog(null,"Contact update successfully!");
				HomePage.updateContactForm = new UpdateContact(index);
				HomePage.updateContactForm.setVisible(true);
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"Contact didn't update successfully!");
		}	
	}
	
	public int search(JTextField txt){
		int index=-1;
		if(!txt.getText().equals("")){
			index =method.searchByNameOrPhoneNumber(txt.getText());
		}
		if(index==-1){
			JOptionPane.showMessageDialog(null,"Contact Doesn't found!");
		}
		return index;
	}
	
	public void delete(int index){
		if(index!=-1){
			contacts.remove(index);
			HomePage.deleteContactForm = new DeleteContact();
			HomePage.deleteContactForm.setVisible(true);
			JOptionPane.showMessageDialog(null,"Contact delete successfully!");
		}
	}
	
}

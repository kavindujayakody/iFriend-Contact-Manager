class ContactList{
	class Contact{
		private String id;
		private String name;
		private String phone;
		private String cname;
		private double salary;
		private String bday;
		private Contact next;
	
		Contact(String id,String name,String phone,String cname,double salary,String bday){
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.cname = cname;
			this.salary = salary;
			this.bday = bday;
		}
	}
	private Contact start;
	private static ContactList contacts;
	
	private ContactList(){
		
	}
	
	public static ContactList getInstante() {
		if(contacts==null){
			contacts = new ContactList();
		}
		return contacts;
	}
	
	public void add(String id,String name,String phoneNumber,String companyName,double salary,String birthday){
		Contact temp = new Contact(id,name,phoneNumber,companyName,salary,birthday);
		if(start==null){
			start=temp;
		}
		else{
			Contact last = start;
			while(last.next!=null){
				last=last.next;
			}
			last.next=temp;
		}
	} 
	public int size(){
		Contact temp =start;
		int count=0;
		if(start!=null){
			while(temp!=null){
				temp=temp.next;
				count++;
			}
		}
		return count;
	}
	public String returnId(){
		Contact temp = start;
		while(temp.next!=null){
			temp=temp.next;
		}
		return temp.id;
	}
	
	public String returnId(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.id;
	}
	public String returnName(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.name;
	}
	public String returnPhone(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.phone;
	}
	public String returnCname(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.cname;
	}
	public double returnSalary(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.salary;
	}
	public String returnBday(int index){
		Contact temp = start;
		int count=0;
		while(index!=count){
			count++;
			temp=temp.next;
		}
		return temp.bday;
	}
	
	public void SetName(int index,String name){
		Contact temp= start;
		int count=0;
		while(index!=count){
			temp=temp.next;
			count++;
		}
		temp.name=name;
	}
	public void SetPhone(int index,String phone){
		Contact temp= start;
		int count=0;
		while(index!=count){
			temp=temp.next;
			count++;
		}
		temp.phone=phone;
	}
	public void SetCname(int index,String cname){
		Contact temp= start;
		int count=0;
		while(index!=count){
			temp=temp.next;
			count++;
		}
		temp.cname=cname;
	}
	public void SetSalary(int index,double salary){
		Contact temp= start;
		int count=0;
		while(index!=count){
			temp=temp.next;
			count++;
		}
		temp.salary=salary;
	}
	public void remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
				start=start.next;
			}else{
				int count=0;
				Contact temp=start;
				while(count<index-1){
					count++;
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
		}
	}
	
	public void sort(){
		Contact temp =start;
		while(temp!=null){
			System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",temp.id,temp.name,temp.phone,temp.cname,temp.salary,temp.bday);
			temp=temp.next;
		}
	}
	public void sortSalary(){
		for(int i=0;i<size();i++){
			Contact temp = start;
			while(temp.next!=null){
				String id = temp.id;
				String name = temp.name;
				String phone = temp.phone;
				String cname = temp.cname;
				double salary = temp.salary;
				String bday = temp.bday;
				if(salary>temp.next.salary){
					id=temp.id;
					temp.id=temp.next.id;
					temp.next.id=id;
				
					name=temp.name;
					temp.name=temp.next.name;
					temp.next.name=name;
				
					phone=temp.phone;
					temp.phone=temp.next.phone;
					temp.next.phone=phone;
				
					cname=temp.cname;
					temp.cname=temp.next.cname;
					temp.next.cname=cname;
				
					salary=temp.salary;
					temp.salary=temp.next.salary;
					temp.next.salary=salary;
				
					bday=temp.bday;
					temp.bday=temp.next.bday;
					temp.next.bday=bday;
				
					temp=start;
				}
				temp=temp.next;
			}
		}
		sort();
	}
	public void sortName(){
		for(int i=0;i<size();i++){
			Contact temp = start;
			while(temp.next!=null){
				String id = temp.id;
				String name = temp.name;
				String phone = temp.phone;
				String cname = temp.cname;
				double salary = temp.salary;
				String bday = temp.bday;
				if(name.compareTo(temp.next.name)>0){
					id=temp.id;
					temp.id=temp.next.id;
					temp.next.id=id;
				
					name=temp.name;
					temp.name=temp.next.name;
					temp.next.name=name;
				
					phone=temp.phone;
					temp.phone=temp.next.phone;
					temp.next.phone=phone;
				
					cname=temp.cname;
					temp.cname=temp.next.cname;
					temp.next.cname=cname;
				
					salary=temp.salary;
					temp.salary=temp.next.salary;
					temp.next.salary=salary;
				
					bday=temp.bday;
					temp.bday=temp.next.bday;
					temp.next.bday=bday;
				
					temp=start;
				}
				temp=temp.next;
			}
		}
		sort();
	}
	public void sortBirthday(){
		for(int i=0;i<size();i++){
			Contact temp = start;
			while(temp.next!=null){
				String id = temp.id;
				String name = temp.name;
				String phone = temp.phone;
				String cname = temp.cname;
				double salary = temp.salary;
				String bday = temp.bday;
				if(bday.compareTo(temp.next.bday)>0){
					id=temp.id;
					temp.id=temp.next.id;
					temp.next.id=id;
				
					name=temp.name;
					temp.name=temp.next.name;
					temp.next.name=name;
				
					phone=temp.phone;
					temp.phone=temp.next.phone;
					temp.next.phone=phone;
				
					cname=temp.cname;
					temp.cname=temp.next.cname;
					temp.next.cname=cname;
				
					salary=temp.salary;
					temp.salary=temp.next.salary;
					temp.next.salary=salary;
				
					bday=temp.bday;
					temp.bday=temp.next.bday;
					temp.next.bday=bday;
				
					temp=start;
				}
				temp=temp.next;
			}
		}
		sort();
	}
}
	

package mailbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class MailBox extends Subject
{

	
	private MailBox(){
		
	}
	private static MailBox instance = null;
	
	
	public static MailBox getInstance() {
		if (instance==null)
			instance = new MailBox();
		return instance;
	}
	List<Mail> mail = new ArrayList<Mail>();
	
	
	public void addMail(Mail m ) // newMessage
	{
		this.mail.add(m);
		notifyObservers();
	}


	public Mail getLastMail() // read
	{
		return this.mail.get(mail.size()-1);
	}


	public Integer getNbreMail() {
		return mail.size();
	}
	
	public boolean isEmpty()
	{
		return mail.isEmpty();
	}

		
	
	
}

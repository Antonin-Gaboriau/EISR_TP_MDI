package mailbox;

import javax.swing.JLabel;

public class CounterObserver extends JLabel implements Observer  
{	
	@Override
	public void update(Subject subject) 
	{
		MailBox mailbox = (MailBox) subject;
		this.setText(mailbox.getNbreMail().toString());
	}
	

}

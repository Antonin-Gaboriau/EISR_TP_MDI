package mailbox;

import javax.swing.JLabel;

public class CounterObserver extends JLabel implements Observer  
{	
	@Override
	public void update(Subject mailbox) 
	{
		MailBox a = (MailBox) mailbox;
		this.setText(a.getNbreMail().toString());
	}
	

}

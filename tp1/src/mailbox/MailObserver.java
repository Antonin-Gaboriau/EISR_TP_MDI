package mailbox;

import javax.swing.JLabel;

public class MailObserver extends JLabel implements Observer {

	@Override
	public void update(Subject subject) 
	{
		System.out.println("tamereenslip");
		MailBox mailbox = (MailBox) subject;
		if(!mailbox.isEmpty()) {this.setText(mailbox.getLastMail().getSubject());}
	}

}

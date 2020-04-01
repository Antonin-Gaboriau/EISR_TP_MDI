package mailbox;

import javax.swing.JLabel;

public class MailObserver extends JLabel implements Observer {

	@Override
	public void update(Subject mailbox) 
	{
		System.out.println("tamereenslip");
		MailBox mailbox_cast = (MailBox) mailbox;
		if(!mailbox_cast.isEmpty()) {this.setText(mailbox_cast.getLastMail().getSubject());}
	}

}

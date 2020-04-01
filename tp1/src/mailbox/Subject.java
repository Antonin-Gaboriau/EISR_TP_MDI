package mailbox;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject 
{
	public List<Observer> list = new ArrayList<Observer>();
	
	 void attach(Observer obs)
	 {
		 list.add(obs);

	 }
	 
	 void detach(Observer obs)
	 {
		list.remove(obs);

	 }
	 
	 void notifyObservers()
	 {
		 for(int i = 0; i< list.size(); i++)
		 {
			 list.get(i).update(this);
		 }
	 }
	 
	 
}

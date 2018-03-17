package in.ronak.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import in.ronak.messenger.database.DatabaseClass;
import in.ronak.messenger.model.Message;
import in.ronak.messenger.model.Profile;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService () {
		messages.put(1L, new Message(1, "Hello World !", "Vinay"));
		messages.put(2L,new Message(2, "Hello Jersey !", "Krishna"));
	}

	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
/*		Message m1 = new Message(1l, "Hello World !", "Vinay" );
		Message m2 = new Message(2l, "Hello Jersey !", "Krishna" );
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;*/
	}
	
	public List<Message> getAllMessagesForYear (int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if (start+size > list.size()) return new ArrayList<Message>(); 
		return list.subList(start, start+size);
	}
	
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		} 
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}

package xpadro.spring.jms.receiver;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xpadro.spring.jms.model.Notification;

@Component("asyncTopicBarReceiver")
public class AsyncTopicBarReceiver   implements MessageListener {
	@Autowired
	private NotificationRegistry registry;

	public void receive(Notification notification) {
		//System.out.println("Recibiendo 1...."+ notification.getMessage());
		registry.registerNotification(notification);
	}

	@Override
	public void onMessage(Message message) {
		System.out.println("MENSAJE 1....");
		
	}
}

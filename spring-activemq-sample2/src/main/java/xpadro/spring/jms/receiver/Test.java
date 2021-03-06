package xpadro.spring.jms.receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xpadro.spring.jms.producer.Producer;

public class Test {

	public static void main(String[] args) {
		// init spring context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jms-config.xml");

		// get bean from context
		Producer jmsMessageSender = (Producer) ctx.getBean("producer");

		jmsMessageSender.send("My message");
		jmsMessageSender.send("Otro message");

		// send to default destination
		// jmsMessageSender.send("hello JMS");

		// send to a code specified destination
		// Queue queue = new ActiveMQQueue("AnotherDest");
		// msMessageSender.send(queue, "hello Another Message");

		// close spring application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}

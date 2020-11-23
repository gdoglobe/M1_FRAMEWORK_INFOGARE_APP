package fr.pantheonsorbonne.ufr27.miage.jms;

import java.io.IOException;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.jms.JMSException;
import javax.naming.NamingException;



public class AppPublisher {

	
	public static void main(String[] args) throws JMSException, NamingException, InterruptedException, IOException {
		
		// initialize CDI 2.0 SE container
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();

		try (SeContainer container = initializer.disableDiscovery().addPackages(AppPublisher.class).initialize()) {

			// create a message produce and consumer
			final OrderPublisher orderPublisher = container.select(OrderPublisher.class).get();
			orderPublisher.publish("test1Marseille", "MarseilleTopic");
				orderPublisher.publish("test1Paris", "ParisTopic");
				orderPublisher.publish("test1Lyon", "LyonTopic");

			orderPublisher.close();

		}

	}

}

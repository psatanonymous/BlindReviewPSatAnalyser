package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.SendProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Sent2Transaction extends Transaction {

	public Sent2Transaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Sent2", subjectName, senderName, recipientName, message);
		
		addProcess(new SendProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

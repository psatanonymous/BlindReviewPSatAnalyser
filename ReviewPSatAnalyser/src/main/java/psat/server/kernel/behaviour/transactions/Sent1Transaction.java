package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.AckSendProcess;
import psat.server.kernel.behaviour.processes.SendProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Sent1Transaction extends Transaction {

	public Sent1Transaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Sent1", subjectName, senderName, recipientName, message);
		
		addProcess(new SendProcess(subjectName, senderName, recipientName, message, sessionid,  sinstance, instance));
		addProcess(new AckSendProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

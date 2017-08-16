package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.InformRProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Notice2RTransaction extends Transaction {

	public Notice2RTransaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Notice2-r", subjectName, senderName, recipientName, message);
		
		addProcess(new InformRProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.AckInformRProcess;
import psat.server.kernel.behaviour.processes.InformRProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Notice1RTransaction extends Transaction {

	public Notice1RTransaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Notice1-r", subjectName, senderName, recipientName, message);
		
		addProcess(new InformRProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
		addProcess(new AckInformRProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}	
}

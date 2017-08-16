package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.InformSuProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Notice2SuTransaction extends Transaction {

	public Notice2SuTransaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Notice2-su", subjectName, senderName, recipientName, message);
		
		addProcess(new InformSuProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

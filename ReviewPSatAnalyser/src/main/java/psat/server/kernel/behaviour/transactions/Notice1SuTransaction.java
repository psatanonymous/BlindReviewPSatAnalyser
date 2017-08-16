package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.AckInformSuProcess;
import psat.server.kernel.behaviour.processes.InformSuProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Notice1SuTransaction extends Transaction {

	public Notice1SuTransaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid, ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Notice1-su", subjectName, senderName, recipientName, message);
		
		addProcess(new InformSuProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
		addProcess(new AckInformSuProcess(subjectName, senderName, recipientName, message, sessionid,  sinstance, instance));
	}
	
}

package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.RequestProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class RequestTransaction extends Transaction {

	public RequestTransaction(String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Request", null, senderName, recipientName, message);
		
		addProcess(new RequestProcess(senderName,recipientName, message, sessionid, sinstance, instance));
	}
	
}

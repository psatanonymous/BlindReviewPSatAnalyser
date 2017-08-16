package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.GrantConsentProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Consent3Transaction extends Transaction {

	public Consent3Transaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Consent3", subjectName, senderName, recipientName, message);
		
		addProcess(new GrantConsentProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

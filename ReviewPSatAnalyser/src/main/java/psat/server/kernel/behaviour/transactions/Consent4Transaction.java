package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.GrantConsentProcess;
import psat.server.kernel.behaviour.processes.SeekConsentProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Consent4Transaction extends Transaction {

	public Consent4Transaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Consent4", subjectName, senderName, recipientName, message);
		
		addProcess(new SeekConsentProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
		addProcess(new GrantConsentProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
	}
	
}

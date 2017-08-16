package psat.server.kernel.behaviour.transactions;

import psat.server.kernel.behaviour.processes.AckGrantConsentProcess;
import psat.server.kernel.behaviour.processes.GrantConsentProcess;
import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class Consent2Transaction extends Transaction {

	public Consent2Transaction(String subjectName, String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super("Consent2", subjectName, senderName, recipientName, message);
		
		addProcess(new GrantConsentProcess(subjectName, senderName, recipientName, message, sessionid, sinstance, instance));
		addProcess(new AckGrantConsentProcess(subjectName, senderName, recipientName, message, sessionid,  sinstance, instance));		
	}
	
}

package psat.server.kernel.behaviour.processes;

import psat.server.kernel.knowledge.Memory;
import psat.server.kernel.knowledge.worlds.*;
import psat.server.kernel.util.ServerAgentFactory;
import psat.server.session.ServerConfigInstance;
import psat.shared.Agent;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class InformRProcess extends Process {
	static final String processName = "inform-r";

	public InformRProcess(String subjectName, String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super(processName, subjectName, senderName, recipientName, message);
		
		execute(sinstance,instance);
	}

	@Override
	protected void execute(ServerConfigInstance sinstance,ConfigInstance instance){
		
		Agent subject = ServerAgentFactory.getAgent(subjectName,sinstance);
		Agent sender = ServerAgentFactory.getAgent(senderName,sinstance);
		Agent recipient = ServerAgentFactory.getAgent(recipientName,sinstance);
		
		//State:r4, self = recipient, agent 1=sender, agent 2 = subject
		if(!subject.getAgentName().equals(recipient.getAgentName())){
			if(!subject.getAgentName().equals(sender.getAgentName())){
				if(!recipient.getAgentName().equals(sender.getAgentName())){
					new Memory(recipient, subjectName, sinstance, instance).substitute(new K41(recipient,subject,sender, message), new K41a(recipient,subject,sender, message),processName, instance);//1
					new Memory(recipient, subjectName, sinstance, instance).substitute(new K42(recipient,sender,subject, message), new K42a(recipient,sender,subject, message),processName, instance);//2
				}
			}
			new Memory(recipient, subjectName, sinstance, instance).substitute(new K22(recipient, subject, message), new K22a(recipient,subject, message),processName, instance);//3
		}
	}

}

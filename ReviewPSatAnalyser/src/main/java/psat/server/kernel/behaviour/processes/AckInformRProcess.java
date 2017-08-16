package psat.server.kernel.behaviour.processes;

import psat.server.kernel.knowledge.Memory;
import psat.server.kernel.knowledge.worlds.*;
import psat.server.kernel.util.ServerAgentFactory;
import psat.server.session.ServerConfigInstance;
import psat.shared.Agent;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class AckInformRProcess extends Process {
	static final String processName = "ackInform-r";

	public AckInformRProcess(String subjectName, String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super(processName, subjectName, senderName, recipientName, message);
		
		execute(sinstance,instance);
	}

	@Override
	protected void execute(ServerConfigInstance sinstance,ConfigInstance instance){
		
		Agent subject = ServerAgentFactory.getAgent(subjectName,sinstance);
		Agent sender = ServerAgentFactory.getAgent(senderName,sinstance);
		Agent recipient = ServerAgentFactory.getAgent(recipientName,sinstance);
		
		//State:s8, self = subject, agent 1=sender, agent 2 = recipient
		if(!subject.getAgentName().equals(recipient.getAgentName())){
			if(!subject.getAgentName().equals(sender.getAgentName())){
				if(!recipient.getAgentName().equals(sender.getAgentName())){
					new Memory(sender, subjectName, sinstance,instance).substitute(new K41(sender,subject,recipient, message), new K41a(sender,subject,recipient, message),processName, instance);//1									
				}
			}
		}
	}

}

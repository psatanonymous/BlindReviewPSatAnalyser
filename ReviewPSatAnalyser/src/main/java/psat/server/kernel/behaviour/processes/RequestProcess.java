package psat.server.kernel.behaviour.processes;

import psat.server.session.ServerConfigInstance;
import psat.shared.Attribute;
import psat.shared.ConfigInstance;

public class RequestProcess extends Process {
	static final String processName = "request";

	public RequestProcess(String senderName,String recipientName, Attribute message, String sessionid,ServerConfigInstance sinstance,ConfigInstance instance) {
		super(processName, null, senderName, recipientName, message);
		
		execute(sinstance,instance);
	}

	@Override
	public void execute(ServerConfigInstance sinstance,ConfigInstance instance){
		//a request process is inconsequential
	}

}

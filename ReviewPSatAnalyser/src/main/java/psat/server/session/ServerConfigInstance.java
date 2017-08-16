package psat.server.session;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import edu.uci.ics.jung.graph.UndirectedGraph;
import psat.server.kernel.util.ServerKNetworkGraph;
import psat.server.kernel.util.ServerSatSerializer;
import psat.shared.Agent;
import psat.shared.KLink;
import psat.shared.KNode;

public class ServerConfigInstance implements Serializable{
	
	static final long serialVersionUID = 1L;
		
	public String sessionid;
	
	//server specific variables
	public boolean busy;
	public ServerSatSerializer serverSatSerializer;
	public boolean learningMaxSubs = false;	
	public UndirectedGraph<KNode, KLink> g;
	public ArrayList<String> pathAgentNames;
	public Agent [] agents;
	public ServerKNetworkGraph kgraph;
	
	public String assertionRolesStorePath;
	
	public double expectedSelfUncertaintyLevel_su;
	public double expectedSelfUncertaintyLevel_s;
	public double expectedSelfUncertaintyLevel_r;
	
	public double currentSelfUncertaintyLevel_su;
	public double currentSelfUncertaintyLevel_s;
	public double currentSelfUncertaintyLevel_r;
	
	public boolean subjectdone2;
	
	public String [] validAgents;

	//assertions related
	public String agentName;
	public Agent agent;
	
	public int a_counter;
	
	public ServerSatSerializer serversatserializer;
	
	public File beliefUncertaintyLevelFile;
	public File satTrainingMeanStoreFile;
	public File satAnalysisMeanStoreFile;
	public File viableProtocolRatioAnalysisMeanStoreFile;
	
}

package psat.server.kernel.verification.collective;

import java.util.ArrayList;

import psat.server.PSatAPI;
import psat.server.kernel.behaviour.InformationFlows;
import psat.server.kernel.knowledge.Memory;
import psat.server.kernel.knowledge.worlds.K1;
import psat.server.kernel.knowledge.worlds.K21;
import psat.server.kernel.knowledge.worlds.K31;
import psat.server.kernel.knowledge.worlds.K41;
import psat.server.session.ServerConfigInstance;
import psat.shared.Agent;
import psat.shared.Attribute;
import psat.shared.CollectiveStrategy;
import psat.shared.ConfigInstance;

public class CGK1InstanceVerifier {
	//Common knowledge of K1
	public static double verify(Agent subject, Agent sender, Agent recipient, ServerConfigInstance sinstance,
			ConfigInstance instance, K1 cg,ArrayList<Agent> agentsInPath){
		
		int totalnoofsubjectimplications =0;
		int noofsubjectimplicationsverified = 0;
		int totalnoofsenderimplications =0;
		int noofsenderimplicationsverified = 0;
		int totalnoofrecipientimplications =0;
		int noofrecipientimplicationsverified = 0;
				
		//verify CK1 implications in subject, sender and{or} recipient
		boolean verifyinsubject = true;
		boolean verifyinsender = true;
		boolean verifyinrecipient = true;
		
		Attribute message = cg.k1a.getAttribute();
		Agent cg_reference = cg.getSelf();
		
		//analyse knowledge of only nodes that has been associated with information-flow
		boolean kObjectsProcessed = false;
		for(String objectName:InformationFlows.processedAgents){
			if(objectName.equals(cg_reference.getAgentName())){
				kObjectsProcessed = true;
				break;
			}
		}
		if(!kObjectsProcessed){
			return Double.NaN;	
		}
		/////		
		
		if(verifyinsubject){
			Agent self = subject;
			Memory m = new Memory(self, subject.getAgentName(), sinstance, instance);
			
			//implication 1: K1
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG){
				if(cg_reference.getAgentName().equals(self.getAgentName())){
					K1 k1 = new K1(self, message);
					if(m.contains(k1.toString())){
						noofsubjectimplicationsverified = noofsubjectimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k1);
					totalnoofsubjectimplications = totalnoofsubjectimplications+1;
				}
			}
			
			//implication 2: K31
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EG){
				if(!self.getAgentName().equals(cg_reference.getAgentName())){
					K31 k31 = new K31(self, cg_reference, message);
					if(m.contains(k31.toString())){
						noofsubjectimplicationsverified = noofsubjectimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k31);
					totalnoofsubjectimplications = totalnoofsubjectimplications+1;
				}
			}
						
			//implication 3: K21
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				if(cg_reference.getAgentName().equals(self.getAgentName())){
					for(Agent r1: agentsInPath){
						if(!r1.getAgentName().equals(cg_reference.getAgentName())){
							K21 k21 = new K21(cg_reference, r1, message);
							if(m.contains(k21.toString())){
								noofsubjectimplicationsverified = noofsubjectimplicationsverified+1;
							}
							PSatAPI.addHighOrderImplication(cg, k21);
							totalnoofsubjectimplications = totalnoofsubjectimplications+1;	
						}
					}
				}					
			}
			
			//implication 5: K41/K42
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				
				for(Agent r1: agentsInPath){
					if(!self.getAgentName().equals(r1.getAgentName()) && !r1.getAgentName().equals(cg_reference.getAgentName())){
						K41 k41 = new K41(self, r1, cg_reference, message);
						if(m.contains(k41.toString())){
							noofsubjectimplicationsverified = noofsubjectimplicationsverified+1;
						}
						PSatAPI.addHighOrderImplication(cg, k41);
						totalnoofsubjectimplications = totalnoofsubjectimplications+1;
					}			
				}
			}				
		}
		
		if(verifyinsender && !subject.getAgentName().equals(sender.getAgentName())){
			Agent self = sender;
			Memory m = new Memory(self, subject.getAgentName(), sinstance, instance);
			
			//implication 1: K1
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG){
				if(cg_reference.getAgentName().equals(self.getAgentName())){
					K1 k1 = new K1(self, message);
					if(m.contains(k1.toString())){
						noofsenderimplicationsverified = noofsenderimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k1);
					totalnoofsenderimplications = totalnoofsenderimplications+1;
				}
			}
			
			//implication 2: K31
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EG){
				if(!self.getAgentName().equals(cg_reference.getAgentName())){
					K31 k31 = new K31(self, cg_reference, message);
					if(m.contains(k31.toString())){
						noofsenderimplicationsverified = noofsenderimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k31);
					totalnoofsenderimplications = totalnoofsenderimplications+1; 
				}
				
			}
						
			//implication 3: K21		
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				if(cg_reference.getAgentName().equals(self.getAgentName())){
					for(Agent r1: agentsInPath){
						if(!r1.getAgentName().equals(cg_reference.getAgentName())){
							K21 k21 = new K21(cg_reference, r1, message);
							if(m.contains(k21.toString())){
								noofsenderimplicationsverified = noofsenderimplicationsverified+1;
							}
							PSatAPI.addHighOrderImplication(cg, k21);
							totalnoofsenderimplications = totalnoofsenderimplications+1;
						}							
					}
				}
			}
			
			//implication 5: K41/K42
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				
				for(Agent r1: agentsInPath){
					if(!self.getAgentName().equals(r1.getAgentName()) && !r1.getAgentName().equals(cg_reference.getAgentName())){
						K41 k41 = new K41(self, r1, cg_reference, message);
						if(m.contains(k41.toString())){
							noofsenderimplicationsverified = noofsenderimplicationsverified+1;
						}
						PSatAPI.addHighOrderImplication(cg, k41);
						totalnoofsenderimplications = totalnoofsenderimplications+1;
					}			
				}
			}
		}
		
		if(verifyinrecipient){
			Agent self = recipient;
			Memory m = new Memory(self, subject.getAgentName(), sinstance, instance);
			
			//implication 1: K1
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG){
				if(cg_reference.getAgentName().equals(self.getAgentName())){
					K1 k1 = new K1(self, message);
					if(m.contains(k1.toString())){
						noofrecipientimplicationsverified = noofrecipientimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k1);
					totalnoofrecipientimplications = totalnoofrecipientimplications+1;
				}
			}
			
			//implication 2: K31
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EG){
				if(!self.getAgentName().equals(cg_reference.getAgentName())){
					K31 k31 = new K31(self, cg_reference, message);
					if(m.contains(k31.toString())){
						noofrecipientimplicationsverified = noofrecipientimplicationsverified+1;
					}
					PSatAPI.addHighOrderImplication(cg, k31);
					totalnoofrecipientimplications = totalnoofrecipientimplications+1; 
				}
				

			}
						
			//implication 3: K21		
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				//implication 3: K21a			
				if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
					if(cg_reference.getAgentName().equals(self.getAgentName())){
						for(Agent r1: agentsInPath){
							if(!r1.getAgentName().equals(cg_reference.getAgentName())){
								K21 k21 = new K21(cg_reference, r1, message);
								if(m.contains(k21.toString())){
									noofrecipientimplicationsverified = noofrecipientimplicationsverified+1;
								}
								PSatAPI.addHighOrderImplication(cg, k21);
								totalnoofrecipientimplications = totalnoofrecipientimplications+1;	
							}							
						}
					}
				}
			}
			
			//implication 5: K41/K42
			if(PSatAPI.instance.collectiveStrategy == CollectiveStrategy.CG ||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEG||PSatAPI.instance.collectiveStrategy == CollectiveStrategy.EEEG){
				
				for(Agent r1: agentsInPath){
					if(!self.getAgentName().equals(r1.getAgentName()) && !r1.getAgentName().equals(cg_reference.getAgentName())){
						K41 k41 = new K41(self, r1, cg_reference, message);
						if(m.contains(k41.toString())){
							noofrecipientimplicationsverified = noofrecipientimplicationsverified+1;
						}
						PSatAPI.addHighOrderImplication(cg, k41);
						totalnoofrecipientimplications = totalnoofrecipientimplications+1;
					}			
				}
			}							
		}
				
		int totalnoofimplications = totalnoofsubjectimplications+totalnoofsenderimplications+totalnoofrecipientimplications;
		int noofimplicationsverified = noofsubjectimplicationsverified + noofsenderimplicationsverified+noofrecipientimplicationsverified;
		
		if(totalnoofimplications == 0){
			PSatAPI.addHighOrderImplication(cg, null);
			return Double.NaN;
		}
		
		double sat = (double)noofimplicationsverified/(double)totalnoofimplications;
		return sat;
	}

}

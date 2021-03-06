package psat.server.kernel.knowledge.worlds;

import java.io.Serializable;

import psat.shared.Agent;
import psat.shared.Attribute;

public class K22b extends World implements Serializable {
	private static final long serialVersionUID = 1L;
	private Agent self;
	private Agent agent2;
	private Attribute attribute;
	private boolean knows = false;
	public static String htmlType1;
	
	public K22b(Agent self, Agent agent2, Attribute attribute){
		this.self = self;
		this.agent2 = agent2;
		this.attribute = attribute;
		
		super.type = "K22b";
		super.htmlType = "<i>k</i><sub>22b</sub>";
		htmlType1 = super.htmlType;
	}

	public boolean knows() {
		return knows;
	}
	
	@Override
	public Agent getSelf() {
		return self;
	}
	
	@Override
	public Agent getAgent2(){
		return agent2;
	}
	
	@Override
	public Agent getAgent1(){
		return null;
	}
	
	
	
	public Attribute getAttribute() {
		return attribute;
	}
	
	@Override
	public String toHtmlString(){
		String res = "<html>";
		if(!knows){
			res = res+"¬";
		}
		res = res+"<i>B</i><sub>"+self.getAgentName()+"</sub>"+
				  "<i>K</i><sub>"+agent2.getAgentName()+"</sub>"+
				  "<i>K</i><sub>"+self.getAgentName()+"</sub>"+attribute.toHtmlString();
		res = res+"</html>";
				
		return res;
	}

	@Override
	public String toLimitHtmlString() {
		String res = "";
		if(!knows){
			res = res+"¬";
		}
		res = res+"<i>B</i><sub>"+self.getAgentName()+"</sub>"+
				  "<i>K</i><sub>"+agent2.getAgentName()+"</sub>"+
				  "<i>K</i><sub>"+self.getAgentName()+"</sub>"+attribute.toHtmlString();
	
		return res;
	}
	
	@Override
	public String toString() {
		String res = "";
		if(!knows){
			res = res+"¬";
		}
		res = res+"B_"+self.getAgentName()+"_"+
				  "K_"+agent2.getAgentName()+"_"+
				  "K_"+self.getAgentName()+"_"+attribute.toString();
	
		return res;
	}

	@Override
	public String getGenericMeaning(String genericSelf, String genericAgent1, String genericAgent2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getMeaning() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGenericFormula(String genericSelf, String genericAgent1,String genericAgent2) {
		// TODO Auto-generated method stub
		return null;
	}
}

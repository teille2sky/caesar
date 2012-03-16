package instruction;

import traduction.VisiteurTraduction;

public class InstructionIf extends InstructionConditionelle {

	public InstructionIf(Condition cond) {
		super(cond);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accepte(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

	public String toString(){
		String res = "";
		res+="if("+condition+"){\n";
		for (Instruction is : enfants){
			res += "\t" + is + ";\n";
		}
		res+="\t}\n";
		return res;
	}
	
}

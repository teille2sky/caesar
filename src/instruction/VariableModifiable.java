package instruction;

import traduction.VisiteurTraduction;

public class VariableModifiable extends Variable{

	public VariableModifiable(TypeVariable type, String nom,  String valeur){
		super(type, nom, valeur);
	}
	@Override
	public boolean isConstante() {
		return false;
	}
	
	@Override
	public void accepte(VisiteurTraduction v) {
		// TODO Auto-generated method stub
	}
	
}

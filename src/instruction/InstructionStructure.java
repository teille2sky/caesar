package instruction;

import java.util.List;

public abstract class InstructionStructure implements Instruction {

	protected List enfants;

	@Override
	public abstract Categorie getCategorie();

	@Override
	public List<Instruction> getEnfants() {
		return enfants;
	}

	@Override
	public abstract void accept(VisiteurTraduction visiteur);

	
}

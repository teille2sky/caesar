package instruction;

public class InstructionTache extends InstructionInconditionelle {

	@Override
	public Categorie getCategorie() {
		return Categorie.CONTROL;
	}

	@Override
	public void accept(VisiteurTraduction visiteur) {
		visiteur.visiter(this);
	}

}

package jscratch.modeles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import nxtim.instruction.Categorie;
import jscratch.vue.categories.boutons.BoutonCategorie;
import jscratch.vue.categories.boutons.BoutonCategorieAffichage;
import jscratch.vue.categories.boutons.BoutonCategorieCapteur;
import jscratch.vue.categories.boutons.BoutonCategorieControle;
import jscratch.vue.categories.boutons.BoutonCategorieExpression;
import jscratch.vue.categories.boutons.BoutonCategorieInstruction;
import jscratch.vue.categories.boutons.BoutonCategorieMoteur;
import jscratch.vue.categories.boutons.BoutonCategorieTemps;
import jscratch.vue.categories.boutons.BoutonCategorieVariable;

/**
 *
 * @author Quentin GOSSELIN <quentin.gosselin@gmail.com>
 */
public class DicoBoutonsCategories {

	private static DicoBoutonsCategories instance = null;
	private List<Categorie> ordre;
	private HashMap<Categorie, BoutonCategorie> dico;
	
	/**
	 * Constructeur privé de <code>DicoCategories</code>.
	 */
	private DicoBoutonsCategories() {
		this.dico = new HashMap<Categorie, BoutonCategorie>();
		
		this.dico.put(Categorie.INSTRUCTION,new BoutonCategorieInstruction());
		this.dico.put(Categorie.CONTROLE, new BoutonCategorieControle());
		this.dico.put(Categorie.MOTEUR, new BoutonCategorieMoteur());
		this.dico.put(Categorie.AFFICHAGE, new BoutonCategorieAffichage());
		this.dico.put(Categorie.CAPTEURS, new BoutonCategorieCapteur());
		this.dico.put(Categorie.TEMPS, new BoutonCategorieTemps());
		this.dico.put(Categorie.VARIABLES, new BoutonCategorieVariable());
		this.dico.put(Categorie.EXPRESSION, new BoutonCategorieExpression());
		
		this.ordre = new LinkedList<Categorie>();
		this.ordre.add(Categorie.INSTRUCTION);
		this.ordre.add(Categorie.CONTROLE);
		this.ordre.add(Categorie.MOTEUR);
		this.ordre.add(Categorie.AFFICHAGE);
		this.ordre.add(Categorie.CAPTEURS);
		this.ordre.add(Categorie.TEMPS);
		this.ordre.add(Categorie.VARIABLES);
		this.ordre.add(Categorie.EXPRESSION);
	}
	
	/**
	 * Permet d'avoir l'instance unique de <code>DicoBoutonsCategories</code>.
	 * 
	 * @return l'instance unique de <code>DicoBoutonsCategories</code>
	 */
	public static DicoBoutonsCategories getInstance() {
		if (instance == null) {
			instance = new DicoBoutonsCategories();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer le dictionnaire des boutons catégorie.
	 * 
	 * @return  le dictionnaire des boutons
	 */
	public HashMap<Categorie, BoutonCategorie> getDico() {
		return this.dico;
	}
	
	public List<BoutonCategorie> getBoutons() {
		List<BoutonCategorie> l = new LinkedList<BoutonCategorie>();
		
		for (Categorie c : this.ordre) {
			l.add(this.dico.get(c));
		}
		
		
		return l;
	}
}
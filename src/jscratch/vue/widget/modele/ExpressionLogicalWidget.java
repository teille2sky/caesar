package jscratch.vue.widget.modele;

import jscratch.vue.widget.modele.zones.ChampTexte;

import java.awt.Point;
import java.awt.Polygon;
import nxtim.instruction.Condition;
import nxtim.instruction.Operateur;

/**
 * Classe heritant de ModeleWidget et implementant Seriliazable modelisant la
 * forme d'un widget de type Expression logique.
 * 
 * @since 1.0
 * @version 1.0
 */
public class ExpressionLogicalWidget extends ModeleWidget {

	/**
	 * Constructeur du modele definissant les differents parametres du ExpressionSum .
	 */
	public ExpressionLogicalWidget(Operateur op) {
		int tabX[] = {0, 10, 57, 67, 57, 10};
		int tabY[] = {10, 0, 0, 10, 20, 20};		
		
		this.setTabX(tabX);
		this.setTabY(tabY);

		this.attachableBas = false;
        this.attachableHaut = false;
        this.imbricable = false;
        this.attachableInterne = true;
		
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeModeleWidget.EXPRESSION_LOGIQUE);

		message.put(new Point(30, 17), op.toString());

		this.setElementProgramme(new Condition(op));
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ChampTexte l = new ChampTexte();
		
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		l.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		l.setBounds(10, 3, 14, 14);
		this.getLesZonesSaisies().add(l);

		ChampTexte f = new ChampTexte();
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_ARITHMETIQUE);
		f.setBounds(40, 3, 14, 14);
		this.getLesZonesSaisies().add(f);
	}

	@Override
	public void decalageX(int x) {
		int i;
		for (i = 2; i < this.getTabX().length-1; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + x ;
		}
		this.setForme(this.getForme());
		this.setTailleX();
	}

	public void initListeners() { }
}
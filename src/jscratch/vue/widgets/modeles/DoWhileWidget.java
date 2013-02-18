package jscratch.vue.widgets.modeles;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.Serializable;
import jscratch.parametrages.Variables;
import jscratch.vue.widgets.Widget;
import jscratch.vue.widgets.modeles.zones.ChampTexte;
import nxtim.instruction.Condition;
import nxtim.instruction.InstructionDoWhile;

/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type DoWhile
 *
 * @since 1.0
 * @version 1.0
 */
public class DoWhileWidget extends ModeleWidget implements Serializable {
	
	private ChampTexte f;
	
	/**
	 * Constructeur du modèle définissant les différents paramètres du DoWhile.
	 */
	public DoWhileWidget() {
		int[] tX = {0, 5,/**/ 30, 35, 45, 50,/**/ 130, 135, /**/ 135, 130,/**/ 55, 50, 40, 35, /**/ 10, 5,/**/ 5, 10,/**/ 35, 40, 50, 55,/**/ 130, 135,/**/ 135, 130,/**/ 50, 45, 35, 30,/**/ 5, 0};
		int[] tY = {5, 0,/**/ 0, 5, 5, 0,/**/ 0, 5, /**/ 10, 15,/**/ 15, 20, 20, 15, /**/ 15, 20,/**/ 25, 30,/**/ 30, 35, 35, 30,/**/ 30, 35,/**/ 50, 55,/**/ 55, 60, 60, 55,/**/ 55, 50};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setType(TypeModeleWidget.DOWHILE);

		message.put(new Point(5, 13), "Faire tant que");
		
		int widthChamp = 20;
		f = new ChampTexte(widthChamp, this);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.VARIABLE);
		f.ajouterTypeWidgetAccepte(TypeModeleWidget.EXPRESSION_LOGIQUE);
		f.setBounds(95, 33, widthChamp, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);

		this.setElementProgramme(new InstructionDoWhile());
		this.setConditionHaute(false);
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));
		this.zonesAccroches.add(Variables.ZONE_ACCROCHE_DOWHILE);
	}
	
	@Override
	public void applyChangeModele(){		
		Widget contentWidget = f.getContentWidget();
		
		// On met à jour la condition dans l'elementProgramme si elle existe
		if (contentWidget != null) {
			InstructionDoWhile doWhileIns = ((InstructionDoWhile) getElementProgramme());
			Condition cond = (Condition) contentWidget.getElementProgramme();
			doWhileIns.setCondition(cond);
		}
	}

	@Override
	public void decalageX(int a) {
		int i;
		for (i = 6; i < 10; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		for (i = 22; i < 26; i++) {
			this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
		}
		this.setForme(this.getForme());
		this.setTailleX();		
	}

	@Override
	public void decalageY(int b, Rectangle r) {
		int i;
		for (i = 16; i < tabY.length; i++) {
			this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
		}
		this.setForme(this.getForme());
		this.setTailleY();
	}
}

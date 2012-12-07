package vue.widget.modele;

import vue.widget.modele.zones.ChampTexte;
import vue.widget.modele.zones.ListeDeroulante;
import vue.widget.modele.zones.Zone;
import instruction.*;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComponent;

import modeles.TypeWidget;
/**
 * Classe héritant de ModeleWidget et implémentant Seriliazable modélisant la
 * forme d'un widget de type MoteurRev
 * 
 * @author Bastien Aubry - Vincent Besnard - Quentin Gosselin
 */
public class MoteurMovRevWidget extends ModeleWidget {
	/**
	 * Constructeur du modèle définissant les différents paramètres du MoteurFwd.
	 */
	public MoteurMovRevWidget() {
		super();
		int tX[] = {0, 5, 30, 35, 45, 50, 170, 175, 175, 170, 50, 45, 35, 30, 5, 0};
		int tY[] = {5, 0, 0, 5, 5, 0, 0, 5, 20, 25, 25, 30, 30, 25, 25, 20};

		this.setTabX(tX);
		this.setTabY(tY);
		this.setTailleX();
		this.setTailleY();
		this.setType(TypeWidget.MOTEURMOVREV);
		
		//this.setMessage("Moteur           recul de");
		message.put(new Point(5, 17), "Moteur");
		message.put(new Point(94, 17), "recul à");
		
		this.setElementProgramme(new InstructionMoteurMov());
		this.setForme(new Polygon(this.getTabX(), this.getTabY(), this.getTabX().length));

		ListeDeroulante<Moteur> l = new ListeDeroulante<Moteur>(Moteur.values());
		l.setBounds(55, 3, 35, 20);
		this.getLesZonesSaisies().add(l);
		
		ChampTexte f = new ChampTexte();
		f.setBounds(142, 3, 40, 20);
		f.setValeur("0");
		this.getLesZonesSaisies().add(f);
		
		setInstructionMoteur(l.getValeur());
		setInstructionValeur(f.getValeur());
			
		this.decalageXout(11);

		initListeners();
	}

	@Override
	public void decalageXout(int a) {
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] + a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }

	@Override
    public void decalageXin(int a) {
        int i;
        for (i = 6; i < 10; i++) {
            this.getForme().xpoints[i] = this.getForme().xpoints[i] - a;
        }
        this.setForme(this.getForme());
        this.setTailleX();
    }

	@Override
    public void decalageYout(int b,Rectangle r) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] + b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }

	@Override
    public void decalageYin(int b, Rectangle r) {
        int i;
        for (i = 8; i < 16; i++) {
            this.getForme().ypoints[i] = this.getForme().ypoints[i] - b;
        }
        this.setForme(this.getForme());
        this.setTailleY();
    }

	@Override
	public void initListeners() {
		((JComponent) this.getLesZonesSaisies().get(0)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionMoteur(((Zone) getLesZonesSaisies().get(0)).getValeur());
			}
		});
		((JComponent) this.getLesZonesSaisies().get(1)).addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				setInstructionValeur(((Zone) getLesZonesSaisies().get(1)).getValeur());
			}
		});
	}
	
	/**
	 * Méthode permettant de définir l'instruction moteur du widget
	 * 
	 * @param nom L'instruction Moteur à définir sur le modèle
	 */
	private void setInstructionMoteur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setMoteur(Moteur.values()[Integer.parseInt(nom)]);
	}

	/**
	 * Méthode permettant de définir la valeur de l'instruction moteur
	 * 
	 * @param nom La valeur de l'instruction moteur
	 */
	private void setInstructionValeur(String nom) {
		((InstructionMoteurMov) getElementProgramme()).setReverse(true);
		((InstructionMoteurMov) getElementProgramme()).setExpression(new VariableConstante(TypeVariable.INT, "", nom));
	}
}

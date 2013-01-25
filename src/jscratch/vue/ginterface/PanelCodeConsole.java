package jscratch.vue.ginterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Panneau d'affichage du code traduit.
 *
 * @since 1.0
 * @version 1.0
 */
public class PanelCodeConsole extends JPanel implements Observer {

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 */
	private static PanelCodeConsole instance = new PanelCodeConsole();
	private JTextArea textarea;

	/**
	 * @since 1.0
	 */
	private PanelCodeConsole() {
		this.textarea = new JTextArea();
		this.textarea.setEditable(false);
		this.textarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(100, 600));
		this.setBorder(BorderFactory.createTitledBorder("Code NXC"));

		this.add(textarea, BorderLayout.CENTER);
	}

	/**
	 * SINGLETON.
	 *
	 * @since 1.0
	 *
	 * @return L'instance unique de PanelWidget.
	 */
	protected static PanelCodeConsole getInstance() {
		return instance;
	}

	/**
	 * @since 1.0
	 *
	 * @param texte Le texte à afficher dans la zone.
	 */
	public void setText(String texte) {
		this.textarea.setText(texte);
	}

	@Override
	public void update(Observable o, Object o1) {
		// Mise à jour du texte dans la zone, envoyer le code au format String pas un objet
		this.setText(o1.toString());
		this.repaint();
	}
}
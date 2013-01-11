/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.ginterface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import modeles.DicoVars;
import nxtim.instruction.Variable;
import vue.categories.BoutonCategorieVariable;

/**
 *
 * @author Quentin
 *
 *
 */
public class FenetreSupressionVariable extends JFrame {

	private JComboBox variables;
	private JButton boutonValider;

	public FenetreSupressionVariable() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);

		variables = new JComboBox(DicoVars.getInstance().getLesvariables());
		boutonValider = new JButton("Valider");

		Box boxV = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();

		this.setContentPane(boxV);

		boxV.add(Box.createVerticalStrut(10));
		boxV.add(boxH1);
		boxV.add(Box.createVerticalStrut(10));

		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(variables);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(boutonValider);
		boxH1.add(Box.createHorizontalStrut(10));

		this.pack();
		this.setLocationRelativeTo(GUI.getFenetre());
		this.setVisible(true);

		boutonValider.addActionListener(new ActionListener() {
			@ Override
			public void actionPerformed(ActionEvent ae) {
				String variable = ((Variable) variables.getSelectedItem()).getNom();
				DicoVars.getInstance().supprimer(variable);

				BoutonCategorieVariable bcv = (BoutonCategorieVariable) GUI.getPanelTypeWidget().getCurrentCategorie();
				bcv.supprimerWidgetVariable(variable);

				dispose();
			}
		});
	}
}

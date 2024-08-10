package kirjanpito.ui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import kirjanpito.ui.resources.Resources;

/**
 * Tietoja ohjelmasta -ikkuna.
 * 
 * @author Tommi Helineva
 */
public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutDialog(Frame owner) {
		super(owner, "Tietoja ohjelmasta " +
				Kirjanpito.APP_NAME, true);
	}

	/**
	 * Luo ikkunan komponentit.
	 */
	public void create() {
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

		GridBagConstraints c = new GridBagConstraints();

		ImageIcon icon = new ImageIcon(Resources.loadAsImage("tilitin-48x48.png"));
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(15, 10, 5, 10);
		c.weightx = 1.0;
		c.weighty = 0.5;
		add(new JLabel(icon), c);

		JLabel label;

		label = new JLabel("<html><big><b>" +
				Kirjanpito.APP_NAME + " " + Kirjanpito.APP_VERSION +
				"</b></big></html>");

		c.gridy = 1;
		c.insets = new Insets(5, 40, 5, 40);
		c.weighty = 0.0;
		add(label, c);

		label = new JLabel("Kirjanpito-ohjelma");
		c.gridy = 2;
		c.insets = new Insets(5, 10, 5, 10);
		add(label, c);

		JTextPane textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setText(
				"""
							<html>
							<body style='width: 300px; word-wrap: break-word;'>
							<p>© 2009–2013 Tommi Helineva<br>
							© 2024 Jouni Seppänen</p>
							<p>Tämä on vapaa ohjelma: tätä ohjelmaa saa levittää edelleen ja muuttaa
							Free Software Foundationin julkaiseman GNU General Public Licensen
							(GPL-lisenssi) version 3 ehtojen mukaisesti.</p>
							<p>Tätä ohjelmaa levitetään siinä toivossa, että se olisi hyödyllinen
							mutta ilman mitään takuuta; edes hiljaista takuuta kaupallisesti hyväksyttävästä
							laadusta tai soveltuvuudesta tiettyyn tarkoitukseen. Katso GPL-lisenssistä
							lisää yksityiskohtia.</p>
							<p>Tämän ohjelman mukana pitäisi tulla kopio GPL-lisenssistä tiedostossa
							COPYING. Jos näin ei ole, katso<br>
							http://www.gnu.org/licenses/.</p>
							</body>
							</html>
						""");
		textPane.setEditable(false);
		textPane.setBorder(null);

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(400, 380));
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		c.gridy = 3;
		c.fill = GridBagConstraints.BOTH;
		add(scrollPane, c);

		JButton closeButton = new JButton("Sulje",
				new ImageIcon(Resources.loadAsImage("close-22x22.png")));
		closeButton.setMnemonic('S');
		closeButton.setPreferredSize(new Dimension(100, 35));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.gridy = 4;
		c.insets = new Insets(10, 10, 10, 10);
		c.weighty = 0.5;
		add(closeButton, c);

		getRootPane().setDefaultButton(closeButton);
		pack();
		setLocationRelativeTo(getOwner());
	}
}

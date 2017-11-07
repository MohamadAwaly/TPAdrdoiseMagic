import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import sun.font.EAttribute;

import com.sun.glass.events.KeyEvent;

public class Fenetre extends JFrame {

	// toolbar
	private JToolBar toolBar = new JToolBar();

	private JButton pinceau1 = new JButton(new ImageIcon("image/pinceau1.jpg")),
			pinceau2 = new JButton(new ImageIcon("image/pimceau2.jpg")),
			colorBlue = new JButton(new ImageIcon("image/blue.jpg")),
			colorRed = new JButton(new ImageIcon("image/red.jpg")),
			colorGreen = new JButton(new ImageIcon("image/green.png"));

	private JPanel contenaire = new JPanel();
	private Panneau pan = new Panneau();
	private JMenuBar menubar = new JMenuBar();

	// entete menu
	private JMenu fichier = new JMenu("Fichier");
	private JMenu edition = new JMenu("Edition");

	// Item du menu Fichier
	private JMenuItem effacer = new JMenuItem("Effacer");
	private JMenuItem quitter = new JMenuItem("Quitter");

	// Item menu du menu Edition
	private JMenu formepointeur = new JMenu("Forme du pointeur");
	private JMenu couleurpointeur = new JMenu("Couleur du pointeur");

	// Item du sous menu edition forme du poitneur
	private JMenuItem rond = new JMenuItem("Rond");
	private JMenuItem carre = new JMenuItem("Carre");

	// Item sous menu couleur du pointeur
	private JMenuItem rouge = new JMenuItem("Rouge");
	private JMenuItem vert = new JMenuItem("Vert");
	private JMenuItem bleu = new JMenuItem("Bleu");
	private JMenuItem white = new JMenuItem("gomme");

	public Fenetre() {

		// Creation de la fenetre
		this.setTitle("Laroise Magic");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.white);
		contenaire.setBackground(Color.white);
		contenaire.setLayout(new BorderLayout());
		contenaire.add(pan, BorderLayout.CENTER);
		// contenaire.add(pinceau1, BorderLayout.SOUTH);
		this.initToolbar();
		this.initMenu();

		this.setContentPane(contenaire);
		this.setVisible(true);

		// Ajout des Actions

		pan.addMouseMotionListener(new boutonListnerMouse());

		rouge.addActionListener(new CouleurListener());
		vert.addActionListener(new CouleurListener());
		bleu.addActionListener(new CouleurListener());
		white.addActionListener(new CouleurListener());

		colorBlue.addActionListener(new CouleurListener());
		colorGreen.addActionListener(new CouleurListener());
		colorRed.addActionListener(new CouleurListener());

		rond.addActionListener(new FormeListener());
		carre.addActionListener(new FormeListener());
		pinceau1.addActionListener(new FormeListener());
		pinceau2.addActionListener(new FormeListener());

		effacer.addActionListener(new FormeListener());

		// Pour quitter l'application
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});
	}

	private void initMenu() {

		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				KeyEvent.MODIFIER_FUNCTION));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				KeyEvent.MODIFIER_FUNCTION));
		rond.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				KeyEvent.MODIFIER_FUNCTION));
		carre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				KeyEvent.MODIFIER_FUNCTION));
		rouge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				KeyEvent.MODIFIER_FUNCTION));
		vert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				KeyEvent.MODIFIER_FUNCTION));
		bleu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
				KeyEvent.MODIFIER_FUNCTION));
		white.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				KeyEvent.MODIFIER_FUNCTION));

		this.fichier.add(effacer);
		this.fichier.add(quitter);

		// ajout des boutons dans le sous menu Edition
		this.edition.add(formepointeur);
		this.edition.add(couleurpointeur);

		// ajout des bouton du sous menu edition Forme du pointeur
		this.formepointeur.add(rond);
		this.formepointeur.add(carre);

		// ajout des bouton du sous menu edition Couleur du pointeur
		this.couleurpointeur.add(rouge);
		this.couleurpointeur.add(vert);
		this.couleurpointeur.add(bleu);
		this.couleurpointeur.add(white);

		// ajout de la menubare
		this.menubar.add(fichier);
		this.menubar.add(edition);
		this.setJMenuBar(menubar);

	}

	private void initToolbar() {
		this.toolBar.add(pinceau1);
		this.toolBar.add(pinceau2);
		this.toolBar.addSeparator();
		this.toolBar.add(colorBlue);
		this.toolBar.add(colorRed);
		this.toolBar.add(colorGreen);
		contenaire.add(toolBar, BorderLayout.NORTH);
	}

	class CouleurListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rouge || e.getSource() == colorRed) {
				pan.setCouleur(Color.red);
			}
			if (e.getSource() == vert || e.getSource() == colorGreen) {
				pan.setCouleur(Color.green);
			}
			if (e.getSource() == bleu || e.getSource() == colorBlue) {
				pan.setCouleur(Color.blue);
			}
			if (e.getSource() == white) {
				pan.setCouleur(Color.white);
			}

		}
	}

	class FormeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == rond || e.getSource() == pinceau1) {
				pan.setForme("rond");
			}
			if (e.getSource() == carre || e.getSource() == pinceau2) {
				pan.setForme("carre");
			}
			if (e.getSource() == effacer) {
				pan.removeAll();
				pan.repaint();

				
			}

		}
	}

	class boutonListnerMouse implements MouseMotionListener {
		// methode pour recupere la position de la sourie apres le clique
		public void mouseDragged(MouseEvent e) {
			pan.setPosX(e.getX());// recupere la position de la sourie axe X
			pan.setPosY(e.getY());// Recupere la position de la sourie axe Y
			pan.repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}

	}

}

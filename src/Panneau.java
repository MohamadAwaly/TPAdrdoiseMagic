import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Panneau extends JPanel {

	private static final long serialVersionUID = 5669048316418113915L;
	private Color couleur = Color.white;
	private String forme = new String("Yellow");
	private int posX = 10;
	private int posY = 10;
	
	public void paintComponent(Graphics g) {
		
		g.setColor(couleur);
		//g.fillOval(posX, posY, 5, 5);
		draw(g);
	}

	public void draw(Graphics g) {
		if (forme.equals("rond")) {
			g.fillOval(posX, posY, 10, 10);
		}
		if (forme.equals("carre")){
			g.fillRect(posX, posY, 10, 10);
		}
		if(forme.equals("effacer")){
			//removeAll();
		}
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}



}

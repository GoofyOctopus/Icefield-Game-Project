package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.Controller;
import model.Game;
import model.Icefield;

public class GameFrame extends JFrame implements IView{
	//Controller and game class passed in constructor
	private Controller controller = null; 
	private Game mGame;
	private pIcefield icefieldPanel;
	private pStats statsPanel;
	private pBlizzard blizPanel;
	private JPanel mainPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	private boolean blizzard = false;
	public GameFrame(Game mGame, Controller controller) {
		this.mGame = mGame;
		this.controller = controller;
		icefieldPanel = new pIcefield(mGame.icf);
		statsPanel = new pStats();
		blizPanel = new pBlizzard();
		cardPanel.setLayout(cardLayout);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(icefieldPanel);
		mainPanel.add(statsPanel);
		
		cardPanel.add(mainPanel,"first");
		cardPanel.add(blizPanel,"second");
		cardLayout.show(cardPanel, "first");
		this.add(cardPanel);
		this.pack();
		this.setSize(650,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//---------------------------
		mainPanel.setFocusable(true);
		mainPanel.requestFocusInWindow();
	}
	public void close() {
		this.setVisible(false);
		this.dispose();
	}

	public void addKeyListener(KeyListener myListener) {
		this.statsPanel.addKeyListener(myListener);
		this.mainPanel.addKeyListener(myListener);
		this.blizPanel.addKeyListener(myListener);
	}
	
	public void addBtnListener(ActionListener myListener) {};
	
	public void update() {
		icefieldPanel.update();
		//update statspanel also should be done
		statsPanel.playerChange(mGame.figures.get(mGame.currentFigure));
		statsPanel.ShowStats(mGame.numberOfMoves);
		//statsPanel.IcebergChange( mGame.icf.getIceberg(mGame.figures.get(mGame.currentFigure).getIceberg().getX(),
			//	mGame.figures.get(mGame.currentFigure).getIceberg().getY()));
		
	}
	
	/*
	 * In case of blizzard generation, apart form what happens in the view
	 * the controller seta new panel that has the blizzard gif to demonstrate it for the user
	 */
	public void blizzSwap()
	{
		if(blizzard) {
			cardLayout.show(cardPanel, "second");
			blizPanel.setFocusable(true);
			blizPanel.requestFocusInWindow();
			
		}else {
			cardLayout.show(cardPanel, "first");
			mainPanel.setFocusable(true);
			mainPanel.requestFocusInWindow();
		}
	}
	public boolean getBlizzard() {
		return blizzard;
	}
	public void changeBlizzard() {
		blizzard = !blizzard;
	}
	/*
	 * pStats instance cannot be accessed from outside
	 */
	public void showInfo(String info) {
		statsPanel.showInfo(info);
	}
}

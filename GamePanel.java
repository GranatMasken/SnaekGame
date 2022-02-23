package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5552953278284494175L;



	public static final int 
		WIDTH = 600, 
		HEIGHT = 600, 
		GRID = 10, 
		DELAY = 75;
	public static boolean running = false;
	
	
	Timer timer;
	public static Random random;
	
	public static Snake s;
	Food f;
	
	public static int score = 0;
	
	GamePanel(){
		
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(this);
		
		s = new Snake();
		f = new Food();
		
		startGame();
		
	}
	
	
    public void startGame() {
    	timer = new Timer(DELAY, this);
    	
    	timer.setInitialDelay(DELAY);
    	timer.start();
    	
    	running = true;
    }
    
    
    
    
    @Override
    public void paint(Graphics g) {
    	
    	super.paintComponent(g);
    	Graphics2D g2d = (Graphics2D)g;
    	
    	if (running) {
    	update();
    	
    	
    	
    	
    	
    	
    	s.render(g2d);
    	f.render(g2d);
    	
    	
    	//draw text points
    	g2d.setColor(Color.white);
    	g2d.drawString("Score: "+ score, 10, 10);
    	
    	//System.out.println("paint");
    	}else {
    		
        	g2d.setColor(Color.white);
        	
        	g2d.drawString("GAME OVER", WIDTH/2, (HEIGHT/2)-20);

        	
        	g2d.drawString("Score: "+ score, WIDTH/2, HEIGHT/2);
    	}

    }
    

    public void update() {
   
    	s.update();
    	foodCheck();
    	
    	if(s.collision()) gameOver();
    	
    }
    
    public void foodCheck() {
    	//System.out.println(s.body.get(s.body.size()-1).getLocation() + " "+ f.pt.getLocation());
    	if(f.collision()) {
    		s.eat();
    		score++;
    		f.newLocation();
    	}
    }
	
	
	public void gameOver() {
		running = false;
		System.out.println("gameover");
		
	}
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		//1 - LEFT
		//2 - RIGHT
		//3 - TOP
		//4 - BOTTOM
		
			case KeyEvent.VK_LEFT:
				//System.out.println("vänster");
				
				s.input(1);

				break;		
			case KeyEvent.VK_RIGHT:
				
				s.input(2);

				
                break;
			case KeyEvent.VK_UP:
				
				s.input(3);

				
				break;
			case KeyEvent.VK_DOWN:
				
				s.input(4);

				
				break;
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		//System.out.println("repaint");
		repaint();
		
	}
}


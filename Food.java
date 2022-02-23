package main;

import static main.GamePanel.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

public class Food {

	
	public Point pt;
	
	Food(){
		pt = new Point();
		
		newLocation();
	}
		
	void newLocation() {
			do {
				
			Random rand = new Random();
			int delta = GRID;
			pt.setLocation(rand.nextInt(WIDTH/GRID-2*delta)+delta, rand.nextInt(WIDTH/GRID-2*delta)+delta);
				
			}while (collision() == true);
	}
		
		
	boolean collision() {
		
		boolean touching = false;
		
		/*
		for(Point snake: s.body) {
			if(this.pt.getLocation() == snake.getLocation()) {touching = true; System.out.println("collision");}
		}
		*/
		
		for(Point snake: s.body) {
			if(pt.x == snake.x && pt.y == snake.y){touching = true; System.out.println("collision");}
		}
		
		return touching;
	}
	
	void render(Graphics2D g2d) {
		g2d.setColor(Color.green);
		
		g2d.fillRoundRect(pt.x*GRID, pt.y*GRID, GRID, GRID, 1, 1);
		
	}
}

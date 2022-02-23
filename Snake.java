package main;

import static main.GamePanel.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	public List<Point> body;
	
	int size = 5;
	
	int dir = 2;	
	/*
	 * Direction
	 * Left. 1
	 * Right. 2
	 * Up. 3
	 * Down. 4
	 */
	
	Snake(){
		body = new ArrayList<Point>();
		
		Point head = new Point(GRID, GRID);
		body.add(head);
		
		
	}
	
	void render(Graphics2D g2d){
		g2d.setColor(Color.cyan);
		for(Point pt: body) {
			g2d.fillRect(pt.x*GRID, pt.y*GRID, GRID, GRID);
		}
		//System.out.println("snakedraw");
	}
	
	void move() {	
		Point pt = new Point (0,0);
		pt.move(body.get(body.size()-1).x,body.get(body.size()-1).y);
				
		switch (dir){
		case 1:
			pt.move(pt.x-1, pt.y);
			break;
		case 2:
			pt.move(pt.x+1, pt.y);
			break;
		case 3:
			pt.move(pt.x, pt.y-1);
			break;
		case 4:
			pt.move(pt.x, pt.y+1);
			break; 
		}
		body.add(pt);
		
		if(body.size()>=size) {
			body.remove(0);
		}
/*
		if(dir == 2) {
			dir = 4;
		}else if (dir == 4) {
			dir = 2;
		}
*/
	}
	public void input(int dir) {
		
		switch (dir) {
		
		case 1:
			if (this.dir != 2) this.dir = dir;
			break;
		case 2:
			if (this.dir != 1) this.dir = dir;
			break;
		case 3:
			if (this.dir != 4) this.dir = dir;
			break;
		case 4:
			if (this.dir != 3) this.dir = dir;
			break;
			
		 	
		
		}
		
	}
	void update() {
		move();
	}
	
	boolean collision() {
		Point head = body.get(body.size()-1);
		
		boolean collision = false;
		
		for(int i = 0; i<body.size()-1; i++) {
			if(head.x == body.get(i).x && head.y == body.get(i).y) collision = true;
		}
		if(head.x*GRID > WIDTH || head.x*GRID <0 || head.y*GRID > HEIGHT || head.y < 0) collision = true;
		
		return collision;
	}
	
	void eat() {
		size += 2;
	}
	
	
	
}

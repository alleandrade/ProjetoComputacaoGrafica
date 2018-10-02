/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocomputacaografica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 *
 * @author sawa chan
 */
public abstract class Base {
    protected double x;
    protected double y;
    protected int varX = 0;
    protected int varY = 0;
    protected Color color;
    protected Color edge; 
    protected int height,
    			  width;
    protected ImageIcon img;
    protected Rectangle rect = new Rectangle(0,0,30,30);
    protected boolean alive = true;
    protected int velocity = 1;

    
    public Base () {
    	
    }
    
    public Base (String url) {
    	img = new ImageIcon(this.getClass().getResource("/").getPath() + url);
    	width = img.getIconWidth();
    	height = img.getIconHeight();
    	rect.width = width;
    	rect.height = height;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
            return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public void draw(Graphics2D g) {
        if (img != null) {
            if (this.alive)
                g.drawImage(img.getImage(), (int) x, (int) y, null);
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        this.rect.x = (int) x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        this.rect.y = (int) y;
    }

    public int getVarX() {
        return varX;
    }

    public void setVarX(int varX) {
        this.varX = varX;
    }

    public int getVarY() {
        return varY;
    }

    public void setVarY(int varY) {
        this.varY = varY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getEdge() {
        return edge;
    }

    public void setEdge(Color edge) {
        this.edge = edge;
    }
    
    public void movements() {
        x += varX * velocity;
        y += varY * velocity;
        this.rect.x += varX * velocity;
        this.rect.y += varY * velocity;
    }
    
    public ArrayList<Base> colision(int w, int h, ArrayList<Base> array) {
    	if (this.x <= 0) {
            this.varX = 1;
        }
        else if (this.x >= w - this.width) {
            this.varX = -1;
        }
        
        if (this.y <= 30) {
            this.varY = 1;
        }
        
        else if (this.y >= h - this.height) {
            this.varY = -1;
        }
        
        ArrayList<Base> array2 = new ArrayList<Base>();
        
        return array2;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocomputacaografica;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author sawa chan
 */
public class Tiro extends Base {

    public Tiro () {
        this.width = 3;
        rect.width = 3;
        rect.height = 3;
    }
    
    @Override
    public void draw(Graphics2D g) {
        if (this.alive) {
            g.setColor(color);
            g.fillRect((int)x,(int) y, width, width);
            g.setColor(edge);
            g.drawRect((int)x, (int)y, width, width);
        }
    }
    
    @Override
    public ArrayList<Base> colision (int w, int h, ArrayList<Base> array) {
        if (this.x <= -15) {
            this.alive = false;
        }
        
        else if (this.x >= w + 15) {
            this.alive = false;
        }
        
        if (this.y < 15) {
            this.alive = false;
        }
        
        else if (this.y > h + 15) {
            this.alive = false;
        }
        ArrayList<Base> list = new ArrayList<Base>();
        return list;
    }
    
}

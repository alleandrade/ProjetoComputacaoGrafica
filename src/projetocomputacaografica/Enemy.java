package projetocomputacaografica;

import java.util.ArrayList;

public class Enemy extends Base{
    private int tipo;
	//Colisao paredes
    //Colisao tiro
	
    public Enemy (String url) {
        super(url);
    }  
    
    @Override
    public ArrayList<Base> colision (int w, int h, ArrayList<Base> list) {
        ArrayList<Base> array = new ArrayList<Base>();
    	
    	for (Base b: list) {
            if (b.getClass() == Tiro.class) {
                if (this.rect.intersects(b.rect)) {
                    this.alive = false;
                    b.alive = false;
                	Enemy e = new Enemy("img/asteroidmenor.png");
                	Enemy e2 = new Enemy("img/asteroidmenor.png");
                	e.setAlive(false);
                	e2.setAlive(false);
                    
                    if (this.tipo == 1) {
                    	e.setVarX(this.varX);
                    	e.setVarY(this.varY);
                    	e.setX(this.x - 20);
                    	e.setY(this.y);
                    	e.setTipo(2);
                    	e.setAlive(true);
                    
                      	e2.setVarX(this.varX * -1);
                    	e2.setVarY(this.varY);
                    	e2.setX(this.x + 20);
                    	e2.setY(this.y);
                    	e.setTipo(2);
                    	e2.setAlive(true);
                    }
                    
                    array.add(e);
                	array.add(e2);
               }
            }
            
            if (b.getClass() == Aircraft.class) {
            	if (this.rect.intersects(b.rect)) {
            		this.alive = false;
            		b.alive = false;
            	}
            }
            
            if (this.x <= - 15 - this.width) {
                this.alive = false;
            }
        
            else if (this.x >= w + 15 + this.width) {
                this.alive = false;
            }
        
            if (this.y < 15 - this.height) {
               this.alive = false;
            }
        
            else if (this.y > h + 15 + this.height) {
                this.alive = false;
            }
        }
        
        return array;
    }

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}

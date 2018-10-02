/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocomputacaografica;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

/**
 *
 * @author sawa chan
 */
public class Aircraft extends Base {
    private Color gunColor;
    private int histVarX = 0,
                histVarY = 0;
    
    private ImageIcon imgLeft,
    				  imgRight,
    				  imgDown,
    				  imgUpLeft,
    				  imgUpRight,
    				  imgDownRight,
    				  imgDownLeft;
    
    public Aircraft() {
    	
    }
    
    public Aircraft (String up, String down, String left, String right, String upleft, String upright, String downright, String downleft) {
    	img = new ImageIcon(this.getClass().getResource("/").getPath()+ up);
    	imgLeft = new ImageIcon(this.getClass().getResource("/").getPath() + left);
    	imgDown = new ImageIcon(this.getClass().getResource("/").getPath()+ down);
    	imgRight = new ImageIcon(this.getClass().getResource("/").getPath()+ right);
    	imgUpLeft = new ImageIcon(this.getClass().getResource("/").getPath()+ upleft);
    	imgUpRight = new ImageIcon(this.getClass().getResource("/").getPath()+ upright);
    	imgDownRight = new ImageIcon(this.getClass().getResource("/").getPath()+ downright);
    	imgDownLeft = new ImageIcon(this.getClass().getResource("/").getPath()+ downleft);
    	
    	width = img.getIconWidth();
    	height = img.getIconHeight();
    	rect.width = width;
    	rect.height = height;
    }
    
    public int getHistVarX() {
        return histVarX;
    }

    public void setHistVarX(int histVarX) {
        this.histVarX = histVarX;
    }

    public int getHistVarY() {
        return histVarY;
    }

    public void setHistVarY(int histVarY) {
        this.histVarY = histVarY;
    }

    public Color getGunColor() {
        return gunColor;
    }

    public void setGunColor(Color gunColor) {
        this.gunColor = gunColor;
    }
    
    
    
    @Override
    public void draw(Graphics2D g) {
    	if (this.alive) {
    		if (this.img != null && this.imgDown != null && this.imgLeft != null && this.imgRight != null) {
           		if (this.histVarX == 0 && this.histVarY == -1) {
           			g.drawImage(img.getImage(), (int) x, (int) y, null);
           			width = img.getIconWidth();
           	    	height = img.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
           		else if (this.histVarX == 0 && this.histVarY == 1) {
           			g.drawImage(imgDown.getImage(), (int) x, (int) y, null);
           			width = imgDown.getIconWidth();
           	    	height = imgDown.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
           		else if (this.histVarX == -1 && this.histVarY == 0) {
           			g.drawImage(imgLeft.getImage(), (int) x, (int) y, null);
           			width = imgLeft.getIconWidth();
           	    	height = imgLeft.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
           		else if (this.histVarX == 1 && this.histVarY == 0) {
           			g.drawImage(imgRight.getImage(), (int) x, (int) y, null);
           			width = imgRight.getIconWidth();
           	    	height = imgRight.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
           		else if (this.histVarX == -1 && this.histVarY == -1) {
           			g.drawImage(imgUpLeft.getImage(), (int) x, (int) y, null);
           			width = imgUpLeft.getIconWidth();
           	    	height = imgUpLeft.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
           		else if (this.histVarX == 1 && this.histVarY == -1) {
           			g.drawImage(imgUpRight.getImage(), (int) x, (int) y, null);
           			width = imgUpRight.getIconWidth();
           	    	height = imgUpRight.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
           		
				else if (this.histVarX == 1 && this.histVarY == 1) {
					g.drawImage(imgDownRight.getImage(), (int) x, (int) y, null);
           			width = imgDownRight.getIconWidth();
           	    	height = imgDownRight.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
				}
           		
				else if (this.histVarX == -1 && this.histVarY == 1) {
					g.drawImage(imgDownLeft.getImage(), (int) x, (int) y, null);
           			width = imgDownLeft.getIconWidth();
           	    	height = imgDownLeft.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
				}       		
           		
           		else {
           			g.drawImage(img.getImage(), (int) x, (int) y, null);
           			width = img.getIconWidth();
           	    	height = img.getIconHeight();
           	    	rect.width = width;
           	    	rect.height = height;
           		}
    		}
    		
    	}
    }
    
    public void movePlayer(boolean left, boolean right, boolean up, boolean down, boolean shipBoost, int w, int h) {
        if (up) {
           if (y >= 30) {
              varY = -1;
           }
           
           else {
               varY = 0;
           }
       }
       
       else {
           if (down) {
               if (y <= h - height - 5) {
                   varY = 1;
               }
               
               else {
                   varY = 0;
               }
           }
           else {
               varY = 0;
           }
       }
        
        
        if (left) {
            if (x >= 8) {
                varX = -1;
            }
            else {
                varX = 0;
            }
        }
        else {
            if (right) {
                if (x <= w - width - 8) {
                    varX = 1;
                }
                else {
                    varX = 0;
                } 
            }
            else {
                varX = 0;
            }
        }
        
        if (shipBoost) {
            this.velocity = 2;
        }
        
        else if(!shipBoost) {
            this.velocity = 1;
        }
        
        //Setando a frente da nave
        if (left && !right && !up && !down) {           // esquerda
            histVarX = -1;
            histVarY = 0;
        }
        
        else if (!left && right && !up && !down) {      // direita
            histVarX = 1;
            histVarY = 0;
        }
        
        else if (!left && !right && up && !down) {     //cima 
            histVarX = 0;
            histVarY = -1;
        }
        
        else if (!left && !right && !up && down) {      //baixo
            histVarX = 0;
            histVarY = 1;
        }
        
        else if (left && !right && up && !down) {       //esquerda/cima
            histVarX = -1;
            histVarY = -1;
        }
        
        else if (left && !right && !up && down) {       //esquerda/baixo
            histVarX = -1;
            histVarY = 1;
        }
        
        else if (!left && right && up && !down) {       //direita/cima
            histVarX = 1;
            histVarY = -1;
        }
        
        else if (!left && right && !up && down) {       //direita/baixo
            histVarX = 1;
            histVarY = 1;
        }
    }
    
    public Tiro fire () {
        Tiro fire = new Tiro();
        
        if (this.histVarX == -1 && this.histVarY == 0) {
        	fire.setX(this.x);
        	fire.setY(this.y + (height/2));
        }
        
        else if (this.histVarX == 1 && this.histVarY == 0) {
        	fire.setX(this.x + (width));
        	fire.setY(this.y + (height/2));
        }
        
        else if (this.histVarX == 0 && this.histVarY == 1) {
        	fire.setX(this.x + (width/2));
        	fire.setY(this.y + height);
        }
        
        else if (this.histVarX == 0 && this.histVarY == -1) {
        	fire.setX(this.x + (width/2));
        	fire.setY(this.y);
        }
        
        else if (this.histVarX == -1 && this.histVarY == -1) {
        	fire.setX(this.x);
        	fire.setY(this.y);
        }
        
        else if (this.histVarX == 1 && this.histVarY == -1) {
        	fire.setX(this.x + width);
        	fire.setY(this.y);
        }
        
        else if (this.histVarX == 1 && this.histVarY == 1) {
        	fire.setX(this.x + width);
        	fire.setY(this.y + height);
        }
        
        else if (this.histVarX == -1 && this.histVarY == 1) {
        	fire.setX(this.x);
        	fire.setY(this.y + height);
        }
        
        fire.setVarX(this.histVarX);
        fire.setVarY(this.histVarY);
        fire.setVelocity(3);
        fire.setColor(Color.WHITE);
        fire.setEdge(Color.WHITE);
        fire.alive = true;
        
        return fire;
    }

	public ImageIcon getImgLeft() {
		return imgLeft;
	}

	public void setImgLeft(ImageIcon imgLeft) {
		this.imgLeft = imgLeft;
	}

	public ImageIcon getImgRight() {
		return imgRight;
	}

	public void setImgRight(ImageIcon imgRight) {
		this.imgRight = imgRight;
	}

	public ImageIcon getImgDown() {
		return imgDown;
	}

	public void setImgDown(ImageIcon imgDown) {
		this.imgDown = imgDown;
	}

	public ImageIcon getImgUpLeft() {
		return imgUpLeft;
	}

	public void setImgUpLeft(ImageIcon imgUpLeft) {
		this.imgUpLeft = imgUpLeft;
	}

	public ImageIcon getImgUpRight() {
		return imgUpRight;
	}

	public void setImgUpRight(ImageIcon imgUpRight) {
		this.imgUpRight = imgUpRight;
	}

	public ImageIcon getImgDownRight() {
		return imgDownRight;
	}

	public void setImgDownRight(ImageIcon imgDownRight) {
		this.imgDownRight = imgDownRight;
	}

	public ImageIcon getImgDownLeft() {
		return imgDownLeft;
	}

	public void setImgDownLeft(ImageIcon imgDownLeft) {
		this.imgDownLeft = imgDownLeft;
	}
}
   

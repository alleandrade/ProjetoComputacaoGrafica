/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocomputacaografica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sawa chan
 */
public class Projeto extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Projeto
     */
    public Projeto() {
        initComponents();
        createBufferStrategy(2);
    	setBounds(180, 20, 1200, 800);
        Thread t = new Thread(this);
        t.start();
    }
    
    private boolean left,
                    right,
                    up,
                    down,
                    fire,
                    startGame,
                    shipBoost,
                    restartGame,
                    gameOver;
    
    private long lastFire;
    private int score = 0;
    private int lives;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always    * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_S) {
        	startGame = true;
        }
    	
        if (evt.getKeyCode() == KeyEvent.VK_R) {
        	restartGame = true;
        }
        
    	if (evt.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
            fire = true;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            shipBoost = true;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        
        else {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                down = true;
            }
        }
        
        
        if (evt.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
        }
        else {
            if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
                right = true;
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            fire = false;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            shipBoost = false;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
            
        }
        else {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN){
                down = false;
            }
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        }
        else { 
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = false;
            }
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Projeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Projeto().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        Graphics g;
        Graphics2D g2;
        lives = 3;
        score = 0;
        restartGame = false;
        startGame = false;
        gameOver = false;
        
        Random generator = new Random();
        ArrayList<Base> list = new ArrayList<Base>();
        ArrayList<Base> arrayLives = new ArrayList<Base>();
        
        Title t = new Title("img/title1.jpg");
        Title t2 = new Title("img/title3.gif");
        t.setX(0);
        t.setY(30);
        t2.setX(380);
        t2.setY(450);

        for (int i = 1; i <= 3; i++) {
            Title t1 = new Title("img/live.jpg");
            t1.setX((15 * i) + 2);
            t1.setY(85);

            arrayLives.add(t1);
        }
        
        //Setando aeronave
        Aircraft aircraft = new Aircraft("img/shipUp.jpg","img/shipDown2.jpg","img/shipLeft2.jpg","img/shipRight2.jpg",
        								 "img/shipUpLeft.gif","img/shipUpRight.gif","img/shipDownRight.gif","img/shipDownLeft.gif");     
        aircraft.setColor(Color.BLACK);
        aircraft.setX(getWidth()/2);
        aircraft.setY(getHeight()/2);
        list.add(aircraft);
        // ~
        
        //Tela de inicio
        while(true) {
        	g = getBufferStrategy().getDrawGraphics();
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 330, getWidth(), 450);
        	g2 = (Graphics2D) g;
        	t.draw(g2);
        	
        	t2.draw(g2);
        	
        	if (startGame) {
        		break;
        	}
        	
        	g.dispose();
        	getBufferStrategy().show();
        	
        	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        //~
        
        int x = 0;
        while(true) {
            g = getBufferStrategy().getDrawGraphics();
            g2 = (Graphics2D) g;
            ArrayList<Base> lixo = new ArrayList<Base>();
            ArrayList<Base> newElements = new ArrayList<Base>();
            //Apagando a tela
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            
            if (x % 50 == 0) {  //Spawn de inimigos
                list.add(spawn(generator.nextInt(4),getWidth(),getHeight()));
            }
            
            for (Base b : list) {
                b.draw(g2);
            }
            
            for (Base b : list) {
                b.movements();
            }
            
            for (Base b: list) {
                newElements.addAll(b.colision(getWidth(), getHeight(), list));                
            }
            
            aircraft.movePlayer(left, right, up, down, shipBoost, getWidth(), getHeight());
            
            long currentTime = System.currentTimeMillis();
            
            if (fire && currentTime > lastFire + 250) {
                lastFire = currentTime;
                list.add(aircraft.fire());
            }
            
            list.addAll(newElements);
            
            for (Base b : list) {
                if (!b.alive) { 
                    lixo.add(b);
                }
            }
            
            list.removeAll(lixo);
            lixo.clear();

            score += 50 * (newElements.size() / 2);
            
            if (!gameOver) {
            	score++;
            }
            
            if (!aircraft.alive) {
                if (lives > 0) {
                    aircraft.alive = true;
                    aircraft.setX(getWidth()/2);
                    aircraft.setY(getHeight()/2);
                    list = new ArrayList<Base>();
                    list.add(aircraft);
                    arrayLives.remove(arrayLives.size() - 1);
                    lives--;
                }
                else {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Arial", Font.BOLD, 30));
                    g.drawString("YOUR SCORE: " + score + " - PRESS R TO RESTART", 300, getHeight()/2);
                    gameOver = true;
                }
            }
            
            if (restartGame) {
                run();
            }
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("SCORE: " + score, 15, 80);
            
            for (Base b : arrayLives)
                b.draw(g2);
            
            g.dispose();
            getBufferStrategy().show();
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
            x++;
        }
    }

    public Enemy spawn (int op, int width, int height) {
        Enemy e = new Enemy ("img/asteroidmaior.png");
        Random generator = new Random();
 
        switch (op) {
            case 0:
                e.setX(generator.nextInt(getWidth()));
                e.setY(e.height);
                e.setVarX(1);
                e.setVarY(1);
                e.setTipo(1);
                break;
            case 1:
                e.setY(generator.nextInt(getHeight()));
                e.setX(0);
                e.setVarX(1);
                e.setVarY(1);
                e.setTipo(1);
                break;
            case 2:
                e.setX(generator.nextInt(width));
                e.setY(height);
                e.setVarY(-1);
                e.setVarX(1);
                e.setTipo(1);
                break;
            default:
                e.setX(width);
                e.setY(generator.nextInt(height));
                e.setVarY(-1);
                e.setVarX(-1);
                e.setTipo(1);
                break;
        }
        
        return e;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
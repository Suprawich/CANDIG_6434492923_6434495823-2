/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.OBJ_jar;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    //Initialize frame size
    final int originalTitleSize = 16; // 16x16 tile
    final int scale = 3;
    
    public final int titleSize = originalTitleSize * scale; // 48x48 tile
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 12;
    public final int screenHeight = titleSize * maxScreenRow; // 768 pixels
    public final int screenWidth = titleSize * maxScreenCol; // 576 pixels
    
    //world setting
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 70;
    public final int worldWidth = titleSize * maxWorldCol;
    public final int worldHeight = titleSize * maxWorldRow;
    
    //FPS
    int FPS = 60;
    
    // I'M ON THE NEXT LEVEL
    public int gameLevel = 1; // level 1

    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public UI ui = new UI(this);
    
    Thread gameThread;
    Sound music = new Sound();                          // background sound
    Sound se = new Sound();                             // sound effect

    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this, keyH);
    public AssetSetter aSetter = new AssetSetter(this);
    public SuperObject obj[] = new SuperObject[100]; //Index mean x objects can appeared at the same time
    
    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 100;
    public final int pauseState = 101;
    public final int congratState = 102;
    public final int endState = 103;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame() {
        aSetter.setObject();
        gameState = titleState;
        playMusic(1);
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while (gameThread != null) {
            
            // 1 UPDATE: update information such as character position
            update();
            // 2 DRAW: draw the screen with the update information
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update() {
        
        if (gameState == playState) {
            player.update();
        }
        if (gameState == pauseState) {
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        //titlr screen
        if (gameState == titleState) {
            ui.draw(g2);
        }
        else if (gameState == endState) {
            ui.draw(g2);
        }
        else {
            if (gameLevel == 1) {
                ui.drawLv1(g2);
            }
            if (gameLevel == 2) {
                ui.drawLv2(g2);
            }
            if (gameLevel == 3) {
                ui.drawLv3(g2);
            }
        }
    }
    
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    
    public void stopMusic() {
        music.stop();
    }
    
    public void playSE(int i) {                         // play sound effect
        se.setFile(i);
        se.play();
    }
    
    public void changeStage() {
        gameState = congratState;
    }
}

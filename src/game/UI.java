/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import object.OBJ_Energy;
import object.OBJ_bag;
import object.OBJ_cherry;
import object.OBJ_jar;
import object.OBJ_rainbow;
import object.OBJ_waffle;
import object.SuperObject;

public class UI {
    
    Graphics2D g2;
    GamePanel gp;
    Font omegle;
    BufferedImage candyImage, cherryImage1, cherryImage2;
    BufferedImage enfull1, enfull2, enfull3, enhalf1, enhalf2, enhalf3, ennull1,ennull2,ennull3,
            jar0, jar1, jar2, jar3, jar4, jar5, jar6, jar7, jar8, jar9, jar10, jar11, jar12, jar13
            ,jar14, jar15, jar16, jar17, jar18, bagImage, waffleImage1, waffleImage2,
            rainbowImage1, rainbowImage2;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;
    public int titleScreenState = 0; //0 the first screen
    
    public UI(GamePanel gp) {
        this.gp = gp;
        
        try {
            InputStream is = getClass().getResourceAsStream("/res/font/omegle/OmegleRegular-gxDaq.otf");
            omegle = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        OBJ_jar jar = new OBJ_jar();
        
        OBJ_cherry cherry = new OBJ_cherry();
        cherryImage1 = cherry.image2; //black&white
        cherryImage2 = cherry.image; //color
        jar0 = jar.image;
        jar1 = jar.image2;
        jar2 = jar.image3;
        jar3 = jar.image4;
        jar4 = jar.image5;
        jar5 = jar.image6;
        jar6 = jar.image7;

        OBJ_waffle waffle = new OBJ_waffle();
        waffleImage1 = waffle.image;
        waffleImage2 = waffle.image2;
        jar7 = jar.image8;
        jar8 = jar.image9;
        jar9 = jar.image10;
        jar10 = jar.image11;
        jar11 = jar.image12;
        jar12 = jar.image13;

        OBJ_rainbow rainbow = new OBJ_rainbow();

        rainbowImage1 = rainbow.image;
        rainbowImage2 = rainbow.image2;
        jar13 = jar.image14;
        jar14 = jar.image15;
        jar15 = jar.image16;
        jar16 = jar.image17;
        jar17 = jar.image18;
        jar18 = jar.image19;

        
        // CREATE ENERGY OBJ
        SuperObject energy = new OBJ_Energy(gp);
        enfull1 = energy.image;
        enfull2 = energy.image2;
        enfull3 = energy.image3;
        enhalf1 = energy.image4;
        enhalf2 = energy.image5;
        enhalf3 = energy.image6;
        ennull1 = energy.image7;
        ennull2 = energy.image8;
        ennull3 = energy.image9;
        
        // CREATE BAG OBJ
        OBJ_bag bag = new OBJ_bag();
        bagImage = bag.image;
    }
    public void showMessage(String text) {
        
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) { 
            
        this.g2 = g2;
        
        g2.setFont(omegle);
        g2.setColor(Color.black);
        g2.setFont(g2.getFont().deriveFont(30F));
        
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        if (gp.gameState == gp.playState) {
            g2.setFont(omegle);
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawImage(bagImage, gp.titleSize/2, gp.titleSize*27/20, gp.titleSize*5/6, gp.titleSize*5/6, null);
            g2.drawString(gp.player.bag + "/"+gp.player.maxBag, 70, 92);
            g2.drawString(OBJ_jar.candyInJar + "/" + OBJ_jar.maxJar, 70, 140);
            
            switch(gp.gameLevel) {
                case 1 -> {
                    if(gp.player.cherry == 0) {
                        g2.drawImage(cherryImage1, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*4/3, gp.titleSize*4/3, null);
                    }
                    else if(gp.player.cherry == 1) {
                        g2.drawImage(cherryImage2, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                }
                case 2 -> {
                    if(gp.player.waffle == 0) {
                        g2.drawImage(waffleImage2, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*4/3, gp.titleSize*4/3, null);
                    }
                    else if(gp.player.waffle == 1) {
                        g2.drawImage(waffleImage1, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                }
                case 3 -> {
                    if(gp.player.rainbow == 0) {
                        g2.drawImage(rainbowImage2, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*4/3, gp.titleSize*4/3, null);
                    }
                    else if(gp.player.waffle == 1) {
                        g2.drawImage(rainbowImage1, gp.screenWidth-gp.titleSize*5/3, gp.titleSize-35, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                }
            }

            drawPlayerEnergy(g2);
            drawJar(g2);
            
            // MESSAGE
            if(messageOn == true) {
            
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.titleSize/2, gp.titleSize*5);

                messageCounter++;
                if(messageCounter > 120) {          // show message 120 frames (2 seconds) then disappear
                    messageCounter = 0;
                    messageOn = false;
                }
            } 
        }
        if (gp.gameState == gp.congratState) {
            drawLevelUp();
        }
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        if (gp.gameState == gp.endState) {
            drawEnd();
        }
    }
    
    public void drawTitleScreen() {
        if (titleScreenState == 0) {
            //title name
            BufferedImage bg = null;
            try {
                bg = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD,40F));
            String text = "CAN DIG?";
            int x = getXforCenteredText(text);
            int y = gp.titleSize*6;
         
            //shadow
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);
            //main
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,24F));
            text = "START";
            x = getXforCenteredText(text);
            y += gp.titleSize*3/2;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gp.titleSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.titleSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gp.titleSize, y);
            }
        }
        else if (titleScreenState == 1) {
            BufferedImage cherry = null;
            BufferedImage waffle = null;
            BufferedImage rainbow = null;
            BufferedImage bg = null;
            try {
                cherry = ImageIO.read(getClass().getResourceAsStream("/res/objects/cherry.png"));
                waffle = ImageIO.read(getClass().getResourceAsStream("/res/objects/waffle.png"));
                rainbow = ImageIO.read(getClass().getResourceAsStream("/res/objects/rainbow.png"));
                bg = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg1.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,24F));
            String text = "Mission";
            int x = getXforCenteredText(text);
            int y = gp.titleSize*2;
            g2.drawString(text, x, y);
            
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
            text = "Your job is";
            x = getXforCenteredText(text);
            y += gp.titleSize*3/2;
            g2.drawString(text, x, y);
            
            text = "to top ice-cream with 3 topping.";
            x = getXforCenteredText(text);
            y += gp.titleSize/2;
            g2.drawString(text, x, y);
            
            text = "cherry";
            x = gp.titleSize;
            y += gp.titleSize;
            g2.drawString(text, x, y);
            g2.drawImage(cherry, x, y+20, cherry.getWidth()*2, cherry.getHeight()*2, null);
            
            text = "waffle stick";
            x = getXforCenteredText(text);
            g2.drawString(text, x, y);
            g2.drawImage(waffle, x+20, y+20, cherry.getWidth()*2, cherry.getHeight()*2, null);

            
            text = "rainbow";
            x = gp.screenWidth-(5*gp.titleSize/2);
            g2.drawString(text, x, y);
            g2.drawImage(rainbow, x, y+20, cherry.getWidth()*2, cherry.getHeight()*2, null);

            text = "Go and find it.";
            x = getXforCenteredText(text);
            y += gp.titleSize*3;
            g2.drawString(text, x, y);
            
            text = "NEXT";
            x = getXforCenteredText(text)/2;
            y += gp.titleSize*2;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
            
            text = "BACK";
            x += getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
        }
        else if (titleScreenState == 2) {
            BufferedImage bg = null;
            BufferedImage jar = null;
            BufferedImage jar5 = null;
            BufferedImage jar7 = null;
            BufferedImage itimLv1 = null;
            BufferedImage itimLv2 = null;
            BufferedImage itimLv3 = null;
            BufferedImage itimLv4 = null;
            try {
                bg = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg1.png"));
                jar = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar0.png"));
                jar5 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar5.png"));
                jar7 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar7.png"));
                itimLv1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down.png"));
                itimLv2 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2down.png"));
                itimLv3 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3down.png"));
                itimLv4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4down.png"));
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,24F));
            String text = "Collect candy to power up";
            int x = getXforCenteredText(text);
            int y = gp.titleSize*2;
            g2.drawString(text, x, y);
            
            y += gp.titleSize;
            
            g2.drawImage(jar, gp.titleSize*2, y, jar.getWidth(), jar.getHeight(), null);
            g2.drawImage(jar5, gp.titleSize*9/2, y, jar5.getWidth(), jar5.getHeight(), null);
            g2.drawImage(jar7, gp.titleSize*7, y, jar7.getWidth(), jar7.getHeight(), null);
            
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,24F));
            text = "Upgrade you ice-cream";
            x = getXforCenteredText(text);
            y += gp.titleSize*2;
            g2.drawString(text, x, y);
            y += gp.titleSize;
            x = getXforCenteredText(text)/2;
            g2.drawImage(itimLv1, x, y, itimLv1.getWidth(), itimLv1.getHeight(), null);
            x += gp.titleSize*2;
            g2.drawImage(itimLv2, x, y, itimLv2.getWidth(), itimLv2.getHeight(), null);
            x += gp.titleSize*2;
            g2.drawImage(itimLv3, x, y, itimLv3.getWidth(), itimLv3.getHeight(), null);
            x += gp.titleSize*2;
            g2.drawImage(itimLv4, x, y, itimLv4.getWidth(), itimLv4.getHeight(), null);
            
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
            text = "START";
            x = getXforCenteredText(text)/2;
            y += gp.titleSize*4;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
            
            text = "BACK";
            x += getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
        }
    }
    
    public void drawPauseScreen() {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    public void drawPlayerEnergy(Graphics2D g2) {
        
        int x = 17;
        int y = gp.titleSize/2;
        int next = gp.titleSize*3/4;
        // DRAW MAX ENERGY
        g2.drawImage(ennull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
        g2.drawImage(ennull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
        g2.drawImage(ennull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
        g2.drawImage(ennull2, x+3*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
        g2.drawImage(ennull3, x+4*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
        
        
        // DRAW CURRENT ENERGY
        switch (gp.player.energy) {
            case 1 -> g2.drawImage(enhalf1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            case 2 -> g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            case 3 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enhalf2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 4 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 5 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enhalf2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 6 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 7 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enhalf2, x+3*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 8 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+3*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 9 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+3*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enhalf3, x+4*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
            case 10 -> {
                g2.drawImage(enfull1, x, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+2*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull2, x+3*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
                g2.drawImage(enfull3, x+4*next, y, gp.titleSize*3/4, gp.titleSize*3/4, null);
            }
        }
        if(gp.player.energy == 0) {
            gp.ui.showMessage("Out of energy!");
        }
    }
    public void drawJar(Graphics2D g2) {
        int x = gp.titleSize/2;
        int y = gp.titleSize*9/4;
        
        switch (gp.gameLevel) {
            case 1 -> {
                switch(OBJ_jar.candyInJar) {
                    case 0 -> {
                        g2.drawImage(jar0, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 1 -> {
                        g2.drawImage(jar1, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 2 -> {
                        g2.drawImage(jar2, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 3,4 -> {
                        g2.drawImage(jar3, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 5,6 -> {
                        g2.drawImage(jar4, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 7,8,9 -> {
                        g2.drawImage(jar5, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 10 -> {
                        g2.drawImage(jar6, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                }
            }
            case 2 -> {
                switch(OBJ_jar.candyInJar) {
                    case 0 -> {
                        g2.drawImage(jar0, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 1,2 -> {
                        g2.drawImage(jar7, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 3,4,5 -> {
                        g2.drawImage(jar8, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 6,7,8 -> {
                        g2.drawImage(jar9, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 9,10,11 -> {
                        g2.drawImage(jar10, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 12,13,14 -> {
                        g2.drawImage(jar11, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 15 -> {
                        g2.drawImage(jar12, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                }
            }
            case 3 -> {
                switch(OBJ_jar.candyInJar) {
                    case 0 -> {
                        g2.drawImage(jar0, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 1,2,3,4 -> {
                        g2.drawImage(jar13, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 5,6,7,8 -> {
                        g2.drawImage(jar14, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 9,10,11,12 -> {
                        g2.drawImage(jar15, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 13,14,15,16 -> {
                        g2.drawImage(jar16, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 17,18,19 -> {
                        g2.drawImage(jar17, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                    case 20 -> {
                        g2.drawImage(jar18, x, y, gp.titleSize*5/6, gp.titleSize*5/6, null);
                    }
                }
            }
        }
    }
    
    public void drawLv1(Graphics2D g2) {
        gp.tileM.getTileImage();
        gp.tileM.draw(g2);
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                gp.obj[i].draw(g2, gp);
            }
        }
        gp.player.draw(g2);

        // UI
        gp.ui.draw(g2);
        g2.dispose();
    }
    
    public void drawLv2(Graphics2D g2) {
        gp.tileM.getTileImageLv2();
        gp.tileM.draw(g2);
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                gp.obj[i].draw(g2, gp);
            }
        }
        gp.player.draw(g2);

        // UI
        gp.ui.draw(g2);
        g2.dispose();
    }
    
    public void drawLv3(Graphics2D g2) {
        gp.tileM.getTileImageLv3();
        gp.tileM.draw(g2);
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                gp.obj[i].draw(g2, gp);
            }
        }
        gp.player.draw(g2);

        // UI
        gp.ui.draw(g2);
        g2.dispose();
    }
    
    public void drawLevelUp() {
        g2.setColor(Color.WHITE);

        String text = null;
        int textLength;
        int x, y;
        
        switch (gp.gameLevel) {
            case 1 -> {text = "You found the cherry!";}
            case 2 -> {text = "You found the waffle stick!";}
            case 3 -> {text = "You found the rainbow!";}
        } 
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y = gp.screenHeight/2 - (gp.titleSize*3);
        g2.drawString(text, x, y);

        g2.setColor(Color.YELLOW);
        text = "Congratulations!";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y = gp.screenHeight/2 + (gp.titleSize*2);
        g2.drawString(text, x, y);
        
        g2.setColor(Color.white);
        text = "> Press space to play next stage <";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y += gp.titleSize;
        g2.drawString(text, x, y);
    }
    
    public void drawEnd() {
        BufferedImage bg = null;
        BufferedImage itimLv4 = null;
            try {
                bg = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bg1.png"));
                itimLv4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4down.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        g2.setColor(Color.white);
        g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
        String text = "Your ice-cream is finish";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/5;
        g2.drawString(text, x, y);
        y += gp.titleSize;
        g2.drawImage(itimLv4, gp.screenWidth/2 - (gp.titleSize*3), y, itimLv4.getWidth()*3, itimLv4.getHeight()*3, null);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,20F));
            text = "NEW GAME";
            x = getXforCenteredText(text)/2;
            y += gp.titleSize*7;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
            
            text = "QUIT";
            x += getXforCenteredText(text);
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x-gp.titleSize+24, y);
            }
    }
}
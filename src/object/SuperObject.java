/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import entity.Player;
import game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SuperObject {
    
    public BufferedImage image, image2, image3, image4, image5, image6, image7, image8, image9,
            image10, image11, image12, image13, image14, image15, image16, image17, image18, image19;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    
    
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenY;
        int screenY = worldY - gp.player.worldY + gp.player.screenX;

        if (worldX + gp.titleSize*3 > gp.player.worldX - gp.player.screenX && 
            worldX - gp.titleSize*3 < gp.player.worldX + gp.player.screenX &&
            worldY + gp.titleSize*3 > gp.player.worldY - gp.player.screenY && 
            worldY - gp.titleSize*3 < gp.player.worldY + gp.player.screenY) {
            switch (name) {
            case "base" :
                switch(gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, image.getWidth()*3, image.getHeight()*3, null);
                        
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, image.getWidth()*3, image.getHeight()*3, null);
                        
                    }
                }
                solidArea = new Rectangle(48, -48, (image.getWidth()*3), (image.getHeight()*3));
                break;
            case "candy" :
                switch(gp.gameLevel) {
                    case 1 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                    case 2 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                    case 3 -> {
                        g2.drawImage(image3, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                    }
                }
                solidArea = new Rectangle(48, -24, gp.titleSize*3/2, gp.titleSize*1/4);
                break;
            case "Popky1" :
                switch (gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize*6, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize, gp.titleSize*6, null);
                    }
                }
                break;
            case "Popky2" :
                switch (gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize*6, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize, gp.titleSize*6, null);
                    }
                }
                break;
            case "IceCreamTree1" :
                switch (gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3, gp.titleSize*5, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3, gp.titleSize*5, null);
                    }
                }
                break;
            case "cherry" :
                g2.drawImage(image, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                solidArea = new Rectangle(48, -24, gp.titleSize*3/2, gp.titleSize*1/4);
                break;
            case "jar" :
                g2.drawImage(image, screenX, screenY, image.getWidth(), image.getHeight(), null);
                solidArea = new Rectangle(48, -48, image.getWidth(), image.getHeight());
                break;
            case "pinkcloud" :
                switch(gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                }
                break;
            case "bluecloud" :
                switch(gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                }
                break;
            case "caramelcloud" :
                switch(gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                }
                break;
            case "coffeecloud" :
                switch(gp.gameLevel) {
                    case 1,2 -> {
                        g2.drawImage(image, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                    case 3 -> {
                        g2.drawImage(image2, screenX, screenY, gp.titleSize*3, gp.titleSize*2, null);
                    }
                }
                break;
            case "waffle" :
                g2.drawImage(image, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                solidArea = new Rectangle(48, -24, gp.titleSize*3/2, gp.titleSize*1/4);
                break;
            case "rainbow" :
                g2.drawImage(image, screenX, screenY, gp.titleSize*3/2, gp.titleSize*3/2, null);
                solidArea = new Rectangle(48, -24, gp.titleSize*3/2, gp.titleSize*1/4);
                break;
            }
        }
    }
}

/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package entity;

import game.GamePanel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    GamePanel gp;
    
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up, down, left, right, up_1, down_1, left_1, right_1,
            up2, down2, left2, right2, up2_1, down2_1, left2_1, right2_1,
            up3, down3, left3, right3, up3_1, down3_1, left3_1, right3_1,
            up4, down4, left4, right4, up4_1, down4_1, left4_1, right4_1;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    // CHARACTER STATUS
    public int maxEnergy;
    public int energy;
    public int maxBag;
    public int bag;
   
}

/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {
    
    //public static int LEVEL = 1;
    
    GamePanel gp;
    KeyHandler keyH;
    
    public int screenX = 0;
    public int screenY = 0;
    
    public int candy = 0;
    public int cherry = 0;
    public int waffle = 0;
    public int rainbow = 0;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - gp.titleSize/2;
        screenY = gp.screenHeight/2 - gp.titleSize/2;
        
        solidArea = new Rectangle(0, 0, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues() {
        worldX = gp.titleSize*20;
        worldY = gp.titleSize*11;
        speed = 6;
        direction = "down";
        
        // PLAYER STATUS
        maxEnergy = 10;
        energy = maxEnergy;
        
        // BAG
        maxBag = 5;
        bag = 0;
    }
    
    public void getPlayerImage() {
        
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/res/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/res/player/down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/res/player/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/res/player/right.png"));
            up_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up1.png"));
            down_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));            
            left_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            right_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2up.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2down.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2left.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2right.png"));
            up2_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2up1.png"));
            down2_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2down1.png"));
            left2_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2left1.png"));
            right2_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv2right1.png"));
            
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3up.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3down.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3left.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3right.png"));
            up3_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3up1.png"));
            down3_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3down1.png"));
            left3_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3left1.png"));
            right3_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv3right1.png"));
            
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4up.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4down.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4left.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4right.png"));
            up4_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4up1.png"));
            down4_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4down1.png"));
            left4_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4left1.png"));
            right4_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/icelv4right1.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            }
            else if (keyH.downPressed == true) {
                direction = "down";
            }
            else if (keyH.leftPressed == true) {
                direction = "left";
            }
            else if (keyH.rightPressed == true) {
                direction = "right";
            }
            
            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //replace block
            gp.cChecker.checkPassWay(this);
                    
            //check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            
            //if collision is fault player can move
            if (collisionOn == false) {
                switch(direction) {
                    case "up"   :    worldY -= speed;   break;
                    case "down" :    worldY += speed;   break;
                    case "left" :    worldX -= speed;   break;
                    case "right":    worldX += speed;   break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 10) {
                
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            spriteNum = 1;
        }

    }
    
    public void pickUpObject(int i) {
        if (i != 999) {
            if (gp.gameState == gp.playState) {
                String objectName = gp.obj[i].name;

                switch (objectName) {
                    case "candy" :
                        if (bag < maxBag) {
                            gp.playSE(0);
                            candy += 1;
                            gp.obj[i] = null;
                            bag++;
                            gp.ui.showMessage("You got a candy!");
                        }
                        else
                            gp.ui.showMessage("Your bag is full!");
                        break;
                    case "cherry" :
                        gp.playSE(0);
                        cherry = 1;
                        gp.obj[i] = null;
                        gp.ui.showMessage("You got a cherry!");
                        break;
                    case "waffle" :
                        gp.playSE(0);
                        waffle = 1;
                        gp.obj[i] = null;
                        break;
                    case "rainbow" :
                        gp.playSE(0);
                        rainbow = 1;
                        gp.obj[i] = null;
                        gp.ui.showMessage("You got rainbow!");
                        break;
                    case "base" :
                        break;
                }
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch(direction) {
            case "up" :
                if (cherry == 0) {
                    if (spriteNum == 1) {
                        image = up; 
                    }
                    if (spriteNum == 2) {
                        image = up_1;
                    }
                }
                if (cherry == 1) {
                    if (spriteNum == 1) {
                        image = up2; 
                    }
                    if (spriteNum == 2) {
                        image = up2_1;
                    }
                }
                if (waffle == 1) {
                    if (spriteNum == 1) {
                        image = up3; 
                    }
                    if (spriteNum == 2) {
                        image = up3_1;
                    }
                }
                if (rainbow == 1) {
                    if (spriteNum == 1) {
                        image = up4; 
                    }
                    if (spriteNum == 2) {
                        image = up4_1;
                    }
                }
                break;
            case "down" :
                if (cherry == 0) {
                    if (spriteNum == 1) {
                        image = down; 
                    }
                    if (spriteNum == 2) {
                        image = down_1;
                    }
                }
                if (cherry == 1) {
                    if (spriteNum == 1) {
                        image = down2; 
                    }
                    if (spriteNum == 2) {
                        image = down2_1;
                    }
                }
                if (waffle == 1) {
                    if (spriteNum == 1) {
                        image = down3; 
                    }
                    if (spriteNum == 2) {
                        image = down3_1;
                    }
                }
                if (rainbow == 1) {
                    if (spriteNum == 1) {
                        image = down4; 
                    }
                    if (spriteNum == 2) {
                        image = down4_1;
                    }
                }
                break;
            case "left" : 
                if (cherry == 0) {
                    if (spriteNum == 1) {
                        image = left; 
                    }
                    if (spriteNum == 2) {
                        image = left_1;
                    }
                }
                if (cherry == 1) {
                    if (spriteNum == 1) {
                        image = left2; 
                    }
                    if (spriteNum == 2) {
                        image = left2_1;
                    }
                }
                if (waffle == 1) {
                    if (spriteNum == 1) {
                        image = left3; 
                    }
                    if (spriteNum == 2) {
                        image = left3_1;
                    }
                }
                if (rainbow == 1) {
                    if (spriteNum == 1) {
                        image = left4; 
                    }
                    if (spriteNum == 2) {
                        image = left4_1;
                    }
                }
                break;
            case "right" :  
                if (cherry == 0) {
                    if (spriteNum == 1) {
                        image = right; 
                    }
                    if (spriteNum == 2) {
                        image = right_1;
                    }
                }
                if (cherry == 1) {
                    if (spriteNum == 1) {
                        image = right2; 
                    }
                    if (spriteNum == 2) {
                        image = right2_1;
                    }
                }
                if (waffle == 1) {
                    if (spriteNum == 1) {
                        image = right3; 
                    }
                    if (spriteNum == 2) {
                        image = right3_1;
                    }
                }
                if (rainbow == 1) {
                    if (spriteNum == 1) {
                        image = right4; 
                    }
                    if (spriteNum == 2) {
                        image = right4_1;
                    }
                }
                break;
        }

        g2.drawImage(image, screenX-24, screenY-24, image.getWidth(), image.getHeight(), null);
    }
}
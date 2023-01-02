/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import object.OBJ_jar;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    GamePanel gp;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        //title state
        if (gp.gameState == gp.titleState) {
            if (gp.ui.titleScreenState == 0) {
                if(code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 1;
                    }
                }
                if(code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 1) {
                        gp.ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER) { 
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;
                    }
                    if (gp.ui.commandNum == 1) {
                        System.exit(0);
                    }
                }
            }
            else if (gp.ui.titleScreenState == 1) {
                if(code == KeyEvent.VK_RIGHT) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 1) {
                        gp.ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_LEFT) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 1;
                    }
                }
                if(code == KeyEvent.VK_ENTER) { 
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 2;
                    }
                    if (gp.ui.commandNum == 1) {
                        gp.ui.titleScreenState = 0;
                    }
                }
            }
            else if (gp.ui.titleScreenState == 2) {
                if(code == KeyEvent.VK_RIGHT) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 1) {
                        gp.ui.commandNum = 0;
                    }
                }
                if(code == KeyEvent.VK_LEFT) {
                    gp.ui.commandNum--;
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 1;
                    }
                }
                if(code == KeyEvent.VK_ENTER) { 
                    if (gp.ui.commandNum == 0) {
                        gp.gameState = gp.playState;
                    }
                    if (gp.ui.commandNum == 1) {
                        gp.ui.titleScreenState = 1;
                    }
                }
            }
        }
        
        if (gp.gameState == gp.congratState) {
            if(code == KeyEvent.VK_SPACE) {
                gp.gameState = gp.playState;
                gp.gameLevel += 1;
                if (gp.gameLevel == 2) {
                    gp.aSetter.setObject2();
                    OBJ_jar.candyInJar = 0;
                    OBJ_jar.maxJar += 5;
                    gp.player.maxBag += 2;
                    gp.player.worldX = gp.titleSize*20;
                    gp.player.worldY = gp.titleSize*11;
                    gp.player.direction = "down";
                    gp.player.energy = gp.player.maxEnergy;
                    gp.tileM.loadMap("/map/world2.txt");
                }
                if (gp.gameLevel == 3) {
                    gp.aSetter.setObject3();
                    OBJ_jar.candyInJar = 0;
                    OBJ_jar.maxJar += 5;
                    gp.player.maxBag += 2;
                    gp.player.worldX = gp.titleSize*20;
                    gp.player.worldY = gp.titleSize*11;
                    gp.player.direction = "down";
                    gp.player.energy = gp.player.maxEnergy;
                    gp.tileM.loadMap("/map/world2.txt");
                }
                if (gp.gameLevel == 4) {
                    gp.gameState = gp.endState;
                }
            }
        }
        if (gp.gameState == gp.endState) {
            if(code == KeyEvent.VK_RIGHT) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 1) {
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_LEFT) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
            }
            if(code == KeyEvent.VK_ENTER) { 
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.gameLevel = 1;
                    gp.aSetter.setObject();
                    OBJ_jar.candyInJar = 0;
                    OBJ_jar.maxJar = 10;
                    gp.player.maxBag = 5;
                    gp.player.candy = 0;
                    gp.player.cherry = 0;
                    gp.player.waffle = 0;
                    gp.player.rainbow = 0;
                    CollisionChecker.eff = 5;
                    gp.player.worldX = gp.titleSize*20;
                    gp.player.worldY = gp.titleSize*11;
                    gp.player.direction = "down";
                    gp.player.energy = gp.player.maxEnergy;
                    gp.tileM.loadMap("/map/world2.txt");
                }
                if (gp.ui.commandNum == 1) {
                    System.exit(0);
                }
            }
        }
        
        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P) {
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.pauseState;
            }
            else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
        }
        if(code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
    
}

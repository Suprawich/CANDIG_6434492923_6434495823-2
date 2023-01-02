/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import entity.Entity;
import object.OBJ_jar;

public class CollisionChecker {
    
    GamePanel gp;
    public static int passcnt = 0;
    public static int eff = 5;
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x - 48;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width - 48;
        int entityTopWorldY = entity.worldY + entity.solidArea.y + 48;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height + 48;
        
        int entityLeftCol = entityLeftWorldX/gp.titleSize;
        int entityRightCol = entityRightWorldX/gp.titleSize;
        int entityTopRow = entityTopWorldY/gp.titleSize;
        int entityBottomRow = entityBottomWorldY/gp.titleSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction) {
            case "up" :
                entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "down" :
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left" :
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right" :
                entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    
    public int checkObject(Entity entity, boolean player) {
        
        int index = 999;
        
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                //get entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                //get the object solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
                
                switch(entity.direction) {
                    case "up"   :
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                System.out.println("up collision");
                                entity.collisionOn = true;
                                if (gp.obj[i].name.equals("base") && gp.player.energy < 10) {
                                    gp.player.energy++;
                                }
                                if (gp.obj[i].name.equals("jar") && gp.player.candy > 0 && gp.player.bag > 0){
                                    gp.player.candy--;
                                    OBJ_jar.candyInJar++;
                                    gp.player.bag--;
                                    if(OBJ_jar.candyInJar == OBJ_jar.maxJar) {
                                        CollisionChecker.eff += 5;
                                        gp.ui.showMessage("Increase energy efficiency!");
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.cherry == 1 && gp.gameLevel == 1) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.waffle == 1 && gp.gameLevel == 2) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.rainbow == 1 && gp.gameLevel == 3) {
                                        gp.changeStage();
                                    }
                                }
                            } 
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down" :
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                System.out.println("down collision");
                                entity.collisionOn = true;
                                if (gp.obj[i].name.equals("base") && gp.player.energy < 10) {
                                    gp.player.energy++;
                                }
                                if (gp.obj[i].name.equals("jar") && gp.player.candy > 0 && gp.player.bag > 0){
                                    gp.player.candy--;
                                    OBJ_jar.candyInJar++;
                                    gp.player.bag--;
                                    if(OBJ_jar.candyInJar == OBJ_jar.maxJar) {
                                        CollisionChecker.eff += 5;
                                        gp.ui.showMessage("Increase energy efficiency!");
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.cherry == 1 && gp.gameLevel == 1) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.waffle == 1 && gp.gameLevel == 2) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.rainbow == 1 && gp.gameLevel == 3) {
                                        gp.changeStage();
                                    }
                                }
                            } 
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left" :
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                System.out.println("left collision");
                                entity.collisionOn = true;
                                if (gp.obj[i].name.equals("base") && gp.player.energy < 10) {
                                    gp.player.energy++;
                                }
                                if (gp.obj[i].name.equals("jar") && gp.player.candy > 0 && gp.player.bag > 0){
                                    gp.player.candy--;
                                    OBJ_jar.candyInJar++;
                                    gp.player.bag--;
                                    if(OBJ_jar.candyInJar == OBJ_jar.maxJar) {
                                        CollisionChecker.eff += 5;
                                        gp.ui.showMessage("Increase energy efficiency!");
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.cherry == 1 && gp.gameLevel == 1) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.waffle == 1 && gp.gameLevel == 2) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.rainbow == 1 && gp.gameLevel == 3) {
                                        gp.changeStage();
                                    }
                                }
                            } 
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                System.out.println("right collision");
                                entity.collisionOn = true;
                                if (gp.obj[i].name.equals("base") && gp.player.energy < 10) {
                                    gp.player.energy++;
                                }
                                if (gp.obj[i].name.equals("jar") && gp.player.candy > 0 && gp.player.bag > 0){
                                    gp.player.candy--;
                                    OBJ_jar.candyInJar++;
                                    gp.player.bag--;
                                    if(OBJ_jar.candyInJar == OBJ_jar.maxJar) {
                                        CollisionChecker.eff += 5;
                                        gp.ui.showMessage("Increase energy efficiency!");
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.cherry == 1 && gp.gameLevel == 1) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.waffle == 1 && gp.gameLevel == 2) {
                                        gp.changeStage();
                                    }
                                    if (OBJ_jar.candyInJar == OBJ_jar.maxJar && gp.player.rainbow == 1 && gp.gameLevel == 3) {
                                        gp.changeStage();
                                    }
                                }
                            } 
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                }
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

            }
        }
        
        return index;
    }
    
    public void checkPassWay(Entity entity) {
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x - 48;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width - 48;
        int entityTopWorldY = entity.worldY + entity.solidArea.y + 48;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height + 48;
        
        int entityLeftCol = entityLeftWorldX/gp.titleSize;
        int entityRightCol = entityRightWorldX/gp.titleSize;
        int entityTopRow = entityTopWorldY/gp.titleSize;
        int entityBottomRow = entityBottomWorldY/gp.titleSize;
        
        int tileNum1, tileNum2;
        if(gp.player.energy > 0) {
            switch(entity.direction) {
            case "up" :
                entityTopRow = (entityTopWorldY - entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].passCheck.equals("change") || gp.tileM.tile[tileNum2].passCheck.equals("change")) {
                    if (gp.tileM.tile[tileNum1] != gp.tileM.tile[6] && gp.tileM.tile[tileNum2] != gp.tileM.tile[6]) {
                        entity.collisionOn = false;
                        gp.tileM.mapTileNum[entityLeftCol][entityTopRow] = 12;
                        gp.tileM.mapTileNum[entityRightCol][entityTopRow] = 12;
                        passcnt++;
                    }
                }
                break;
            case "down" :
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].passCheck.equals("change") || gp.tileM.tile[tileNum2].passCheck.equals("change")) {
                    if (gp.tileM.tile[tileNum1] != gp.tileM.tile[6] && gp.tileM.tile[tileNum2] != gp.tileM.tile[6]) {
                        entity.collisionOn = false;
                        gp.tileM.mapTileNum[entityLeftCol][entityBottomRow] = 12;
                        gp.tileM.mapTileNum[entityRightCol][entityBottomRow] = 12;
                        passcnt++;
                    }
                }
                break;
            case "left" :
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].passCheck.equals("change") || gp.tileM.tile[tileNum2].passCheck.equals("change")) {
                    if (gp.tileM.tile[tileNum1] != gp.tileM.tile[6] && gp.tileM.tile[tileNum2] != gp.tileM.tile[6]) {
                        entity.collisionOn = false;
                        gp.tileM.mapTileNum[entityLeftCol][entityTopRow] = 12;
                        gp.tileM.mapTileNum[entityLeftCol][entityBottomRow] = 12;
                        passcnt++;
                    }
                }
                break;
            case "right" :
                entityRightCol = (entityRightWorldX + entity.speed)/gp.titleSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].passCheck.equals("change") || gp.tileM.tile[tileNum2].passCheck.equals("change")) {
                    if (gp.tileM.tile[tileNum1] != gp.tileM.tile[6] && gp.tileM.tile[tileNum2] != gp.tileM.tile[6]) {
                        entity.collisionOn = false;
                        gp.tileM.mapTileNum[entityRightCol][entityTopRow] = 12;
                        gp.tileM.mapTileNum[entityRightCol][entityBottomRow] = 12;
                        passcnt++;
                    }
                }
                break;
            }
            
            if (passcnt == eff) {
                gp.player.energy--;
                passcnt = 0;
            } 
            
        }
    }
}
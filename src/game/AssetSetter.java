/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import object.OBJ_base;
import object.OBJ_candy;
import java.util.Random;
import object.OBJ_cherry;
import object.OBJ_jar;
import object.OBJ_rainbow;
import object.OBJ_waffle;
import object.Prop_IceCreamTree1;
import object.Prop_Popky1;
import object.Prop_Popky2;
import object.Prop_bluecloud;
import object.Prop_caramelcloud;
import object.Prop_coffeecloud;
import object.Prop_pinkcloud;

public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setObject() {
        
        //base
        gp.obj[0] = new OBJ_base();
        gp.obj[0].worldX = 21 * gp.titleSize;
        gp.obj[0].worldY = 8 * gp.titleSize;
        
        //prop
        gp.obj[1] = new Prop_Popky1();
        gp.obj[1].worldX = 8 * gp.titleSize;
        gp.obj[1].worldY = 7 * gp.titleSize;
        
        gp.obj[2] = new Prop_Popky2();
        gp.obj[2].worldX = 14 * gp.titleSize;
        gp.obj[2].worldY = 7 * gp.titleSize;
        
        gp.obj[3] = new Prop_IceCreamTree1();
        gp.obj[3].worldX = 15 * gp.titleSize;
        gp.obj[3].worldY = 8 * gp.titleSize;
        
        gp.obj[4] = new Prop_Popky1();
        gp.obj[4].worldX = 30 * gp.titleSize;
        gp.obj[4].worldY = 7 * gp.titleSize;
        
        
        //candy
        for (int i = 5; i < 15; i++) {
            gp.obj[i] = new OBJ_candy();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(18, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //cherry
        for (int i = 15; i < 16; i++) {
            gp.obj[i] = new OBJ_cherry();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(59, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //jar
        gp.obj[16] = new OBJ_jar();
        gp.obj[16].worldX = 17 * gp.titleSize;
        gp.obj[16].worldY = 12 * gp.titleSize;
        
        gp.obj[17] = new Prop_pinkcloud();
        gp.obj[17].worldX = 6 * gp.titleSize;
        gp.obj[17].worldY = 3 * gp.titleSize;
        
        gp.obj[18] = new Prop_bluecloud();
        gp.obj[18].worldX = 13 * gp.titleSize;
        gp.obj[18].worldY = 4 * gp.titleSize;
        
        gp.obj[19] = new Prop_caramelcloud();
        gp.obj[19].worldX = 21 * gp.titleSize;
        gp.obj[19].worldY = 3 * gp.titleSize;
        
        gp.obj[20] = new Prop_coffeecloud();
        gp.obj[20].worldX = 29 * gp.titleSize;
        gp.obj[20].worldY = 4 * gp.titleSize;
        
        gp.obj[21] = new Prop_caramelcloud();
        gp.obj[21].worldX = 10 * gp.titleSize;
        gp.obj[21].worldY = 2 * gp.titleSize;
        
        gp.obj[22] = new Prop_pinkcloud();
        gp.obj[22].worldX = 25 * gp.titleSize;
        gp.obj[22].worldY = 5 * gp.titleSize;
        
        gp.obj[23] = new Prop_IceCreamTree1();
        gp.obj[23].worldX = 35 * gp.titleSize;
        gp.obj[23].worldY = 8 * gp.titleSize;
        
        gp.obj[24] = new Prop_pinkcloud();
        gp.obj[24].worldX = 37 * gp.titleSize;
        gp.obj[24].worldY = 5 * gp.titleSize;
    }
    
    public void setObject2() {
        
        //base
        gp.obj[0] = new OBJ_base();
        gp.obj[0].worldX = 21 * gp.titleSize;
        gp.obj[0].worldY = 8 * gp.titleSize;
        
        //prop
        gp.obj[1] = new Prop_Popky1();
        gp.obj[1].worldX = 8 * gp.titleSize;
        gp.obj[1].worldY = 7 * gp.titleSize;
        
        gp.obj[2] = new Prop_Popky2();
        gp.obj[2].worldX = 14 * gp.titleSize;
        gp.obj[2].worldY = 7 * gp.titleSize;
        
        gp.obj[3] = new Prop_IceCreamTree1();
        gp.obj[3].worldX = 15 * gp.titleSize;
        gp.obj[3].worldY = 8 * gp.titleSize;
        
        gp.obj[4] = new Prop_Popky1();
        gp.obj[4].worldX = 30 * gp.titleSize;
        gp.obj[4].worldY = 7 * gp.titleSize;
        
        
        //candy
        for (int i = 5; i < 20; i++) {
            gp.obj[i] = new OBJ_candy();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(18, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //waffle
        for (int i = 20; i < 21; i++) {
            gp.obj[i] = new OBJ_waffle();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(59, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //jar
        gp.obj[22] = new OBJ_jar();
        gp.obj[22].worldX = 17 * gp.titleSize;
        gp.obj[22].worldY = 12 * gp.titleSize;
        
        gp.obj[23] = new Prop_pinkcloud();
        gp.obj[23].worldX = 6 * gp.titleSize;
        gp.obj[23].worldY = 3 * gp.titleSize;
        
        gp.obj[24] = new Prop_bluecloud();
        gp.obj[24].worldX = 13 * gp.titleSize;
        gp.obj[24].worldY = 4 * gp.titleSize;
        
        gp.obj[25] = new Prop_caramelcloud();
        gp.obj[25].worldX = 21 * gp.titleSize;
        gp.obj[25].worldY = 3 * gp.titleSize;
        
        gp.obj[26] = new Prop_coffeecloud();
        gp.obj[26].worldX = 29 * gp.titleSize;
        gp.obj[26].worldY = 4 * gp.titleSize;
        
        gp.obj[27] = new Prop_caramelcloud();
        gp.obj[27].worldX = 10 * gp.titleSize;
        gp.obj[27].worldY = 2 * gp.titleSize;
        
        gp.obj[28] = new Prop_pinkcloud();
        gp.obj[28].worldX = 25 * gp.titleSize;
        gp.obj[28].worldY = 5 * gp.titleSize;
        
        gp.obj[29] = new Prop_IceCreamTree1();
        gp.obj[29].worldX = 35 * gp.titleSize;
        gp.obj[29].worldY = 8 * gp.titleSize;
        
        gp.obj[30] = new Prop_pinkcloud();
        gp.obj[30].worldX = 37 * gp.titleSize;
        gp.obj[30].worldY = 5 * gp.titleSize;
    }
    
    public void setObject3() {
        
        //base
        gp.obj[0] = new OBJ_base();
        gp.obj[0].worldX = 21 * gp.titleSize;
        gp.obj[0].worldY = 8 * gp.titleSize;
        
        //prop
        gp.obj[1] = new Prop_Popky1();
        gp.obj[1].worldX = 8 * gp.titleSize;
        gp.obj[1].worldY = 7 * gp.titleSize;
        
        gp.obj[2] = new Prop_Popky2();
        gp.obj[2].worldX = 14 * gp.titleSize;
        gp.obj[2].worldY = 7 * gp.titleSize;
        
        gp.obj[3] = new Prop_IceCreamTree1();
        gp.obj[3].worldX = 15 * gp.titleSize;
        gp.obj[3].worldY = 8 * gp.titleSize;
        
        gp.obj[4] = new Prop_Popky1();
        gp.obj[4].worldX = 30 * gp.titleSize;
        gp.obj[4].worldY = 7 * gp.titleSize;
        
        
        //candy
        for (int i = 5; i < 25; i++) {
            gp.obj[i] = new OBJ_candy();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(18, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //cherry
        for (int i = 25; i < 26; i++) {
            gp.obj[i] = new OBJ_rainbow();
            //random X
            Random r = new Random();
            int xAxis = r.nextInt(8, 42);
            //random Y
            int yAxis = r.nextInt(59, 64);
            gp.obj[i].worldX = xAxis * gp.titleSize;
            gp.obj[i].worldY = yAxis * gp.titleSize;
        }
        //jar
        gp.obj[27] = new OBJ_jar();
        gp.obj[27].worldX = 17 * gp.titleSize;
        gp.obj[27].worldY = 12 * gp.titleSize;
        
        gp.obj[28] = new Prop_pinkcloud();
        gp.obj[28].worldX = 6 * gp.titleSize;
        gp.obj[28].worldY = 3 * gp.titleSize;
        
        gp.obj[29] = new Prop_bluecloud();
        gp.obj[29].worldX = 13 * gp.titleSize;
        gp.obj[29].worldY = 4 * gp.titleSize;
        
        gp.obj[30] = new Prop_caramelcloud();
        gp.obj[30].worldX = 21 * gp.titleSize;
        gp.obj[30].worldY = 3 * gp.titleSize;
        
        gp.obj[31] = new Prop_coffeecloud();
        gp.obj[31].worldX = 29 * gp.titleSize;
        gp.obj[31].worldY = 4 * gp.titleSize;
        
        gp.obj[32] = new Prop_caramelcloud();
        gp.obj[32].worldX = 10 * gp.titleSize;
        gp.obj[32].worldY = 2 * gp.titleSize;
        
        gp.obj[33] = new Prop_pinkcloud();
        gp.obj[33].worldX = 25 * gp.titleSize;
        gp.obj[33].worldY = 5 * gp.titleSize;
        
        gp.obj[34] = new Prop_IceCreamTree1();
        gp.obj[34].worldX = 35 * gp.titleSize;
        gp.obj[34].worldY = 8 * gp.titleSize;
        
        gp.obj[35] = new Prop_pinkcloud();
        gp.obj[35].worldX = 37 * gp.titleSize;
        gp.obj[35].worldY = 5 * gp.titleSize;
    }
}

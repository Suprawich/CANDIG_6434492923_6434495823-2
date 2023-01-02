/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package tile;

import game.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();

        loadMap("/map/world2.txt");
        
    }
    
    public void getTileImage() {
        try {
            // 0 = need to change
            // 1
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/chocolate.png"));
            tile[0].collision = true;
            tile[0].passCheck = "change";
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/lightlightchoco.png"));
            tile[1].collision = true;
            tile[1].passCheck = "change";
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky1.png"));
            tile[2].passCheck = "notchange";
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky2.png"));
            tile[3].collision = true;
            tile[3].passCheck = "notchange";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky3.png"));
            tile[4].passCheck = "notchange";
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky4.png"));
            tile[5].passCheck = "notchange";
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky5.png"));
            tile[6].passCheck = "notchange";
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/whitechoco.png"));
            tile[7].collision = true;
            tile[7].passCheck = "notchange";
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/superlight.png"));
            tile[8].collision = true;
            tile[8].passCheck = "change";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleleft.png"));
            tile[9].collision = true;
            tile[9].passCheck = "notchange";
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleright.png"));
            tile[10].collision = true;
            tile[10].passCheck = "notchange";
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/topchoco.png"));
            tile[11].collision = true;
            tile[11].passCheck = "change";
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/biscuit.png"));
            tile[12].collision = false;
            tile[12].passCheck = "notchange";
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void getTileImageLv2() {
        try {
            // 0 = need to change
            // 1
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/chocolate.png"));
            tile[0].collision = true;
            tile[0].passCheck = "change";
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/lightlightchoco.png"));
            tile[1].collision = true;
            tile[1].passCheck = "change";
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky10.png"));
            tile[2].passCheck = "notchange";
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky9.png"));
            tile[3].collision = true;
            tile[3].passCheck = "notchange";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky8.png"));
            tile[4].passCheck = "notchange";
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky7.png"));
            tile[5].passCheck = "notchange";
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky6.png"));
            tile[6].passCheck = "notchange";
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/whitechoco.png"));
            tile[7].collision = true;
            tile[7].passCheck = "notchange";
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/superlight.png"));
            tile[8].collision = true;
            tile[8].passCheck = "change";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleleft.png"));
            tile[9].collision = true;
            tile[9].passCheck = "notchange";
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleright.png"));
            tile[10].collision = true;
            tile[10].passCheck = "notchange";
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/topchoco.png"));
            tile[11].collision = true;
            tile[11].passCheck = "change";
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/biscuit.png"));
            tile[12].collision = false;
            tile[12].passCheck = "notchange";
    
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public void getTileImageLv3() {
        try {
            // 0 = need to change
            // 1
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/chocolate.png"));
            tile[0].collision = true;
            tile[0].passCheck = "change";
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/lightlightchoco.png"));
            tile[1].collision = true;
            tile[1].passCheck = "change";
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky15.png"));
            tile[2].passCheck = "notchange";
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky14.png"));
            tile[3].collision = true;
            tile[3].passCheck = "notchange";
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky13.png"));
            tile[4].passCheck = "notchange";
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky12.png"));
            tile[5].passCheck = "notchange";
            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sky11.png"));
            tile[6].passCheck = "notchange";
            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/whitechoco.png"));
            tile[7].collision = true;
            tile[7].passCheck = "notchange";
            
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/superlight.png"));
            tile[8].collision = true;
            tile[8].passCheck = "change";
            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleleft.png"));
            tile[9].collision = true;
            tile[9].passCheck = "notchange";
            
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/waffleright.png"));
            tile[10].collision = true;
            tile[10].passCheck = "notchange";
            
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/topchoco.png"));
            tile[11].collision = true;
            tile[11].passCheck = "change";
            
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/biscuit.png"));
            tile[12].collision = false;
            tile[12].passCheck = "notchange";
    
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e) {
            
        }
    }
    
    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.titleSize;
            int worldY = worldRow * gp.titleSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenY;
            int screenY = worldY - gp.player.worldY + gp.player.screenX;
            
            if (worldX + gp.titleSize*3 > gp.player.worldX - gp.player.screenX && 
                worldX - gp.titleSize*3 < gp.player.worldX + gp.player.screenX &&
                worldY + gp.titleSize*3 > gp.player.worldY - gp.player.screenY && 
                worldY - gp.titleSize*3 < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.titleSize, gp.titleSize, null);
        }
            worldCol++;
            
            
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }
    }
}

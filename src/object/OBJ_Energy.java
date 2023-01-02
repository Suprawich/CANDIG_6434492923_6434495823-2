/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import game.GamePanel;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Energy extends SuperObject {
    
    GamePanel gp;
    
    public OBJ_Energy(GamePanel gp) {
        
        this.gp = gp;
        
        name = "Energy";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyfull1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyfull2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyfull3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyhalf1.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyhalf2.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energyhalf3.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energynull1.png"));
            image8 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energynull2.png"));
            image9 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Energynull3.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import javax.imageio.ImageIO;

public class OBJ_candy extends SuperObject {
    
    public OBJ_candy() {
        name = "candy";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/yellowcandy.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkcandy1.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluecandy1.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
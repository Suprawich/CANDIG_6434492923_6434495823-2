/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import javax.imageio.ImageIO;

public class OBJ_bag extends SuperObject {
    
    public OBJ_bag() {
        
        name = "bag";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bag1.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

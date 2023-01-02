/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import javax.imageio.ImageIO;

public class OBJ_cherry extends SuperObject {
    public OBJ_cherry() {
        name = "cherry";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/cherry.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/cherrybw.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import javax.imageio.ImageIO;

public class OBJ_rainbow extends SuperObject {
    public OBJ_rainbow() {
        name = "rainbow";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/rainbow.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/rainbowbw.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_base extends SuperObject {
    
    public OBJ_base() {
        name = "base";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/base.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/base2.png"));
        }
        catch (IOException e) {
        }
        collision = true;
    }
}
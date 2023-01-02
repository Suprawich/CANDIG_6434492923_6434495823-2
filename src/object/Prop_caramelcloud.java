/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_caramelcloud extends SuperObject {
    public Prop_caramelcloud() {
        
        name = "caramelcloud";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/caramelcloud1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/cloud3.png"));
            
        } catch(IOException e) {
        }
    }
}

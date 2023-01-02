/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_pinkcloud extends SuperObject {
    public Prop_pinkcloud() {
        
        name = "pinkcloud";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkcloud1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/cloud4.png"));
            
        } catch(IOException e) {
        }
    }
}

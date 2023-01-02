/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_bluecloud extends SuperObject {
    public Prop_bluecloud() {
        
        name = "bluecloud";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/bluecloud1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/cloud2.png"));
            
        } catch(IOException e) {
        }
    }
}

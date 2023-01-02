/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_coffeecloud extends SuperObject {
    public Prop_coffeecloud() {
        
        name = "coffeecloud";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/coffeecloud1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/cloud1.png"));
            
        } catch(IOException e) {
        }
    }
}

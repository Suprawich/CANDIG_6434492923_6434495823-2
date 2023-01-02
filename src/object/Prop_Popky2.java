/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_Popky2 extends SuperObject {
    
    public Prop_Popky2() {
        
        name = "Popky2";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Popky2.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/popky4.png"));
            
        } catch(IOException e) {
        }
    }
}

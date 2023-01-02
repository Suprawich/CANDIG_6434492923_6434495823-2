/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_Popky1 extends SuperObject {
    
    public Prop_Popky1() {
        
        name = "Popky1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/Popky1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/popky3.png"));
            
        } catch(IOException e) {
        }
    }
}

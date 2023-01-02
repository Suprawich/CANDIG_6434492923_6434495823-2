/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Prop_IceCreamTree1 extends SuperObject {
    
    public Prop_IceCreamTree1() {
        
        name = "IceCreamTree1";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/tree1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/tree2.png"));
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

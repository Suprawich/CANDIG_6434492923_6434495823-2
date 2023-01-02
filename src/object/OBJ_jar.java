/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_jar extends SuperObject {
    
        public static int candyInJar = 0, maxJar = 10;
    
    public OBJ_jar() {
        name = "jar";
        
        try {
            
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar0.png"));
            image2= ImageIO.read(getClass().getResourceAsStream("/res/objects/jar1.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar2.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar3.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar5.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar7.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/res/objects/jar10.png"));

            image8= ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar1.png"));
            image9 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar2.png"));
            image10 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar3.png"));
            image11 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar5.png"));
            image12 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar7.png"));
            image13 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Pinkjar10.png"));
            
            image14= ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar1.png"));
            image15 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar2.png"));
            image16 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar3.png"));
            image17 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar5.png"));
            image18 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar7.png"));
            image19 = ImageIO.read(getClass().getResourceAsStream("/res/objects/Bluejar10.png"));
            
        }
        catch (IOException e) {
        }
        collision = true;
    }
}

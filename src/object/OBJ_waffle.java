/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package object;

import javax.imageio.ImageIO;

public class OBJ_waffle extends SuperObject {
    public OBJ_waffle() {
        name = "waffle";
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/waffle.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/wafflebw.png"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }
}

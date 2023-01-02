/**
 * @author 6434492923 Suprawich Sakulromvilas
 * @author 6434495823 Akarima Pengubon
 */

package game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    Clip clip;                              // to open voice sound
    URL soundURL[] = new URL[30];
    
    public Sound() {
        
        soundURL[0] = getClass().getResource("/res/sound/coin.wav");
        soundURL[1] = getClass().getResource("/res/sound/converted_sweetvibe.wav");
        
    }
    public void setFile(int i) {
        
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        } catch(Exception e) {
            
        }
    }
    public void play() {
        
        clip.start();
    }
    public void loop() {
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}

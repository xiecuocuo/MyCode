package Spring2.soundsystem2;

import Spring2.soundsystem.CompactDisc;
import Spring2.soundsystem.MediaPlayer;


public class CdPlayer implements MediaPlayer {
    private CompactDisc compactDisc;
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}

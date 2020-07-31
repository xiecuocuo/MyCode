package Spring2.soundsystem;

import Spring2.JavaConfig.CompactDisc;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
@Component("mediaPlayer")
public class CdPlayer implements MediaPlayer {
    @Inject
    private CompactDisc cd;

    public CdPlayer() {
    }

    public CdPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
    @Inject
    @Override
    public void play() {
        cd.play();
    }
}

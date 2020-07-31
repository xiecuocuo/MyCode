package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

public class CdPlayer implements MediaPlayer {
    @Inject
    private CompactDisc cd;
    @Inject
    public CdPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
    @Inject
    @Override
    public void play(CompactDisc cd) {
        cd.play();
    }
}

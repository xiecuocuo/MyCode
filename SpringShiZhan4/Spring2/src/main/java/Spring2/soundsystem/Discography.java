package Spring2.soundsystem;

import java.util.List;

public class Discography {
    private String artist;
    private String title;
    private List<CompactDisc> compactDiscs;

    public Discography(String artist, List<CompactDisc> compactDiscs) {
        this.artist = artist;
        this.compactDiscs = compactDiscs;
    }

    public void playCd(){
        for (CompactDisc compactDisc:compactDiscs) {
            compactDisc.play();
        }
    }
}

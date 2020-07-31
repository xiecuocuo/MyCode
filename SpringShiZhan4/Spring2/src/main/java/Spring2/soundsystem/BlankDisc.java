package Spring2.soundsystem;
import java.util.*;

public class BlankDisc implements CompactDisc  {
    private String artist;
    private String title;
    private List<String> tracks;

    public BlankDisc(String artist, String title, List<String> tracks) {
        this.artist = artist;
        this.title = title;
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing"+title+"by"+artist);
        for(String track:tracks){
            System.out.println("Track---"+track);
        }
    }
}

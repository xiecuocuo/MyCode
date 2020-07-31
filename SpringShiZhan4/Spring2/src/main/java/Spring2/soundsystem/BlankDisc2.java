package Spring2.soundsystem;

import java.util.*;

public class BlankDisc2 implements CompactDisc  {
    private String artist;
    private String title;
    private Set<String> tracks;

    public BlankDisc2(String artist, String title, Set<String> tracks) {
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

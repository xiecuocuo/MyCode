package Spring2.soundsystem2;

import Spring2.soundsystem.CompactDisc;

import java.util.List;

public class BlankDisc implements CompactDisc  {
    private String artist;
    private String title;
    private List<String> tracks;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
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

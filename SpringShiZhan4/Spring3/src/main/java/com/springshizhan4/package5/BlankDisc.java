package com.springshizhan4.package5;


import org.springframework.beans.factory.annotation.Value;

public class BlankDisc {

    private final String title;

    private final String artist;

    public BlankDisc(@Value("#{systemProperty['disc.title']}") String title, @Value("#{systemProperties['disc.artist']}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "BlankDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

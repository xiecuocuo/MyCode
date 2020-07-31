package soundsystem;

import org.springframework.stereotype.Component;


@Component("lonelyHeartsClub")
public class SgtPepers implements CompactDisc {
    private String title="Sgt.Peper's Lonely Hearts Club Band";
    private String artist="The Beatles";
    @Override
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
    }
}

package Spring2.soundsystem;

import Spring2.JavaConfig.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc lonelyHeartsClub;
    @Autowired
    private MediaPlayer mediaPlayer;


    @Test
    public void cdshouldNotBeNull(){
        System.out.println(lonelyHeartsClub);
    }

    @Test
    public void play(){
        mediaPlayer.play();
    }
}

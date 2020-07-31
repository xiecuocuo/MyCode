package Spring2.JavaConfig;

import Spring2.soundsystem.CDPlayerTest;
import Spring2.soundsystem.CdPlayer;
import Spring2.soundsystem.SgtPepers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
    @Bean(name = "lonelyHeartsClub")
    public CompactDisc getPepper(){
        return new SgtPepers();
    }
/*    @Bean
    public CompactDisc redomBeatlesCD(){
        int choice=(int)Math.floor(Math.random()*4);
        if(choice==0){
            return new SgtPepers();
        }else if(choice==1){
            return new WhiteAlbum();
        }else if(choice==2){
            return new HardDaysNight();
        }else {
            return new Revolver();
        }
    }*/
    @Bean
    public CdPlayer cdPlayer(){
        return new CdPlayer(getPepper());
    }
    @Bean
    public CdPlayer anotherCdPlayer(){
        return new CdPlayer(getPepper());
    }
    @Bean
    public CdPlayer cdPlayer(CompactDisc compactDisc){
        CdPlayer cdPlayer=new CdPlayer(compactDisc);
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}

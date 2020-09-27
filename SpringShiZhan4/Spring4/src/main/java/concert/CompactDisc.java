package concert;

import org.springframework.stereotype.Component;

@Component
public class CompactDisc {
    public void playTrack(int trackNum){
        System.out.println("CompactDisc play track... trackNum is "+trackNum);
    }
}

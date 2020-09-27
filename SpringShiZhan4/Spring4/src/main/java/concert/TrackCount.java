package concert;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Aspect
public class TrackCount {
    private Map<Integer,Integer> trackCounts=new HashMap<Integer,Integer>();
    @Pointcut("execution(public * concert.CompactDisc.playTrack(int)) && args(trackNum)")
    public void pointCut(int trackNum){};

    @Before("concert.TrackCount.pointCut(trackNum)")
    public void countTrack(int trackNum){
        int trackCount=getPlayCount(trackNum);
        trackCount++;
        System.out.println("trackNum="+trackNum+" ,"+"trackCount="+trackCount+";");
        trackCounts.put(trackNum,trackCount);
    }

    public int getPlayCount(int trackNum){
        return trackCounts.containsKey(trackNum)?trackCounts.get(trackNum):0;
    }
}

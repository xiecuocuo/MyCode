package xmlaop;

import java.util.HashMap;
import java.util.Map;

public class TrackCount {
    private Map<Integer,Integer> trackCounts=new HashMap<Integer,Integer>();
    public void pointCut(int trackNum){};

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

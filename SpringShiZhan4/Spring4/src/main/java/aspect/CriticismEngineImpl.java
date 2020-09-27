package aspect;

public class CriticismEngineImpl implements CriticismEngine {
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }

    public String getCriticism() {
        int i= (int) (Math.random()*criticismPool.length);
        return criticismPool[i];
    }

}

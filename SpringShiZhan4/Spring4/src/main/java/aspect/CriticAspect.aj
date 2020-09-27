package aspect;

public aspect CriticAspect {
    public CriticismEngine criticismEngine;
    public CriticAspect() {
    }
    pointcut proformance():execution(* concert.Proformer.proform(..));
    after() returning : performance(){
        System.out.println(criticismEngine.getCriticism());
    }
    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}

package cn.ynf.bean;

public class BraveKnight implements Knights {
    private Quest quest;
    private Minstrel minstrel;
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }//Quest被注入进来

    public void embarkOnQuest(){
        quest.embark();
    }
}

package cn.ynf.bean;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {
    private PrintStream printStream;

    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.print("Embark on quest to slay the dragon");
    }
}

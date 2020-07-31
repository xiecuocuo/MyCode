package cn.ynf.bean;

import java.io.PrintStream;

public class Minstrel {
    private PrintStream printStream;

    public Minstrel(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void singBeforQuest(){
        printStream.print("Fa La La the knight is so brave");
    }

    public void singAfterQuest(){
        printStream.print("Fa La La the knight is so brave, did embark on quest");
    }
}

package xmlaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    private void performance(){};

    /*public void silenceCellPhone(){
        System.out.println("silence CellPhones");
    }

    public void takeSeats(){
        System.out.println("Take Seats");
    }

    public void applause(){
        System.out.println("CLAP CLAP CLAP!");
    }

    public void demandRefund(){
        System.out.println("Demond a Refund");
    }

    public void goHome(){
        System.out.println("Go Home");
    }*/

    public void watchProformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("silence CellPhones");
            System.out.println("Take Seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!");
        } catch (Throwable throwable) {
            System.out.println("Demond a Refund");
            throwable.printStackTrace();
        }
        System.out.println("GO HOME!");
    }
}

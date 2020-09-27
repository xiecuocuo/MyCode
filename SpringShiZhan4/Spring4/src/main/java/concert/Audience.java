package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(public * concert.Proformance.*(..))")
    private void performance(){};
    /*@Before("concert.Audience.performance()")
    public void silenceCellPhone(){
        System.out.println("silence CellPhones");
    }

    @Before("concert.Audience.performance()")
    public void takeSeats(){
        System.out.println("Take Seats");
    }

    @AfterReturning("concert.Audience.performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!");
    }

    @AfterThrowing("concert.Audience.performance()")
    public void demandRefund(){
        System.out.println("Demond a Refund");
    }
    @After("concert.Audience.performance()")
    public void goHome(){
        System.out.println("Go Home");
    }*/
    @Around("concert.Audience.performance()")
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

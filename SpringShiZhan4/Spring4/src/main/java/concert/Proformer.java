package concert;

import org.springframework.stereotype.Component;

@Component
public class Proformer implements Proformance {
    public void proform() {
        System.out.println("演员表演------------");
    }
}

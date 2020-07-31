package Spring2.package5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDconfig {
    @Bean
    public CompactDisc getCompactDisc(){
        return new SgtPepers();
    }
}

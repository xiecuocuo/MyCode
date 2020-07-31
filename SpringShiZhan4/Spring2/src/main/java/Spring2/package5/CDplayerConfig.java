package Spring2.package5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CDconfig.class)
public class CDplayerConfig {
    @Bean
    public CDPlayer getPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}

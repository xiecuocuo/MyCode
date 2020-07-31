package Spring2.package5;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({CDconfig.class,CDplayerConfig.class})
@ImportResource("classpath:applicationContext.xml")
public class SoundSystemConfig {
}

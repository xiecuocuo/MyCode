package Spring2.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={CDPlayerConfig.class,CDPlayerTest.class})
public class CDPlayerConfig {
}

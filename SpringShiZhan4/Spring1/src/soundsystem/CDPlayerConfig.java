package soundsystem;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackageClasses={CDPlayerConfig.class,CDPlayerTest.class})
public class CDPlayerConfig {
}

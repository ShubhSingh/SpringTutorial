package tutorial10.springjdbc.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = "tutorial10.springjdbc.annotation")
@Import(DBConfig.class)
public class JavaConfig {
}

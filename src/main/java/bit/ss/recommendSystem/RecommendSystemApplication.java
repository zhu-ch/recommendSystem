package bit.ss.recommendSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("bit.ss.recommendSystem")
public class RecommendSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecommendSystemApplication.class, args);
    }

}

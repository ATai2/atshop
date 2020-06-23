import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.at.auth.dao")
public class ManageMentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageMentApplication.class, args);
    }
}
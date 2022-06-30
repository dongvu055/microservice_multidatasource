package anhdong.demo2;

import anhdong.demo2.testbean2.BeanDemo2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("anhdong")
public class Demo2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Demo2Application.class, args);
        BeanDemo2 beanDemo2 = context.getBean(BeanDemo2.class);
        System.out.println(beanDemo2);

    }

}

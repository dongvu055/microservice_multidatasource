package anhdong.demo1;

import anhdong.demo1.testbean1.apitest.TestData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class Demo1ApplicationTests {

    @Autowired
    ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        TestData bean = applicationContext.getBean(TestData.class);
        bean.test();

    }

}

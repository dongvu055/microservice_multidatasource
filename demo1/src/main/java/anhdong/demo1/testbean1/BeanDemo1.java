package anhdong.demo1.testbean1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanDemo1 {
    private int a;
    private String b;

    public BeanDemo1() {
        this.a = 5;
        this.b = "Xinchao";
    }
}

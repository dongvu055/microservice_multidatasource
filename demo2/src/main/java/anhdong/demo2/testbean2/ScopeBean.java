package anhdong.demo2.testbean2;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ScopeBean {
    private int a;
    private String b;
}

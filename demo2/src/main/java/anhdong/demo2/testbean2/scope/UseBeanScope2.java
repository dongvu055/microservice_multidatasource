package anhdong.demo2.testbean2.scope;

import anhdong.demo2.testbean2.ScopeBean;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class UseBeanScope2 {
    @Autowired
    private ScopeBean scopeBean;
}

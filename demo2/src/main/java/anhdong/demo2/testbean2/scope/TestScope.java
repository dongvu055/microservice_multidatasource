package anhdong.demo2.testbean2.scope;

import anhdong.demo2.testbean2.ScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestScope {
    @Autowired
    private UseBeanScope1 useBeanScope1;

    @Autowired
    private UseBeanScope2 useBeanScope2;

    @Autowired
    void test() {
        ScopeBean scopeBean1 = useBeanScope1.getScopeBean();
        scopeBean1.setB("Xinchao");
        ScopeBean scopeBean2 = useBeanScope2.getScopeBean();
    }
}

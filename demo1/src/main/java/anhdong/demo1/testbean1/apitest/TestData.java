package anhdong.demo1.testbean1.apitest;

import anhdong.demo1.testbean1.entity.dao1.AccountType;
import anhdong.demo1.testbean1.entity.dao2.AppLink;
import anhdong.demo1.testbean1.repo.repo1.DataRepo1;
import anhdong.demo1.testbean1.repo.repo2.DataRepo2;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TestData {

    DataRepo1 dataRepo1;

    DataRepo2 dataRepo2;

    @Autowired
    void test()
    {
        List<AccountType> accountTypes = dataRepo1.findAll();

        List<AppLink> appLinks = dataRepo2.findAll();
    }
}

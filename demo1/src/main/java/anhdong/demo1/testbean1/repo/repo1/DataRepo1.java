package anhdong.demo1.testbean1.repo.repo1;

import anhdong.demo1.testbean1.entity.dao1.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo1 extends JpaRepository<AccountType, Integer> {
}

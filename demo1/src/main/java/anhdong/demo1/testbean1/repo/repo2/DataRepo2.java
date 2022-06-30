package anhdong.demo1.testbean1.repo.repo2;

import anhdong.demo1.testbean1.entity.dao2.AppLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo2 extends JpaRepository<AppLink, Integer> {
}

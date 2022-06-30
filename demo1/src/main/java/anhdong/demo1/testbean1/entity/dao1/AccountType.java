package anhdong.demo1.testbean1.entity.dao1;

import javax.persistence.*;

@Entity
@Table(name = "customer.account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "cust_id")
    private int custId;

}

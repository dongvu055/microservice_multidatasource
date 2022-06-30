package anhdong.demo1.testbean1.entity.dao2;

import javax.persistence.*;

@Entity
@Table(name = "general.app_link")
public class AppLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "app_key")
    private String appKey;

    @Column(name = "app_link")
    private String appLink;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "google_code")
    private String googleCode;

}

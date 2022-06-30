package anhdong.demo1.testbean1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class TestConnect {

    @Autowired
    @Qualifier("datasource1")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("datasource2")
    private DataSource dataSource2;

    @Autowired
    void test() {
        JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource1);
        JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource2);
        jdbcTemplate1.query("select * from customer.account_type ", (rs, rowNum) -> {
            System.out.print("id:" + rs.getInt("id"));
            System.out.print(" name:" + rs.getString("name"));
            System.out.print(" status:" + rs.getInt("status"));
            System.out.print(" cust_id:" + rs.getInt("cust_id"));
            System.out.println();
            return null;
        });
        jdbcTemplate2.query("select * from general.app_link al ", (rs, rowNum) -> {
            System.out.print("id:" + rs.getInt("id"));
            System.out.print(" app_key:" + rs.getString("app_key"));
            System.out.print(" app_link:" + rs.getString("app_link"));
            System.out.print(" app_name:" + rs.getString("app_name"));
            System.out.print(" google_code:" + rs.getString("google_code"));
            System.out.println();
            return null;
        });


    }
}

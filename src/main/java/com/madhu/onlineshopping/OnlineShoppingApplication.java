package com.madhu.onlineshopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication
public class OnlineShoppingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql, 564, "Madhu", 1500000);

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }*/

    }
}


package com.ecom.application.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Jdbc implements CommandLineRunner {
    @Override
    public void run(String... args){
    String sql = " INSERT INTO users (name, email) values (?,?) ";

    String url = "jdbc:postgresql://localhost:5432/jdbc";
    String username = "postgres";
    String password = "Password";


    try (Connection con = DriverManager.getConnection(url, username, password);
         PreparedStatement ps = con.prepareStatement(sql)){

        ps.setString(1, "Abhi");
        ps.setString(2, "abhi@gmail.com");

        ps.executeUpdate();
    } catch (
    SQLException e) {
        e.printStackTrace();
    }
    }
}

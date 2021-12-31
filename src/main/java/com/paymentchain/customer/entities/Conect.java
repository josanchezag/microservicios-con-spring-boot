package com.paymentchain.customer.entities;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conect {

    public static Connection getConnection(){

        try{
            URI jdbUri = new URI(System.getenv("JAWSDB_URL"));
            String username = jdbUri.getUserInfo().split(":")[0];
            String password = jdbUri.getUserInfo().split(":")[1];
            String port = String.valueOf(jdbUri.getPort());
            String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
            return DriverManager.getConnection(jdbUrl, username, password);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



        return null;
    }
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCManager {

    private String url,user,password;
    private Connection con;

    public JDBCManager(String url,String user, String password) throws SQLException {
        this.url = url;
        this.url = user;
        this. password = password;
        con = DriverManager.getConnection(url,user,password);
    }

    public Connection getConnection() {
        return con;
    }



}

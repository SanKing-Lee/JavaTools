package SQLiteBrowser.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String URL_PREFIX = "jdbc:sqlite:";

    public void connect(String url) {
        Connection connection = null;
        url = URL_PREFIX + url;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to " + url + "!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

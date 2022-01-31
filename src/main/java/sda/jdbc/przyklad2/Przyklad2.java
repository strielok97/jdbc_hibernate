package sda.jdbc.przyklad2;

import sda.jdbc.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Przyklad2 {
//tu statement jest określony, trzeba by robić nowy statement żeby robić do czego innego zapytania
    public static void main(String[] args) throws SQLException {
        String query = "Select * from Address where add_id = ?";

        DatabaseConnection databaseConnection = new DatabaseConnection();

        PreparedStatement preparedStatement = databaseConnection
                .getConnection()
                .prepareStatement(query);

        preparedStatement.setString(1, "3");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("ADD_Street"));
        }
    }

}
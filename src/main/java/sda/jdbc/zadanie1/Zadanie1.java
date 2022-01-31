package sda.jdbc.zadanie1;

import sda.jdbc.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Napisz program który pobierze z bazy danych imiona oraz nazwiska wszystkich użytkowników - wyświetl je w konsoli
 * */
public class Zadanie1 {

    public static final int FIRST_NAME_PARAM_INDEX = 1;
    public static final int LAST_NAME_PARAM_INDEX = 2;

    public static void main(String[] args) throws SQLException {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        //jezeli chcemy dac uzytykonikowy konkretnej ulicy to prepared statement
        /*String query = "select usr_firstname fn, usr_lastname ln from user;";*/
        String query = "select usr_firstname fn, usr_lastname ln from user where usr_firstname = ? and usr_lastname = ?;";

        PreparedStatement preparedStatement = databaseConnection
                .getConnection()
                .prepareStatement(query);

        preparedStatement.setString(FIRST_NAME_PARAM_INDEX, "Jan"); //tu lepiej zrobić tak zamiast wpisywać 1!
        preparedStatement.setString(LAST_NAME_PARAM_INDEX, "Kowalski");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("fn") + " ");
            System.out.println(resultSet.getString("ln"));
        }
    }



}

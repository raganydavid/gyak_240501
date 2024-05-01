/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zenekkonzol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class MusicDatabaseImporter {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/zenek";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        importDataFromTextFile();
    }

    public static void importDataFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("zenek.txt"));
             Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

        
                insertDataIntoDatabase(connection, parts);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertDataIntoDatabase(Connection connection, String[] parts) throws SQLException {

        String sql = "INSERT INTO your_table_name (hour, minute, second, other_column_name) VALUES (?, ?, ?, ?)";
        

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setInt(1, Integer.parseInt(parts[0])); 
            statement.setInt(2, Integer.parseInt(parts[1])); 
            statement.setInt(3, Integer.parseInt(parts[2])); 
            statement.setString(4, parts[5]); 

            statement.executeUpdate();
        }
    }
}
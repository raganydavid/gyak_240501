/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class ZenekKonzol {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            
            loadMusicData(conn, "zene.txt");
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    private static void loadMusicData(Connection conn, String filename) {
        String sql = "INSERT INTO music (title, artist, duration) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                String title = parts[3]; 
                String artist = parts[4]; 
                String duration = parts[0] + ":" + parts[1] + ":" + parts[2]; 

                stmt.setString(1, title);
                stmt.setString(2, artist);
                stmt.setString(3, duration);

                
                stmt.executeUpdate();
            }
            System.out.println("Music data loaded successfully!");
        } catch (IOException | SQLException e) {
            System.err.println("Error loading music data: " + e.getMessage());
        }
    }
    
}

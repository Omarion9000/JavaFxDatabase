package org.example.javafxdatabase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;

public class HelloController {

    @FXML
    private Label labelId;
    @FXML
    private Label labelName;
    @FXML
    private Label labelAge;

    @FXML
    private void handleButtonAction() {

        String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC"; // Added parameters to avoid SSL and timezone issues
        String user = "root";
        String password = "1234";


        String query = "SELECT id, name, age FROM students WHERE id = 1";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                labelId.setText(String.valueOf(rs.getInt("id")));
                labelName.setText(rs.getString("name"));
                labelAge.setText(String.valueOf(rs.getInt("age")));
            } else {
                labelId.setText("No Data");
                labelName.setText("No Data");
                labelAge.setText("No Data");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}

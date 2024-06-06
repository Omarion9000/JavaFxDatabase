module org.example.javafxdatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.javafxdatabase to javafx.fxml;
    exports org.example.javafxdatabase;
}
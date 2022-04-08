import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class Address {
    Connection conn;
    PreparedStatement pst;
    
    @FXML
    private AnchorPane apAddress;

    @FXML
    private Button btnBackAddress;

    @FXML
    private Button btnContinue;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfCity;

    @FXML
    private TextField tfFullName;

    @FXML
    private TextField tfPhone;

    @FXML
    void btnBackAddress(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Order.fxml"));
        apAddress.getChildren().setAll(pane);
    }

    @FXML
    void btnContinue(ActionEvent event) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");
        
            if (tfFullName.getText().isBlank() || tfAddress.getText().isBlank() || tfCity.getText().isBlank() || tfPhone.getText().isBlank()) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please fill all required fields!");
                error.showAndWait();
            } else {
                pst = conn.prepareStatement("INSERT INTO Customer (FullName, Address, City, Phone) VALUES (?, ?, ?, ?)");
                pst.setString(1, tfFullName.getText());
                pst.setString(2, tfAddress.getText());
                pst.setString(3, tfCity.getText());
                pst.setString(4, tfPhone.getText());
                pst.executeUpdate();

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Payment.fxml"));
                apAddress.getChildren().setAll(pane);
            }
            //st.close();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Error! Please contact Customer Service!");
            error.showAndWait();
        }
        
    }

    @FXML
    void tfAddress(ActionEvent event) {

    }

    @FXML
    void tfCity(ActionEvent event) {

    }

    @FXML
    void tfFullName(ActionEvent event) {

    }

    @FXML
    void tfPhone(ActionEvent event) {

    }

}
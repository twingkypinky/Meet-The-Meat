import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class register {
    Connection conn;
    PreparedStatement pst;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtfieldRegisName;

    @FXML
    private TextField txtfieldRegisPassword;

    @FXML
    private TextField txtfieldRegisPasswordConfirm;

    @FXML
    void btnRegisterPushed(ActionEvent event) throws IOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            pst = conn.prepareStatement("INSERT INTO Admin (Name, Password, ConfirmPassword) VALUES (?, ?, ?)");
            pst.setString(1, txtfieldRegisName.getText());
            pst.setString(2, txtfieldRegisPassword.getText());
            pst.setString(3, txtfieldRegisPasswordConfirm.getText());

            if(txtfieldRegisName.getText().isBlank()||txtfieldRegisPassword.getText().isBlank()||txtfieldRegisPasswordConfirm.getText().isBlank()){
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input the name, password, and confrim password!");
                error.showAndWait();
            } else {
                if (txtfieldRegisPassword.getText().equals(txtfieldRegisPasswordConfirm.getText())) {
                    pst.executeUpdate();
                    Alert error = new Alert(AlertType.INFORMATION);
                    error.setTitle("Information Dialog");
                    error.setHeaderText(null);
                    error.setContentText("Registered new admin successfully");
                    error.showAndWait();
                    txtfieldRegisName.clear();
                    txtfieldRegisPassword.clear();
                    txtfieldRegisPasswordConfirm.clear();
                } else {
                    Alert error = new Alert(AlertType.ERROR);
                    error.setTitle("Error Dialog");
                    error.setHeaderText("An Error Has Occurred");
                    error.setContentText("Password and Confirm Password does not match!");
                    error.showAndWait();
                }
            }

            
        }catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Failed to register admin!");
            error.showAndWait();
        }
    }
    
}

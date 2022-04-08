import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.Statement;

public class admin {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtfieldPassword;

    @FXML
    private TextField txtfieldUsername;

    @FXML
    void btnBackPushed(ActionEvent event) throws IOException {
        Parent pToLoB = FXMLLoader.load(getClass().getResource("HalamanUtama.fxml"));
        Stage stToLoB = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToLoB = new Scene(pToLoB);
        stToLoB.setScene(scToLoB);
        stToLoB.show();
    }
    
    @FXML
    void btnLoginPushed(ActionEvent event) throws IOException {
        try{
            String host = "jdbc:mysql://localhost:3306/burgerapp";
            String username = "root";
            String password = "240122";
            Connection conn = DriverManager.getConnection(host, username, password);
            Statement st = conn.createStatement();

            String nameIn = txtfieldUsername.getText();
            String passwordIn = txtfieldPassword.getText();

            String sql = "SELECT * FROM burgerapp.Admin where Name = '" + nameIn + "'and Password = '"+ passwordIn +"'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                Parent pToInventory = FXMLLoader.load(getClass().getResource("Inventory GUI.fxml"));
                Stage stToInventory = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scToInventory = new Scene(pToInventory);
                stToInventory.setScene(scToInventory);
                stToInventory.show();
            } else {
                if (txtfieldUsername.getText().isBlank() || txtfieldPassword.getText().isBlank()) {
                    Alert error = new Alert(AlertType.ERROR);
                    error.setTitle("Error Dialog");
                    error.setHeaderText("An Error Has Occurred");
                    error.setContentText("A field is empty!");
                    error.showAndWait();
                } else {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Incorrect name or password!");
                error.showAndWait();
                }
            }
        } catch(Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Unable to log in!");
            error.showAndWait();
        }
    }
    
    @FXML
    void btnRegisNewAdminPushed(ActionEvent event) throws IOException {
        Parent pToAdmin = FXMLLoader.load(getClass().getResource("Register GUI.fxml"));
        Stage stToAdmin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToAdmin = new Scene(pToAdmin);
        stToAdmin.setScene(scToAdmin);
        stToAdmin.show();
    }

}



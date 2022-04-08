

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class register {
    Connection con;
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
    private Label regisMessage;

    @FXML
    void btnRegisterPushed(ActionEvent event) throws IOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            pst = con.prepareStatement("insert into Admin (Name, Password, ConfirmPassword) VALUES (?, ?, ?)");
            pst.setString(1, txtfieldRegisName.getText());
            pst.setString(2, txtfieldRegisPassword.getText());
            pst.setString(3, txtfieldRegisPasswordConfirm.getText());
            

            if(txtfieldRegisName.getText().isBlank()||txtfieldRegisPassword.getText().isBlank()||txtfieldRegisPasswordConfirm.getText().isBlank()){
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input the name, password, and confrim password!");
                error.showAndWait();
            }

            while(txtfieldRegisPassword.getText().equals(txtfieldRegisPasswordConfirm.getText())){
                int status = pst.executeUpdate();

                if(status == -1){
                    JOptionPane.showMessageDialog(null,"record failed");
                } else {
                    txtfieldRegisName.setText(null);
                    txtfieldRegisPassword.setText(null);
                    txtfieldRegisPasswordConfirm.setText(null);



                }
                Alert error = new Alert(AlertType.NONE);
            error.setTitle("Confirmation Register");
           // error.setHeaderText("An Error Has Occurred");
        error.setContentText("Selamat anda berhasil login!");
        error.showAndWait();
                txtfieldRegisName.setText(null);
                txtfieldRegisPassword.setText(null);
                txtfieldRegisPasswordConfirm.setText(null);
        } }catch (Exception e) {
            e.getStackTrace();
            e.getCause();
        }
    }

    
}

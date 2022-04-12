import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class Payment {

    private Label label;
    java.util.LinkedList<Integer> list = new java.util.LinkedList<Integer>();

    @FXML
    private AnchorPane apPayment;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPayNowPayment;

    @FXML
    private TextField tfPhonePayment;

    @FXML
    void btnBack(ActionEvent event) throws IOException {

        // ALERT, jika user klik back maka proses payment tidak akan di proses

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Exit this page?");
            alert.setHeaderText("Transaction will not be processed if you leave this page.");

            ButtonType ExitPage = new ButtonType("Exit Page");
            ButtonType ContinueToPay = new ButtonType("Continue to Pay");
		

		// Remove default ButtonTypes
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(ExitPage,ContinueToPay);

        //result !=null
            Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == null){
                    this.label.setText("No selection!");
                } else if (result.get() == ExitPage){
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    apPayment.getChildren().setAll(pane);
                } else if (result.get() == ContinueToPay){
                    this.label.setText("You choose to continue payment!");

       }         
       }


    @FXML
    void btnPayNowPayment(ActionEvent event) throws IOException {
        try {

        } catch (Exception e) {
            
        }
        
        // jika klik button Pay Now maka akan di alihkan ke page after order

        AnchorPane pane = FXMLLoader.load(getClass().getResource("AfterOrder.fxml"));
        apPayment.getChildren().setAll(pane);

    }

    @FXML
    void tfPhonePayment(ActionEvent event) {

    }

}
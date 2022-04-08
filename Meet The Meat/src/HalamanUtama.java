import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HalamanUtama {

    @FXML
    private AnchorPane apHU;

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnProducts;


    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminGUI.fxml"));
        apHU.getChildren().setAll(pane);


    }

    @FXML
    void btnContact(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("ContactUs.fxml"));
        apHU.getChildren().setAll(pane);

    }

    @FXML
    void btnProducts(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        apHU.getChildren().setAll(pane);
        

    }

}

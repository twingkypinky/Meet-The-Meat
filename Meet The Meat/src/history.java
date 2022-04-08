import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class history {

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<?, ?> colCusID;

    @FXML
    private TableColumn<?, ?> colItem;

    @FXML
    private TableColumn<?, ?> colOrdNum;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableView<?> tblViewHistory;

    @FXML
    void btnBackPushed(ActionEvent event) throws IOException {
        Parent pToCustomer = FXMLLoader.load(getClass().getResource("Customer GUI.fxml"));
        Stage stToCustomer = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToCustomer = new Scene(pToCustomer);
        stToCustomer.setScene(scToCustomer);
        stToCustomer.show();
    }

}

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class history implements Initializable {
    Connection conn;
    PreparedStatement pst;

    ObservableList<history2> data = FXCollections.observableArrayList();

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<history2, Integer> colCusID;

    @FXML
    private TableColumn<history2, String> colItem;

    @FXML
    private TableColumn<history2, Integer> colOrdNum;

    @FXML
    private TableColumn<history2, Integer> colPrice;

    @FXML
    private TableColumn<history2, Integer> colQuantity;

    @FXML
    private TableView<history2> tblViewHistory;
    

    @FXML
    void btnBackPushed(ActionEvent event) throws IOException {
        Parent pToCustomer = FXMLLoader.load(getClass().getResource("Customer GUI.fxml"));
        Stage stToCustomer = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToCustomer = new Scene(pToCustomer);
        stToCustomer.setScene(scToCustomer);
        stToCustomer.show();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colCusID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colItem.setCellValueFactory(new PropertyValueFactory<>("Item"));
        colOrdNum.setCellValueFactory(new PropertyValueFactory<>("OrderNumber"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("QTY"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = ConnectToDatabase.AdminConnection();

            String sql = "SELECT * FROM History";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                data.add(new history2(rs.getInt("OrderNumber"), rs.getInt("CustomerID"), rs.getString("Item"), rs.getInt("Quantity"), rs.getInt("Price")));
            }
            tblViewHistory.setItems(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Failed to retrieve data!");
            error.showAndWait();
        }
    }
}
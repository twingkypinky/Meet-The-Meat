import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class customer implements Initializable{
    Connection conn;
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private TableView<customer2> tblViewCustomer;

    @FXML
    private TableColumn<customer2, Integer> colCusID;

    @FXML
    private TableColumn<customer2, String> colAddress;

    @FXML
    private TableColumn<customer2, String> colCity;

    @FXML
    private TableColumn<customer2, String> colPhone;

    @FXML
    private TableColumn<customer2, String> collFName;

    ObservableList<customer2> data = FXCollections.observableArrayList();

    @Override    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        collFName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT * FROM Customer";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                data.add(new customer2(rs.getInt("CustomerID"), rs.getString("FullName"), rs.getString("Address"), rs.getString("City"), rs.getString("Phone")));
            }
            tblViewCustomer.setItems(data);
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Failed to retrieve data!");
            error.showAndWait();
        }
    }

    @FXML
    void btnBackPushed(ActionEvent event) throws IOException {
        Parent pToInventory = FXMLLoader.load(getClass().getResource("Inventory GUI.fxml"));
        Stage stToInventory = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToInventory = new Scene(pToInventory);
        stToInventory.setScene(scToInventory);
        stToInventory.show();
    }

    @FXML
    void btnNextPushed(ActionEvent event) throws IOException {
        Parent pToHistory = FXMLLoader.load(getClass().getResource("History GUI.fxml"));
        Stage stToHistory = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToHistory = new Scene(pToHistory);
        stToHistory.setScene(scToHistory);
        stToHistory.show();
    }

}

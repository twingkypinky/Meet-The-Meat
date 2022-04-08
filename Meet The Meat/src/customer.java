import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
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
    private Button btnGetData;

    @FXML
    private TableColumn<customer2, String> colAddress;

    @FXML
    private TableColumn<customer2, String> colCity;

    @FXML
    private TableColumn<customer2, Integer> colCusID;

    @FXML
    private TableColumn<customer2, String> colPhone;

    @FXML
    private TableColumn<customer2, String> collFName;

    @FXML
    private TableView<customer2> tblViewCustomer;

    ObservableList<customer2> data = FXCollections.observableArrayList();
        //new customer2(customerID, fullname, address, city, phone)
    

    @Override    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        collFName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "Bh6666kv");

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
    //ObservableList<customer2> obList = FXCollections.observableArrayList();

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT * FROM Customer";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obList.add(new customer2(rs.getString("CustomerID"), rs.getString("FullName"), rs.getString("Address"), rs.getString("City"), rs.getString("Phone")));
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Please input integer only!");
            error.showAndWait();
        }

        colCusID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("City"));
        collFName.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        table.setItems(obList);
    }*/

    @FXML
    void btnGetDataPushed(ActionEvent event) throws IOException {
        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT * FROM Customer";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                //obList.add(new customer2(rs.getString("CustomerID"), rs.getString("FullName"), rs.getString("Address"), rs.getString("City"), rs.getString("Phone")));
                String customerID = rs.getString("CustomerID");
                String fullName = rs.getString("FullName");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String phone = rs.getString("Phone");

                colCusID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("City"));
        collFName.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Please input integer only!");
            error.showAndWait();
        }*/
    }

    //public void initialize
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

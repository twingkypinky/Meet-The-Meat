import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class inventory implements Initializable {
    Connection conn;
    PreparedStatement pst;

    @FXML
    private TableView<inventory2> tblviewInventory;

    @FXML
    private TableColumn<inventory2, String> colFoodName;

    @FXML
    private TableColumn<inventory2, Integer> colPrice;

    @FXML
    private TableColumn<inventory2, Integer> colStock;

    @FXML
    private Button btnAddToBurger1;

    @FXML
    private Button btnAddToBurger2;

    @FXML
    private Button btnAddToBurger3;

    @FXML
    private Button btnAddToBurger4;

    @FXML
    private Button btnAddToBurger5;

    @FXML
    private Button btnAddToBurger6;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private TextField txtfieldBurger1;

    @FXML
    private TextField txtfieldBurger2;

    @FXML
    private TextField txtfieldBurger3;

    @FXML
    private TextField txtfieldBurger4;

    @FXML
    private TextField txtfieldBurger5;

    @FXML
    private TextField txtfieldBurger6;

    ObservableList<inventory2> data = FXCollections.observableArrayList();

    @Override    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colFoodName.setCellValueFactory(new PropertyValueFactory<>("FoodName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT * FROM Inventory";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                data.add(new inventory2(rs.getString("FoodName"), rs.getInt("Price"), rs.getInt("Stock")));
            }
            tblviewInventory.setItems(data);
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Failed to retrieve data!");
            error.showAndWait();
        }
    }

    public void updateTable() {
        tblviewInventory.getItems().clear();
        colFoodName.setCellValueFactory(new PropertyValueFactory<>("FoodName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT * FROM Inventory";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                data.add(new inventory2(rs.getString("FoodName"), rs.getInt("Price"), rs.getInt("Stock")));
            }
            tblviewInventory.setItems(data);
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Failed to retrieve data!");
            error.showAndWait();
        }
    }

    @FXML
    void btnAddToBurger1Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger1 = Integer.parseInt(txtfieldBurger1.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger1'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger1.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB1 = rs.getInt("Stock");
                    int total = stockB1 + frmTxtfieldBurger1;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger1");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger1.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        tblviewInventory.refresh();
        txtfieldBurger1.clear();
    }

    @FXML
    void btnAddToBurger2Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger2 = Integer.parseInt(txtfieldBurger2.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger2'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger2.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB2 = rs.getInt("Stock");
                    int total = stockB2 + frmTxtfieldBurger2;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger2");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger2.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        txtfieldBurger2.clear();
    }

    @FXML
    void btnAddToBurger3Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger3 = Integer.parseInt(txtfieldBurger3.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger3'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger3.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB3 = rs.getInt("Stock");
                    int total = stockB3 + frmTxtfieldBurger3;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger3");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger3.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        txtfieldBurger3.clear();
    }

    @FXML
    void btnAddToBurger4Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger4 = Integer.parseInt(txtfieldBurger4.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger4'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger4.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB4 = rs.getInt("Stock");
                    int total = stockB4 + frmTxtfieldBurger4;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger4");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger4.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        txtfieldBurger4.clear();
    }

    @FXML
    void btnAddToBurger5Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger5 = Integer.parseInt(txtfieldBurger5.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger5'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger5.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB5 = rs.getInt("Stock");
                    int total = stockB5 + frmTxtfieldBurger5;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger5");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger5.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        txtfieldBurger5.clear();
    }

    @FXML
    void btnAddToBurger6Pushed(ActionEvent event) {
        try {
            int frmTxtfieldBurger6 = Integer.parseInt(txtfieldBurger6.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Burger6'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (txtfieldBurger6.getText().contains("-")) {
                Alert error = new Alert(AlertType.ERROR);
                error.setTitle("Error Dialog");
                error.setHeaderText("An Error Has Occurred");
                error.setContentText("Please input integer only!");
                error.showAndWait();
            } else {
                while (rs.next()) {
                    int stockB6 = rs.getInt("Stock");
                    int total = stockB6 + frmTxtfieldBurger6;
                    if (total <= 1000) {
                        pst = conn.prepareStatement("UPDATE Inventory SET Stock=? where FoodName=?");
                        pst.setInt(1, total);
                        pst.setString(2, "Burger6");
                        pst.executeUpdate();
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Insufficient Capacity! Max = 1000!");
                        error.showAndWait();
                    }
                }
            }
            //st.close();
            updateTable();
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            if (txtfieldBurger6.getText().isBlank()) {
                error.setContentText("The field is empty!");
            } else {
                error.setContentText("Please input integer only!");
            }
            error.showAndWait();
        }
        txtfieldBurger6.clear();
    }

    @FXML
    void btnBackPushed(ActionEvent event) throws IOException {
        Parent pToAdmin = FXMLLoader.load(getClass().getResource("Admin GUI.fxml"));
        Stage stToAdmin = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToAdmin = new Scene(pToAdmin);
        stToAdmin.setScene(scToAdmin);
        stToAdmin.show();
    }

    @FXML
    void btnNextPushed(ActionEvent event) throws IOException{
        Parent pToCustomer = FXMLLoader.load(getClass().getResource("Customer GUI.fxml"));
        Stage stToCustomer = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scToCustomer = new Scene(pToCustomer);
        stToCustomer.setScene(scToCustomer);
        stToCustomer.show();
    }

}

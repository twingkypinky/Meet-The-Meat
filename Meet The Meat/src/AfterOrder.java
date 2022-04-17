import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AfterOrder {
    Connection conn;

    @FXML
    private TextField stringAddress;

    @FXML
    private TextField stringCity;

    @FXML
    private TextField stringFullName;

    @FXML
    private TextField stringPhone;

    @FXML
    private TextField tfItemAfterOrder;

    @FXML
    private TextField tfQtyAfterOrder;

    @FXML
    private TextField tfTotalAfterOrder;
    
    ObservableList<MenuItem> orders = Data.getOrderData();

    public void initialize() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

            String sql = "SELECT FullName, Address, City, Phone FROM Customer ORDER BY CustomerID DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                stringFullName.setText(rs.getString("FullName"));
                stringAddress.setText(rs.getString("Address"));
                stringCity.setText(rs.getString("City"));
                stringPhone.setText(rs.getString("Phone"));
                tfTotalAfterOrder.setText("" + Data.getTotalPriceProperty().intValue());
                tfQtyAfterOrder.setText("" + Data.getTotal());
                orders.forEach((orders) -> {tfItemAfterOrder.appendText(orders.getName() + ", ");});

            }

        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Error! Please contact Customer Service!");
            error.showAndWait();
        }
    }

    @FXML
    void tfItemAfterOrder(ActionEvent event) {

    }

    @FXML
    void tfQtyAfterOrder(ActionEvent event) {

    }

    @FXML
    void tfTotalAfterOrder(ActionEvent event) {

    }

}

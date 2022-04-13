import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    Connection conn;
    
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
                } else if (result.get() == ExitPage) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");

                        PreparedStatement pst;
                        pst = conn.prepareStatement("DELETE FROM Customer ORDER BY CustomerID DESC LIMIT 1");
                        pst.executeUpdate();
                    
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                        apPayment.getChildren().setAll(pane);
                    
                    } catch (Exception e) {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setTitle("Error Dialog");
                        error.setHeaderText("An Error Has Occurred");
                        error.setContentText("Error!");
                        error.showAndWait();
                    }
                } else if (result.get() == ContinueToPay){
                    this.label.setText("You choose to continue payment!");
       }         
       }


    @FXML
    void btnPayNowPayment(ActionEvent event) throws IOException {
        
        // jika klik button Pay Now maka akan di alihkan ke page after order
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "240122");
            String sql = "SELECT CustomerID FROM Customer ORDER BY CustomerID DESC LIMIT 1";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            int CustID = 0; 
            PreparedStatement pst;
            PreparedStatement pst2;

            while (rs.next()) {
                CustID = rs.getInt("CustomerID");
            }
            rs.close();

            for (MenuItem order : Data.getOrderData()) {
                pst = conn.prepareStatement("INSERT INTO History (CustomerID, Item, Quantity, Price) VALUES (?, ?, ?, ?)");
                pst.setInt(1, CustID);
                pst.setString(2, order.getName());
                pst.setInt(3, order.getQty());
                pst.setInt(4, order.getPrice());
                pst.executeUpdate();

                pst2 = conn.prepareStatement("UPDATE Inventory SET Stock=Stock - ? WHERE FoodName= ?");
                pst2.setInt(1, order.getQty());
                pst2.setString(2, order.getName());
                pst2.executeUpdate();
            }

            AnchorPane pane = FXMLLoader.load(getClass().getResource("AfterOrder.fxml"));
            apPayment.getChildren().setAll(pane);
            
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setHeaderText("An Error Has Occurred");
            error.setContentText("Error! Please contact Customer Service!");
            error.showAndWait();
        }

    }

    @FXML
    void tfPhonePayment(ActionEvent event) {

    } 


}

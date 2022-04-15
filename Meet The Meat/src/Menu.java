import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

public class Menu implements Initializable {
    Connection conn;
    PreparedStatement pst;

    @FXML
    private AnchorPane apMenu;

    @FXML
    private Button btnAdd1Menu;

    @FXML
    private Button btnAdd2Menu;

    @FXML
    private Button btnAdd3Menu;

    @FXML
    private Button btnAdd4Menu;

    @FXML
    private Button btnAdd5Menu;

    @FXML
    private Button btnAdd6Menu;

    @FXML
    private Button btnBackMenu;

    @FXML
    private Button btnBurgerMenu;

    @FXML
    private Button btnKeranjang;

    @FXML
    private TextField harga1;

    @FXML
    private TextField harga2;

    @FXML
    private TextField harga3;

    @FXML
    private TextField harga4;

    @FXML
    private TextField harga5;

    @FXML
    private TextField harga6;

    @FXML
    private TextField tfBurger1;

    @FXML
    private TextField tfBurger2;

    @FXML
    private TextField tfBurger3;

    @FXML
    private TextField tfBurger4;

    @FXML
    private TextField tfBurger5;

    @FXML
    private TextField tfBurger6;

    @FXML
    private TextField tfJumlahAddMenu;

    @FXML
    void btnAdd1(ActionEvent event) {
        // ambil menu pertama
        Node node = Data.get(1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Chicken Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }
    

    @FXML
    void btnAdd2(ActionEvent event) {
        //Node node = Data.get(2);
        //node.setQty(node.getQty() + 1);
        //Data.updateOrderData();
        Node node = Data.get(2);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Cheese Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }

    @FXML
    void btnAdd3(ActionEvent event) {
        //Node node = Data.get(3);
        //node.setQty(node.getQty() + 1);
        //Data.updateOrderData();
        Node node = Data.get(3);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Double Cheese Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }

    @FXML
    void btnAdd4(ActionEvent event) {
        //Node node = Data.get(4);
        //node.setQty(node.getQty() + 1);
        //Data.updateOrderData();
        Node node = Data.get(4);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Beef Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }
    @FXML
    void btnAdd5(ActionEvent event) {
        //Node node = Data.get(5);
        //node.setQty(node.getQty() + 1);
        //Data.updateOrderData();
        Node node = Data.get(5);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Mozarella Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }

    @FXML
    void btnAdd6(ActionEvent event) {
        //Node node = Data.get(6);
        //node.setQty(node.getQty() + 1);
        //Data.updateOrderData();
        Node node = Data.get(6);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/burgerapp", "root", "password");

            String sql = "SELECT Stock FROM Inventory WHERE FoodName='Crispy Chicken Burger'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int stck = rs.getInt("Stock");

                if (node.getQty() < stck) {
                    // tambah jumlah pesanan
                    node.setQty(node.getQty() + 1);
                    // update data
                    Data.updateOrderData();
                } else {
                    if (stck <= 1000) {
                        pst = conn.prepareStatement("SELECT Inventory SET Stock=? WHERE >= Stock=?");
                        pst.setInt(1, stck);
                        pst.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("STOCK HABIS");
            error.setHeaderText("Uhm.. Sorry Out Of Stock :) ");
            error.setContentText("You Can Choose Another Menu!");
            error.showAndWait();
        
        }
        }

    @FXML
    void btnBackMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("HalamanUtama.fxml"));
        apMenu.getChildren().setAll(pane);


    }

    @FXML
    void btnBurger(ActionEvent event) {

    }

    @FXML
    void btnKeranjang(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("OrderNew.fxml"));
        apMenu.getChildren().setAll(pane);
    }

    @FXML
    void harga1(ActionEvent event) {

    }

    @FXML
    void harga2(ActionEvent event) {

    }

    @FXML
    void harga3(ActionEvent event) {

    }

    @FXML
    void harga4(ActionEvent event) {

    }

    @FXML
    void harga5(ActionEvent event) {

    }

    @FXML
    void harga6(ActionEvent event) {

    }

    @FXML
    void tfBurger1(ActionEvent event) {

    }

    @FXML
    void tfBurger2(ActionEvent event) {

    }

    @FXML
    void tfBurger3(ActionEvent event) {

    }

    @FXML
    void tfBurger4(ActionEvent event) {

    }

    @FXML
    void tfBurger5(ActionEvent event) {

    }

    @FXML
    void tfBurger6(ActionEvent event) {

    }

    @FXML
    void tfJumlahAddMenu(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        // set text dari textfield jenis dan harga burger
        tfBurger1.setText(Data.get(1).getName());
        harga1.setText("" + Data.get(1).getPrice());
        tfBurger2.setText(Data.get(2).getName());
        harga2.setText("" + Data.get(2).getPrice());
        tfBurger3.setText(Data.get(3).getName());
        harga3.setText("" + Data.get(3).getPrice());
        tfBurger4.setText(Data.get(4).getName());
        harga4.setText("" + Data.get(4).getPrice());
        tfBurger5.setText(Data.get(5).getName());
        harga5.setText("" + Data.get(5).getPrice());
        tfBurger6.setText(Data.get(6).getName());
        harga6.setText("" + Data.get(6).getPrice());
        // bind properti jumlah pesanan dengan textfield jumlah pesanan sehingga terupdate secara otomatis
        tfJumlahAddMenu.textProperty().bindBidirectional(Data.getTotalProperty(), new NumberStringConverter());
    }

}



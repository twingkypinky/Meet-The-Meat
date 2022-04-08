import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

public class Menu implements Initializable {

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
        // tambah jumlah pesanan
        node.setQty(node.getQty() + 1);
        // update data
        Data.updateOrderData();
    }


    @FXML
    void btnAdd2(ActionEvent event) {
        Node node = Data.get(2);
        node.setQty(node.getQty() + 1);
        Data.updateOrderData();

    }

    @FXML
    void btnAdd3(ActionEvent event) {
        Node node = Data.get(3);
        node.setQty(node.getQty() + 1);
        Data.updateOrderData();

    }

    @FXML
    void btnAdd4(ActionEvent event) {
        Node node = Data.get(4);
        node.setQty(node.getQty() + 1);
        Data.updateOrderData();

    }

    @FXML
    void btnAdd5(ActionEvent event) {
        Node node = Data.get(5);
        node.setQty(node.getQty() + 1);
        Data.updateOrderData();

    }

    @FXML
    void btnAdd6(ActionEvent event) {
        Node node = Data.get(6);
        node.setQty(node.getQty() + 1);
        Data.updateOrderData();

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



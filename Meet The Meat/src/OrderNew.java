import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.NumberStringConverter;

public class OrderNew implements Initializable{

    MenuItem selected;

    @FXML
    private AnchorPane apOrderNew;

    @FXML
    private Button btnAddMore;

    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnKuranginBarang;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPlusBarang;

    @FXML
    private TableColumn<MenuItem, String> tcItem;

    @FXML
    private TableColumn<MenuItem, Integer> tcPrice;

    @FXML
    private TableColumn<MenuItem, Integer> tcQTY;

    @FXML
    private TextField tfNotes;

    @FXML
    private TextField tfTotal;

    @FXML
    private TableView<MenuItem> tvOrder;

    @FXML
    void btnAddMore(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        apOrderNew.getChildren().setAll(pane);
    }

    @FXML
    void btnBack(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        apOrderNew.getChildren().setAll(pane);
    }

    // fungsi yg dijalankan ketika tombol kurang diklik
    @FXML
    void btnKuranginBarang(ActionEvent event) {
        if (selected != null) {
            // jika terdapat item yg dipilih, maka kurangi qty dari item tersebut
            int id = selected.getId();
            Node node = Data.get(id);
            node.setQty(node.getQty() - 1);
            Data.updateOrderData();
        }
    }

    @FXML
    void btnOrder(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Address.fxml"));
        apOrderNew.getChildren().setAll(pane);


    }

    // fungsi yang dijalankan ketika tombol tambah diklik
    @FXML
    void btnPlusBarang(ActionEvent event) {
        if (selected != null) {
            // jika terdapat item yg dipilih, maka tambah qty dari item tersebut
            int id = selected.getId();
            Node node = Data.get(id);
            node.setQty(node.getQty() + 1);
            Data.updateOrderData();
        }
    }

    @FXML
    void tcItem(ActionEvent event) {

    }

    @FXML
    void tcPrice(ActionEvent event) {

    }

    @FXML
    void tcQTY(ActionEvent event) {

    }

    @FXML
    void tfNotes(ActionEvent event) {

    }

    @FXML
    void tfTotal(ActionEvent event) {

    }

    @FXML
    void tvOrder(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // tampilkan data dari observablelist pada tableview
        tcItem.setCellValueFactory(new PropertyValueFactory<MenuItem, String>("name"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<MenuItem, Integer>("price"));
        tcQTY.setCellValueFactory(new PropertyValueFactory<MenuItem, Integer>("qty"));
        tvOrder.setItems(Data.getOrderData());
        
        
        tfTotal.textProperty().bindBidirectional(Data.getTotalPriceProperty(), new NumberStringConverter());

        // disable tombol tambah dan kurang di awal
        btnPlusBarang.setDisable(true);
        btnKuranginBarang.setDisable(true);

        tvOrder.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // jika ada item yg dipilih pada tabel, maka simpan pada var selected;
                selected = (MenuItem) newSelection;
                // enable tombol
                btnPlusBarang.setDisable(false);
                btnKuranginBarang.setDisable(false);
            } else {
                btnPlusBarang.setDisable(true);
                btnKuranginBarang.setDisable(true);
            }
        });
    }
}
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class App extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Inventory GUI.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root,586,646);
        stage.setScene(scene);
        stage.setTitle(" Meet The Meat ");
        stage.show();
    }
    public static void main(String[] args) {
        initData();
        Application.launch(args);
    }

    private static void initData() {
        // inisialisasi data burger
        Data.insert("Chicken Burger", 10000);
        Data.insert("Cheese Burger", 12000);
        Data.insert("Double Cheese Burger", 16000);
        Data.insert("Beef Burger", 18000);
        Data.insert("Mozarella Burger", 16000);
        Data.insert("Crispy Chicken Burger", 18000);
    }
}

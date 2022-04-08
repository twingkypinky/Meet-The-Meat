import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

// class untuk isi dari observablelist
public class MenuItem {
    private final IntegerProperty id;
    private final StringProperty name;
    private final IntegerProperty price;
    private final IntegerProperty qty;

    public MenuItem() {
        this(0, null, 0, 0);
    }

    public MenuItem(int id, String name, int price, int qty) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.qty = new SimpleIntegerProperty(qty);
    }

    public int getId() {
        return id.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public IntegerProperty getIdProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public StringProperty getNameProperty() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }
    
    public void setPrice(int price) {
        this.price.set(price);
    }
    
    public IntegerProperty getPriceProperty() {
        return price;
    }

    public int getQty() {
        return qty.get();
    }
    
    public void setQty(int qty) {
        this.qty.set(qty);
    }
    
    public IntegerProperty getQtyProperty() {
        return qty;
    }
}


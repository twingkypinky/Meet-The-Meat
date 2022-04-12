public class history2 {
    int OrderNumber;
    int CustomerID;
    String Item;
    int QTY;
    int price;

    public history2(int OrderNumber, int CustomerID, String Item, int QTY, int price) {
        this.OrderNumber = OrderNumber;
        this.CustomerID = CustomerID;
        this.Item = Item;
        this.QTY = QTY;
        this.price = price;
    }

    public history2(String string, int i, int j) {
    }

    public void setOrderNumber(int OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setItem(String Item) {
        this.Item = Item;

    }
    public String getItem() {
        return Item;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public int getQTY() {
        return QTY;
    }

    public void setPrice(int price) {
        this.price= price;
    }

    public int getPrice() {
        return price;
    }

}
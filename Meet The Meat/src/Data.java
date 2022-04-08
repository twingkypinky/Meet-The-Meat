import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// class data untuk mengelola data
public class Data {
    // head dari linked list
    private static Node head = null;
    // tail dari linked list
    private static Node tail = null;
    // untuk menyimpan id terakhir
    private static int lastId = 0;

    // total (jumlah pesanan) dan totalPrice (total harga)
    // menggunakan IntegerProperty untuk binding dengan UI
    // sehingga jika nilainya diubah data pada UI
    // juga langsung berubah
    private static final IntegerProperty total = new SimpleIntegerProperty(0);
    private static final IntegerProperty totalPrice = new SimpleIntegerProperty(0);

    // observable list untuk model dari tableview
    // perubahan pada list langsung berefek pada tableview
    private static ObservableList<MenuItem> orderData = FXCollections.observableArrayList();

    // fungsi untuk mengecek apakah linked list kosong
    public static boolean isEmpty() {
        return head == null;
    }

    // fungsi untuk menambahkan data di akhir linked list
    public static void insert(String name, int price) {
        Node node = new Node(++lastId, name, price, 0);
        if( isEmpty() )
            head = node;
        else{
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    // fungsi untuk mengambil node dengan id tertentu
    public static Node get(int id) {
        if (lastId < id) {
            return null;
        }

        if (id - head.getId() < tail.getId() - id) {
            Node tmp = head;
            while(tmp != null) {
                if (tmp.getId() == id ) return tmp;
                tmp = tmp.getNext();
            }
        }
        else {
            Node tmp = tail;
            while(tmp != null) {
                if (tmp.getId() == id ) return tmp;
                tmp = tmp.getPrev();
            }
        }
        return null;
    }

    // fungsi untuk mengupdate data pesanan
    // baik jumlah pesanan, total harga, maupun list pesanan
    public static void updateOrderData() {
        Node tmp = head;
        // mereset data terlebih dahulu
        orderData.clear();
        total.set(0);
        totalPrice.set(0);
        // traversal pada linked list menu
        while(tmp != null) {
            // jika menunya memiliki qty lebih dari 0
            if (tmp.getQty() > 0) {
                // tambahkan ke observable list untuk ditampilkan pada tableview
                MenuItem mi = new MenuItem(tmp.getId(), tmp.getName(), tmp.getPrice(), tmp.getQty());
                orderData.add(mi);
                // tambahkan jumlah pesanan
                total.set(total.get() + mi.getQty());
                // tambahkan jumlah harga
                totalPrice.set(totalPrice.get() + (mi.getPrice() * mi.getQty())); 
            }
            tmp = tmp.getNext();
        }
    }

    public static ObservableList<MenuItem> getOrderData() {
        return orderData;
    }

    public static int getTotal() {
        return total.get();
    }

    public static int getTotalPrice() {
        return totalPrice.get();
    }

    public static IntegerProperty getTotalProperty() {
        return total;
    }

    public static IntegerProperty getTotalPriceProperty() {
        return totalPrice;
    }
}


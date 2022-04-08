// Class node untuk linked list
public class Node {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Node next;
    private Node prev;

    public Node(int id, String name, int price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}


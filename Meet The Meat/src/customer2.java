

public class customer2 {
   /* public SimpleIntegerProperty customerID = new SimpleIntegerProperty();
    public SimpleStringProperty fullName = new SimpleStringProperty();
    public SimpleStringProperty address = new SimpleStringProperty();
    public SimpleStringProperty city = new SimpleStringProperty();
    public SimpleStringProperty phone = new SimpleStringProperty();

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String stringfullname) {
        fullName.set(stringfullname);
    
    }*/
    int customerID;
    String fullName;
    String address;
    String city;
    String phone;

    public customer2(int customerID, String fullname, String address, String city, String phone) {
        this.customerID = customerID;
        this.fullName = fullname;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public int getcustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getfullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getaddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getcity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getphone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

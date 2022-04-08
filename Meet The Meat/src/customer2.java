
public class customer2 {
    int customerID;
    String fullName;
    String address;
    String city;
    String phone;

    public customer2(int customerID, String fullName, String address, String city, String phone) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    
}

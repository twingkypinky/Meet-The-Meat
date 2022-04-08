public class inventory2 {
    String foodName;
    int price;
    int stock;

    public inventory2(String foodName, int price, int stock) {
        this.foodName = foodName;
        this.price = price;
        this.stock = stock;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

}

package lcherechanska.familybudget.bean;

import java.util.Date;

/**
 * Created by lcherechanska on 25.1.2016 г..
 */
public class Expense {

    private int id;
    private Date date;
    private int price;
    private String description;
    private String category;
    private String shop;
    private String payFrom;

    public Expense() {
    }

    public Expense(int id, Date date, int price, String description) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.description = description;
        this.category = category;
        this.shop = shop;
        this.payFrom = payFrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getPayFrom() {
        return payFrom;
    }

    public void setPayFrom(String payFrom) {
        this.payFrom = payFrom;
    }

    public String toString() {
        return "Expense [id=" + id + ", date= " + date + ", price=" + price + ", description" + description + "]";
    }

}

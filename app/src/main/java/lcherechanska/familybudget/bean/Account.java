package lcherechanska.familybudget.bean;

import java.util.Date;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */
public class Account {

    private int id;
    private String name;
    private String description;
    private int amount;
    private int currency;
    private int type;
    private Date date;

    public Account(int id, String name, String description, int amount, int currency, int type, Date date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

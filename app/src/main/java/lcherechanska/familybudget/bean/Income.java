package lcherechanska.familybudget.bean;

import java.sql.Date;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */
public class Income {

    private int id;
    private String name;
    private String description;
    private int amount;
    private boolean repeatIncome;
    private Date dateOfIncome;

    public Income(int id, String name, String description, int amount, boolean repeatIncome, Date dateOfIncome) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.repeatIncome = repeatIncome;
        this.dateOfIncome = dateOfIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isRepeatIncome() {
        return repeatIncome;
    }

    public void setRepeatIncome(boolean repeatIncome) {
        this.repeatIncome = repeatIncome;
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }
}

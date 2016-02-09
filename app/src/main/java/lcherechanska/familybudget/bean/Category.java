package lcherechanska.familybudget.bean;

/**
 * Created by lcherechanska on 4.2.2016 г..
 */
public class Category {

    private int id;
    private String name;
    private int parentCategoryId;
    private boolean isParent;

    public Category(int id, String name, boolean isParent) {
        this.id = id;
        this.name = name;
        this.isParent = isParent;
    }

    public Category(int id, String name, int parentCategoryId, boolean isParent) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
        this.isParent = isParent;
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

    public boolean isParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

}

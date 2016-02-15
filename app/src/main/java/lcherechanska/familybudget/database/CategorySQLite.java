package lcherechanska.familybudget.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import lcherechanska.familybudget.bean.Category;
import lcherechanska.familybudget.utils.Constants;

/**
 * Created by lcherechanska on 4.2.2016 г..
 */
public class CategorySQLite extends SQLiteOpenHelper {

    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String CATEGORY_COLUMN_ID = "id";
    public static final String CATEGORY_COLUMN_NAME = "name";
    public static final String CATEGORY_COLUMN_PARENT_ID = "parent_id";
    public static final String CATEGORY_COLUMN_IS_PARENT = "isParent";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE "
                    + CATEGORY_TABLE_NAME +
                    "("
                    + CATEGORY_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + CATEGORY_COLUMN_NAME + " TEXT,"
                    + CATEGORY_COLUMN_PARENT_ID + " INTEGER,"
                    + CATEGORY_COLUMN_IS_PARENT + " INTEGER DEFAULT 0" +
                    ")";

    public CategorySQLite(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        insertOnCreate();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE_NAME);
        onCreate(db);
    }

    public void insertOnCreate() {
        SQLiteDatabase db = this.getWritableDatabase();

        Category category = new Category();
        category.setName("Храна");
        category.setIsParent(true);

        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY_COLUMN_NAME, category.getName());
        contentValues.put(CATEGORY_COLUMN_IS_PARENT, category.isParent());

        db.insert(CATEGORY_TABLE_NAME, null, contentValues);

        category = new Category();
        category.setName("Обяд");
        category.setIsParent(false);
        category.setParentCategoryId(1);

        contentValues = new ContentValues();
        contentValues.put(CATEGORY_COLUMN_NAME, category.getName());
        contentValues.put(CATEGORY_COLUMN_PARENT_ID, category.getParentCategoryId());
        contentValues.put(CATEGORY_COLUMN_IS_PARENT, category.isParent());

        db.insert(CATEGORY_TABLE_NAME, null, contentValues);

    }

    public List<Category> getAllCategory() {

        List<Category> categoryList = new ArrayList<Category>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + CATEGORY_TABLE_NAME, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                categoryList.add(category);
            } while (cursor.moveToNext());

        }
        return categoryList;
    }
}

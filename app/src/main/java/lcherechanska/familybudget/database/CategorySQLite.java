package lcherechanska.familybudget.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lcherechanska.familybudget.utils.Constants;

/**
 * Created by lcherechanska on 4.2.2016 г..
 */
public class CategorySQLite extends SQLiteOpenHelper {

    public static final String EXPENSE_TABLE_NAME = "category";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_NAME = "name";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE "
                    + EXPENSE_TABLE_NAME +
                    "("
                    + EXPENSE_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + EXPENSE_COLUMN_NAME + " TEXT," +
                    ")";

    public CategorySQLite(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXPENSE_TABLE_NAME);
        onCreate(db);
    }
}

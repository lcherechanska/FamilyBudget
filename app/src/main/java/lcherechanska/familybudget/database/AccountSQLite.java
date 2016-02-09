package lcherechanska.familybudget.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lcherechanska.familybudget.utils.Constants;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */
public class AccountSQLite extends SQLiteOpenHelper {

    public static final String EXPENSE_TABLE_NAME = "account";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_NAME = "name";
    public static final String EXPENSE_COLUMN_DESCRIPTION = "description";
    public static final String EXPENSE_COLUMN_AMOUNT = "amount";
    public static final String EXPENSE_COLUMN_REPEAT_INCOME = "currency";
    public static final String EXPENSE_COLUMN_TYPE = "type";
    public static final String EXPENSE_COLUMN_DATE_INCOME = "date";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE "
                    + EXPENSE_TABLE_NAME +
                    "("
                    + EXPENSE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + EXPENSE_COLUMN_NAME + " TEXT,"
                    + EXPENSE_COLUMN_DESCRIPTION + " TEXT,"
                    + EXPENSE_COLUMN_AMOUNT + " INTEGER,"
                    + EXPENSE_COLUMN_REPEAT_INCOME + " INTEGER DEFAULT 0,"
                    + EXPENSE_COLUMN_DATE_INCOME + " DATE," +
                    ")";


    public AccountSQLite(Context context) {
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

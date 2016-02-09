package lcherechanska.familybudget.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lcherechanska.familybudget.utils.Constants;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */
public class IncomeSQLite extends SQLiteOpenHelper {

    public static final String EXPENSE_TABLE_NAME = "account";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_NAME = "name";
    public static final String EXPENSE_COLUMN_DESCRIPTION = "description";
    public static final String EXPENSE_COLUMN_AMOUNT = "amount";
    public static final String EXPENSE_COLUMN_CURRENCY = "currency";
    public static final String EXPENSE_COLUMN_TYPE = "type";
    public static final String EXPENSE_COLUMN_DATE = "date";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE "
                    + EXPENSE_TABLE_NAME +
                    "("
                    + EXPENSE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + EXPENSE_COLUMN_NAME + " TEXT,"
                    + EXPENSE_COLUMN_DESCRIPTION + " TEXT,"
                    + EXPENSE_COLUMN_AMOUNT + " NUMBER,"
                    + EXPENSE_COLUMN_CURRENCY + " TEXT,"
                    + EXPENSE_COLUMN_TYPE + " TEXT,"
                    + EXPENSE_COLUMN_DATE + " DATE," +
                    ")";


    public IncomeSQLite(Context context) {
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

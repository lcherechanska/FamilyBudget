package lcherechanska.familybudget.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lcherechanska.familybudget.bean.Expense;
import lcherechanska.familybudget.utils.Constants;

/**
 * Created by lcherechanska on 25.1.2016 г..
 */
public class ExpenseSQLite extends SQLiteOpenHelper {

    public static final String EXPENSE_TABLE_NAME = "expense";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_DATE = "date";
    public static final String EXPENSE_COLUMN_PRICE = "price";
    public static final String EXPENSE_COLUMN_DESCRIPTION = "description";
    public static final String EXPENSE_COLUMN_CATEGORY = "category";
    public static final String EXPENSE_COLUMN_SHOP = "shop";
    public static final String EXPENSE_COLUMN_PAYFROM = "payfrom";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE "
                    + EXPENSE_TABLE_NAME +
                    "("
                    + EXPENSE_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + EXPENSE_COLUMN_DATE + " DATE,"
                    + EXPENSE_COLUMN_PRICE + " NUMBER, "
                    + EXPENSE_COLUMN_DESCRIPTION + " TEXT"
                    + EXPENSE_COLUMN_CATEGORY + " TEXT"
                    + EXPENSE_COLUMN_SHOP + " TEXT"
                    + EXPENSE_COLUMN_PAYFROM + " TEXT" +
                    ")";

    public ExpenseSQLite(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    public ExpenseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constants.DATABASE_NAME, factory, version);
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

    public boolean insertExpense(Expense expense) {

        Log.d("insert Expense", expense.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EXPENSE_COLUMN_DATE, expense.getDate().toString());
        values.put(EXPENSE_COLUMN_PRICE, expense.getPrice());
        values.put(EXPENSE_COLUMN_DESCRIPTION, expense.getDescription());

        db.insert(EXPENSE_TABLE_NAME, null, values);
        return true;
    }

    public Expense getExpense(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + EXPENSE_TABLE_NAME + "WHERE ID = " + id, null);

        if (cursor != null)
            cursor.moveToFirst();

        Expense expense = new Expense();
        expense.setId(cursor.getInt(0));
        //expense.setDate(cursor.getColumnIndex("1"));
        expense.setPrice(cursor.getInt(2));
        expense.setDescription(cursor.getString(3));
        expense.setCategory(cursor.getString(4));
        expense.setShop(cursor.getString(5));
        expense.setPayFrom(cursor.getString(6));

        return expense;
    }

    public List<Expense> getAllExpense() {

        List<Expense> expenseList = new ArrayList<Expense>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + EXPENSE_TABLE_NAME, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense(Integer.parseInt(cursor.getString(0)),
                        new Date(),
                        Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3));
                expenseList.add(expense);
            } while (cursor.moveToNext());

        }
        return expenseList;
    }
}

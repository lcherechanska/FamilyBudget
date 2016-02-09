package lcherechanska.familybudget.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.sql.Date;

import lcherechanska.familybudget.R;
import lcherechanska.familybudget.bean.Expense;
import lcherechanska.familybudget.database.ExpenseSQLite;
import lcherechanska.familybudget.utils.DatePickerFragment;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void saveExpense(View view) {

        EditText editDate = (EditText) findViewById(R.id.input_date);
        Date date = Date.valueOf(editDate.getText().toString());

        EditText editPrice = (EditText) findViewById(R.id.input_price);
        int price = Integer.parseInt(editPrice.getText().toString());

        EditText editDescription = (EditText) findViewById(R.id.input_description);
        String description = editDescription.getText().toString();

        Expense expense = new Expense();
        expense.setDate(date);
        expense.setPrice(price);
        expense.setDescription(description);

        ExpenseSQLite expenseSQLite = new ExpenseSQLite(this);
        expenseSQLite.insertExpense(expense);

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment((EditText) findViewById(R.id.input_date));
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}

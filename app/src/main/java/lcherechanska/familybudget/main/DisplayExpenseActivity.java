package lcherechanska.familybudget.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import lcherechanska.familybudget.R;
import lcherechanska.familybudget.bean.Expense;
import lcherechanska.familybudget.database.ExpenseSQLite;

public class DisplayExpenseActivity extends AppCompatActivity {

    TextView description;
    TextView price;
    private ExpenseSQLite expenseSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_expense);
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

        description = (TextView) findViewById(R.id.display_description);
        price = (TextView) findViewById(R.id.display_price);

        expenseSQLite = new ExpenseSQLite(this);

        List<Expense> expenseList = expenseSQLite.getAllExpense();

        Iterator<Expense> expenseIterator = expenseList.iterator();
        while (expenseIterator.hasNext()) {
            Expense expense = expenseIterator.next();
            description.setText(expense.getDescription());
            // price.setText(expense.getPrice());
            break;
        }
    }

}


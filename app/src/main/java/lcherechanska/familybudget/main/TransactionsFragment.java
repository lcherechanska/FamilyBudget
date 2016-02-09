package lcherechanska.familybudget.main;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import lcherechanska.familybudget.R;
import lcherechanska.familybudget.fragments.ExpenseActivity;
import lcherechanska.familybudget.fragments.IncomeActivity;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */

public class TransactionsFragment extends TabActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transaction);

        TabHost tabHost = getTabHost();

        // Expense tab
        Intent intentExpense = new Intent().setClass(this, IncomeActivity.class);
        TabHost.TabSpec tabSpecExpense = tabHost.newTabSpec("Expense");
        tabSpecExpense.setIndicator("Expense");
        tabSpecExpense.setContent(intentExpense);

        // Income tab
        Intent intentIncome = new Intent().setClass(this, ExpenseActivity.class);
        TabHost.TabSpec tabSpecIncome = tabHost.newTabSpec("Expense");
        tabSpecIncome.setIndicator("Income");
        tabSpecIncome.setContent(intentIncome);

        // add all tabs
        tabHost.addTab(tabSpecIncome);
        tabHost.addTab(tabSpecExpense);

        //set Windows tab as default (zero based)
        tabHost.setCurrentTab(0);

    }
}

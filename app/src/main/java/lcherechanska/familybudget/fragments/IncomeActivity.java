package lcherechanska.familybudget.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by lcherechanska on 5.2.2016 г..
 */
public class IncomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setTextSize(25);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setText("This Is Tab2 Activity 2");

        setContentView(tv);
    }
}

package lcherechanska.familybudget.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by lcherechanska on 1.2.2016 г..
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private EditText dateView;

    public DatePickerFragment(EditText editText) {
        this.dateView = editText;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateView.setText((dayOfMonth + "-" + monthOfYear + "-" + year).toString());
    }
}

package vn.edu.ntu.quangnghia.obsever;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

import static java.lang.reflect.Array.set;

public class mydatedalog {
    Context context;
    Calendar calendarDate;
    onMyDateChangeListener onMyDateChangeListener;

    public static interface onMyDateChangeListener{
        public void Dateupdate(Calendar newDate);
    }

    public mydatedalog(Context context, Calendar calendarDate, mydatedalog.onMyDateChangeListener onMyDateChangeListener) {
        this.context = context;
        this.calendarDate = calendarDate;
        this.onMyDateChangeListener = onMyDateChangeListener;
    }

    public void ShowDateDialog(){
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarDate.set(year,month,dayOfMonth);
                if(onMyDateChangeListener != null)
                    onMyDateChangeListener.Dateupdate(calendarDate);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,listener,
                calendarDate.get(calendarDate.YEAR),
                calendarDate.get(calendarDate.MONTH),
                calendarDate.get(calendarDate.DAY_OF_MONTH)
                );
        datePickerDialog.show();
    }
}

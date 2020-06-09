package vn.edu.ntu.quangnghia.obsever;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class mytimedalog {
    Context context;
    Calendar calendarTime;
    onMyTimeChangeListener onMyTimeChangeListener;

    public mytimedalog(Context context, Calendar calendarTime, mytimedalog.onMyTimeChangeListener onMyTimeChangeListener) {
        this.context = context;
        this.calendarTime = calendarTime;
        this.onMyTimeChangeListener = onMyTimeChangeListener;
    }

    public void ShowTimeDialog(){
        TimePickerDialog.OnTimeSetListener OnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendarTime.set(calendarTime.HOUR_OF_DAY,hourOfDay);
                calendarTime.set(calendarTime.MINUTE,minute);
                if (onMyTimeChangeListener != null)
                    onMyTimeChangeListener.Timeupdate(calendarTime);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, OnTimeSetListener,calendarTime.get(calendarTime.HOUR_OF_DAY),
                calendarTime.get(calendarTime.MINUTE),true);
        timePickerDialog.show();
    }

    public static interface onMyTimeChangeListener{
        public void Timeupdate(Calendar newTime);
    }
}

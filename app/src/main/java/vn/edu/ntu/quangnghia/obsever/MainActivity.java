package vn.edu.ntu.quangnghia.obsever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements mydatedalog.onMyDateChangeListener, mytimedalog.onMyTimeChangeListener {
    EditText edtdate, edttime;
    ImageView date, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        setView();
    }

    private void setView()
    {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatedalog mydatedalog = new mydatedalog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                mydatedalog.ShowDateDialog();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytimedalog mytimedalog = new mytimedalog(MainActivity.this,Calendar.getInstance(), MainActivity.this);
                mytimedalog.ShowTimeDialog();
            }
        });
    }

    private void addView()
    {
        edtdate = findViewById(R.id.edtdate);
        edttime = findViewById(R.id.edttime);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
    }

    @Override
    public void Dateupdate(Calendar newDate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newDate.get(newDate.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(newDate.MONTH) +1)
                .append("/")
                .append(newDate.get(newDate.YEAR));
        edtdate.setText(stringBuilder.toString());

    }

    @Override
    public void Timeupdate(Calendar newTime) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newTime.get(newTime.HOUR_OF_DAY))
                .append(":")
                .append(newTime.get(newTime.MINUTE));
        edttime.setText(stringBuilder.toString());
    }
}

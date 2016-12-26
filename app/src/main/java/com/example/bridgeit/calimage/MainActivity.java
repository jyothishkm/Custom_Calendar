package com.example.bridgeit.calimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.Calendar;
import java.util.Locale;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
Button save, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button)findViewById(R.id.btn_save);
        cancel = (Button)findViewById(R.id.btn_cancel);
        save.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);

        String[] monthNames = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        //get current month and year
       Calendar _calendar = Calendar.getInstance(Locale.getDefault());
      int  m_Month = _calendar.get(Calendar.MONTH) + 1;
        int mYear = _calendar.get(Calendar.YEAR);
        int  mDate = _calendar.get(Calendar.DATE);
       GridView calendarView = (GridView) findViewById(R.id.calendar);
        GridCalenderAdapter   adapter = new GridCalenderAdapter(MainActivity.this,m_Month, mYear, save, cancel);
        adapter.notifyDataSetChanged();
        calendarView.setAdapter(adapter);
    }
}

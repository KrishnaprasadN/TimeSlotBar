package com.kp.timeslotbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kp.timeslotbar.TimeSlotWidget.TimeSlotBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeSlotBar bar = (TimeSlotBar) findViewById(R.id.timeslotbar);

        bar.setBooking("1487150915693", "1487150915693");


    }
}

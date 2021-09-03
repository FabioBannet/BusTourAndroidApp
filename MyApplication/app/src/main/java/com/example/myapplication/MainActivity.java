package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String DIRECTION = "direction";
    public static final String SELECTED_DATE = "selected_date";

    private TextView tvDatePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Spinner spinnerDirection;
    private Button btnOrder;

    private String direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hide hateful bar from the top
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();

        setListeners();

        setAdapters();
    }


    private void initViews() {
        tvDatePicker = findViewById(R.id.tvDatePicker);
        spinnerDirection = findViewById(R.id.spinnerDirection);
        btnOrder = findViewById(R.id.btnOrder);
    }

    private void setListeners() {
        tvDatePicker.setOnClickListener(view -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    MainActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,
                    year,month,day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });

        mDateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;

            // put in order date field
            String m = month < 10? "0" + month : ""+month;
            String d = day < 10? "0" + day : ""+day;
            String y = ("" + year).substring(2);

            // draw date on the screen
            tvDatePicker.setText(m + "-" + d + "-" + y);
        };

        btnOrder.setOnClickListener(this::order);
        spinnerDirection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                direction = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                direction = null;
            }
        });
    }

    private void setAdapters() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this,
                        R.array.city_routes,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDirection.setAdapter(adapter);
    }

    private void order(View view) {

        String date = tvDatePicker.getText().toString();

        if(direction != null && !date.equals("")){
            Bundle bundle = new Bundle();
            bundle.putString(DIRECTION, direction);
            bundle.putString(SELECTED_DATE, date);

            Intent intent = new Intent(getBaseContext(), Order_Activity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

}
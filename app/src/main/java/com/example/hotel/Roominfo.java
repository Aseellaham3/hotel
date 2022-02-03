package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Roominfo extends AppCompatActivity {

    Calendar myCalendar;
    EditText editCheckin,editCheckout,roomnum;
    String Cardname, Cardnum,phone, Address,Gender;
    Button preview;
    Spinner spinnerType;
    String roomtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roominfo);

       Intent intent=getIntent();

        Cardname=intent.getStringExtra( "Cardname");
        Cardnum=intent.getStringExtra( "Cardnum");
        phone=intent.getStringExtra( "phone");
        Address=intent.getStringExtra( "Address");
        Gender=intent.getStringExtra( "Gender");



        myCalendar = Calendar.getInstance();

        editCheckin = (EditText) findViewById(R.id.Checkin);
        editCheckout = (EditText) findViewById(R.id.Checkout);
        spinnerType = findViewById(R.id.spinnerType);
        preview = findViewById(R.id.preview);
        roomnum =findViewById(R.id.roomnum);

        preview.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Roominfo.this, PreviewRoomInf.class);
                intent. putExtra( "Cardname", Cardname);
                intent. putExtra( "Cardnum", Cardnum);
                intent. putExtra( "phone", phone);
                intent. putExtra( "Address",Address);
                intent. putExtra( "roomtype",roomtype);
                intent. putExtra( "Checkin",editCheckin.getText().toString());
                intent. putExtra( "editCheckout",editCheckout.getText().toString());
                intent. putExtra( "roomnum",roomnum.getText().toString());
               // intent. putExtra( "Gender", Gender);

                startActivity(intent);
            }
            });

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthofYear,
                                  int dayofMonth) {
                /// TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthofYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth);
                updatelabel(myCalendar,editCheckin);
            }
        };
        editCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Roominfo.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthofYear,
                                  int dayofMonth) {
                /// TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthofYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayofMonth);
                updatelabel(myCalendar,editCheckout);
            }
        };
        editCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Roominfo.this, date2, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

                private void updatelabel(Calendar myCalendar, EditText editCheckin) {
                    String myFormat ="ww/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                    editCheckin.setText(sdf.format(myCalendar.getTime()));
        }
        }
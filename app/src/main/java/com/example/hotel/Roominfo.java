package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class Roominfo extends AppCompatActivity {

    //private lateinit var adapter: ArrayAdapter<*>

    public static final String RoomType = "RoomType";
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;
    public static final String FLAG = "FLAG";

    private Spinner editRoomType;

    Calendar myCalendar;
    EditText editCheckin,editCheckout,roomnum;
    String Cardname, Cardnum,phone, Address;

    Button preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roominfo);

        Intent intent=getIntent();

        Cardname=intent.getStringExtra( "Cardname");
        Cardnum=intent.getStringExtra( "Cardnum");
        phone=intent.getStringExtra( "phone");
        Address=intent.getStringExtra( "Address");
        // RoomType=intent.getStringExtra( "RoomType");

        editRoomType=findViewById(R.id.spinnerType);


        addToSpinner();
        setupSharedPref();
        checkPref();


        myCalendar = Calendar.getInstance();

        editCheckin = (EditText) findViewById(R.id.Checkin);
        editCheckout = (EditText) findViewById(R.id.Checkout);
        editRoomType = findViewById(R.id.spinnerType);
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
                intent. putExtra( "roomtype",RoomType);
                intent. putExtra( "Checkin",editCheckin.getText().toString());
                intent. putExtra( "editCheckout",editCheckout.getText().toString());
                intent. putExtra( "roomnum",roomnum.getText().toString());
                // intent. putExtra( "Gender", Gender);

                int userChoice = editRoomType.getSelectedItemPosition();
                editor.putInt(RoomType,userChoice);
                editor.putBoolean(FLAG,true);
                editor.commit();

                String Checkin = editCheckin.getText().toString();
                String Checkout = editCheckout.getText().toString();
                String roomnummber = roomnum.getText().toString();

                addRoom_info(Checkin, Checkout,roomnummber);

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

    private void addToSpinner(){
        String[] arraySpinner = new String[] {
                "Single Bed Room", "Double Bed Room","Triple Bed Room","Triple Bed Room","Quad Bed Room"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editRoomType.setAdapter(adapter);
    }

    private void setupSharedPref() {
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        editor=pref.edit();
    }

    private void checkPref() {
        boolean flag= pref.getBoolean(FLAG,false);
        if(flag)
        {
            int gender=pref.getInt(RoomType,-1);
            editRoomType.setSelection(gender);

        }
    }

    private void addRoom_info(String Checkin, String Checkout, String roomnum){
        String url = "http://192.168.1.105/Hotelapp/Room_info.php";
        RequestQueue queue = Volley.newRequestQueue(Roominfo.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(Roominfo.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Roominfo.this,
                        "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("Checkin", Checkin);
                params.put("Checkout", Checkout);
                params.put("roomnum", roomnum);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

    private void updatelabel(Calendar myCalendar, EditText editCheckin) {
        String myFormat ="ww/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editCheckin.setText(sdf.format(myCalendar.getTime()));
    }
}
package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

public class customerinfo extends AppCompatActivity {
    //    public static final String Gender = "Gender";
//    private Spinner spinner;
//    private SharedPreferences.Editor editor;
//    private SharedPreferences pref;
//    public static final String FLAG = "FLAG";

    EditText editcardname, editcardnum, editphone, editAddress;
    Spinner spinner;
    //String Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerinfo);
        Button btnSave = findViewById(R.id.button3);
        editcardname = findViewById(R.id.editcardname);
        editcardnum = findViewById(R.id.editcardnum);
        editphone = findViewById(R.id.editphone);
        editAddress = findViewById(R.id.editAddress);
        spinner = findViewById(R.id.spinner);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(customerinfo.this, Roominfo.class);
                intent.putExtra("Cardname", editcardname.getText().toString());
                intent.putExtra("Cardnum", editcardnum.getText().toString());
                intent.putExtra("phone", editphone.getText().toString());
                intent.putExtra("Address", editAddress.getText().toString());
                intent.putExtra("Gender", spinner.getAccessibilityClassName().toString());

              //  String Cardname, String Cardnum, String phone,String Address
                String Cardname = editcardname.getText().toString();
                String Cardnum = editcardnum.getText().toString();
                String phone = editphone.getText().toString();
                String Address = editAddress.getText().toString();

                addRoom_info(Cardname, Cardnum,phone,Address);

                startActivity(intent);


            }
        });
    }
    private void addRoom_info(String Cardname, String Cardnum, String phone,String Address){
        String url = "http://192.168.1.22/Hotelapp/customer_inf.php";
        RequestQueue queue = Volley.newRequestQueue(customerinfo.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(customerinfo.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(customerinfo.this,
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
                params.put("Cardname", Cardname);
                params.put("Cardnum", Cardnum);
                params.put("phone", phone);
                params.put("Address", Address);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }



}

//    private void setupSharedPref() {
//        pref = PreferenceManager.getDefaultSharedPreferences(this);
//        editor = pref.edit();
//    }
//
//    private void checkPref() {
//        boolean flag = pref.getBoolean(FLAG, false);
    //  if(flag)
//        {
//            String name= pref.getString(Name,"");
//
//
//            int gender=pref.getInt(Gender,-1);
//
//            editName.setText(name);
//
//            spinner.setSelection(gender);
//
//        }
    // }


    //public void btnonclicksave(View view) {
//        Intent n= new Intent( this,SecondActivity.class);
//        startActivity(n);
//
//        String name=editName.getText().toString();
//        String item =spinner.getSelectedItem().toString();
//
//        int userChoice = spinner.getSelectedItemPosition();
//        editor.putString(Name,name);
//        editor.putInt(Gender,userChoice);
//        editor.commit();
    //  }

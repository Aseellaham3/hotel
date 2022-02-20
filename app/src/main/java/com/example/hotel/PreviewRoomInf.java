package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class PreviewRoomInf extends AppCompatActivity {
    String Cardname, Cardnum,phone, Address,Gender;
    String Checkin,Checkout,roomnum,roomtype;

    Button Save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_room_inf);
        TextView textview=findViewById(R.id.textview1);
        Save = findViewById(R.id.Save);





        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                                  Cardname=intent.getStringExtra( "Cardname");
                 Cardnum=intent.getStringExtra( "Cardnum");
                 phone=intent.getStringExtra( "phone");
                 Address=intent.getStringExtra( "Address");
                 Gender=intent.getStringExtra( "Gender");
                 Checkin=intent.getStringExtra( "Checkin");
                 Checkout=intent.getStringExtra( "editCheckout");
                 roomnum=intent.getStringExtra( "roomnum");
                 roomtype=intent.getStringExtra( "roomtype");

                String  Cardname=intent.getStringExtra( "Cardname");
                String Cardnum=intent.getStringExtra( "Cardnum");
                String phone=intent.getStringExtra( "phone");
                String Address=intent.getStringExtra( "Address");
                String Gender=intent.getStringExtra( "Gender");
                String Checkin=intent.getStringExtra( "Checkin");
                String Checkout=intent.getStringExtra( "editCheckout");
                String roomnum=intent.getStringExtra( "roomnum");
                String roomtype=intent.getStringExtra( "roomtype");

                register_user(Cardname, Cardnum,phone,Address,Checkin,Checkout,roomnum);

                textview.setText(
                        "Cardname : "+Cardname+
                                "\nCardnumber : "+Cardnum+
                                "\nPhoneNo : "+phone+
                                "\nAddress : "+Address+
                                "\nGender : "+Gender+
                                "\nCheckin : "+Checkin+
                                "\nCheckout : "+Checkout+
                                "\nRoom of number : "+roomnum+
                                "\nRoom type : "+roomtype
                );






            }
        });
//        textview.setText(
//                        "Cardname : "+Cardname+
//                        "\nCardnumber : "+Cardnum+
//                        "\nPhoneNo : "+phone+
//                        "\nAddress : "+Address+
//                        "\nGender : "+Gender+
//                        "\nCheckin : "+Checkin+
//                        "\nCheckout : "+Checkout+
//                        "\nRoom of number : "+roomnum+
//                        "\nRoom type : "+roomtype
//        );

//        Intent intent=getIntent();
//        Cardname=intent.getStringExtra( "Cardname");
//        Cardnum=intent.getStringExtra( "Cardnum");
//        phone=intent.getStringExtra( "phone");
//        Address=intent.getStringExtra( "Address");
//        Gender=intent.getStringExtra( "Gender");
//        Checkin=intent.getStringExtra( "Checkin");
//        Checkout=intent.getStringExtra( "editCheckout");
//        roomnum=intent.getStringExtra( "roomnum");
//        roomtype=intent.getStringExtra( "roomtype");
//
//        textview.setText(
//                        "Cardname : "+Cardname+
//                        "\nCardnumber : "+Cardnum+
//                        "\nPhoneNo : "+phone+
//                        "\nAddress : "+Address+
//                        "\nGender : "+Gender+
//                        "\nCheckin : "+Checkin+
//                        "\nCheckout : "+Checkout+
//                        "\nRoom of number : "+roomnum+
//                        "\nRoom type : "+roomtype
//        );





    }

    private void register_user(String Cardname, String Cardnum, String phone,String Address  ,
                               String Checkin,String editCheckout, String roomnum){
        String url = "http://192.168.1.105/Hotelapp/registeruser.php";
        RequestQueue queue = Volley.newRequestQueue(PreviewRoomInf.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(PreviewRoomInf.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(PreviewRoomInf.this,
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
                // key and value pair to our parameters

    //String Cardname, String Cardnum, String phone,String Address,String Gender,String roomtype ,
                //                               String Checkin,String editCheckout, String roomnum)
                params.put("Cardname", Cardname);
                params.put("Cardnum", Cardnum);
                params.put("phone", phone);
                params.put("Address", Address);
               // params.put("Gender", Gender);
                //params.put("roomtype", roomtype);
                params.put("Checkin", Checkin);
                params.put("editCheckout", editCheckout);
                params.put("roomnum", roomnum);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }


    public void thanks(View view) {
        Intent intent = new Intent(this, thanks.class);
        startActivity(intent);
        finish();

    }
}
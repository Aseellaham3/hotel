package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class customerinfo extends AppCompatActivity {
    //    public static final String Gender = "Gender";
//    private Spinner spinner;
//    private SharedPreferences.Editor editor;
//    private SharedPreferences pref;
//    public static final String FLAG = "FLAG";

    EditText editcardname,editcardnum,editphone,editAddress;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerinfo);
        Button btnSave=findViewById(R.id.button3);
        editcardname=findViewById(R.id.editcardname);
        editcardnum=findViewById(R.id.editcardnum);
        editphone=findViewById(R.id.editphone);
        editAddress=findViewById(R.id.editAddress);
        spinner=findViewById(R.id.spinner);





        btnSave.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( customerinfo.this, Roominfo.class);
                intent. putExtra( "Cardname", editcardname.getText().toString());
                intent. putExtra( "Cardnum", editcardnum.getText().toString());
                intent. putExtra( "phone", editphone.getText().toString());
                intent. putExtra( "Address", editAddress.getText().toString());
                intent. putExtra( "Gender", spinner.getAccessibilityClassName().toString());

                startActivity(intent);




            }
            });
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
}

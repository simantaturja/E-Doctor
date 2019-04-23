package com.example.simanta.mydoctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.simanta.mydoctor.*;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Spinner hospital, department;
    Button search;
    private TextView textView;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hospital = (Spinner) findViewById(R.id.hospital_spinner);
        department = (Spinner) findViewById(R.id.department_spinner);
        search = (Button)   findViewById(R.id.search_btn);

        String[] hospitalList = getResources().getStringArray(R.array.hospital_arrays);
        String[] departmentList = getResources().getStringArray(R.array.department_arrays);
        final List<String> finalHospitalList = new ArrayList<>(Arrays.asList(hospitalList));
        final List<String> finalDepartmentList = new ArrayList<>(Arrays.asList(departmentList));



       /*ArrayAdapter <String> hospitalAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, hospitalList);
       hospital.setAdapter(hospitalAdapter);

       hospital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(MainActivity.this, hospital.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
               System.out.println(hospital.getSelectedItem().toString());
           }

           public void onNothingSelected(AdapterView<?> parent) {
               // TODO Auto-generated method stub

           }
       });*/




        ArrayAdapter <String> departmentAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, departmentList);
        department.setAdapter(departmentAdapter);

        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, department.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                System.out.println(department.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);

            }
        });



    }
}

package com.example.aitrc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_Result extends AppCompatActivity {

    private TextView count1;
    private TextView count2;

    private Button btnFirst, btnSecond, DataView;

    private int scoreFirst = 0;
    private int scoreSecond = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_result);

        // initializing textview
        count1 = (TextView) findViewById(R.id.count1);
        count2 = (TextView) findViewById(R.id.count2);

        // initializing button view
        btnFirst = (Button) findViewById(R.id.btnFirst);
        btnSecond = (Button) findViewById(R.id.btnSecond);
        DataView = (Button)  findViewById(R.id.DataView);

        // setting initial value to text view
        count1.setText(String.valueOf(0));
        count2.setText(String.valueOf(0));


        DataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // updating textview on button click
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreFirst++;
                count1.setText(String.valueOf(scoreFirst));
            }
        });

        // updating textview on button click
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreSecond++;
                count2.setText(String.valueOf(scoreSecond));
            }
        });
    }
}
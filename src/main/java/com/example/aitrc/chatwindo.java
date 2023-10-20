package com.example.aitrc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class chatwindo extends AppCompatActivity {

    String reciverimg, reciverUid, receiverName, SenderUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatwindo);

        receiverName = getIntent().getStringExtra("nameeee");
        receiverName = getIntent().getStringExtra("nameeee");
        receiverName = getIntent().getStringExtra("nameeee");
        receiverName = getIntent().getStringExtra("nameeee");

    }
}
package com.example.aitrc;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    Button backbutton2 , submit_data;

    private List<int[]> studentsResultsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        studentsResultsList = new ArrayList<>();

        // Retrieve selected options from the intent
        Intent intent = getIntent();
        int[] selectedOptions = intent.getIntArrayExtra("selectedOptions");

        // Store the results in the list
        studentsResultsList.add(selectedOptions);

        displayAllResults();
    }

    private void displayAllResults() {
        // Assuming you have a TextView with the id "resultTextView" to display the results
        TextView resultTextView = findViewById(R.id.resultTextView);

        StringBuilder resultBuilder = new StringBuilder();

        backbutton2 = findViewById(R.id.backbutton2);
        backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to UserMainActivity
                Intent intent = new Intent(AdminActivity.this, User_main.class);
                startActivity(intent);
            }
        });


        submit_data = findViewById(R.id.submit_data);
        submit_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(AdminActivity.this,R.style.dialoge);
                dialog.setContentView(R.layout.thankyou_layout);
                Button no,yes;
                yes = dialog.findViewById(R.id.yesbnt);
                no = dialog.findViewById(R.id.nobnt);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(AdminActivity.this,User_main.class);
                        startActivity(intent);
                        finish();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        for (int i = 0; i < studentsResultsList.size(); i++) {
            int[] studentResults = studentsResultsList.get(i);

            resultBuilder.append("Student").append(i + 1).append(" Results:\n");

            // Assuming questions start from 1
            for (int j = 0; j < studentResults.length; j++) {
                resultBuilder.append("Question").append(j + 1).append(": Option ").append(studentResults[j] + 1).append("\n");
            }

            resultBuilder.append("\n");
        }
        resultTextView.setText(resultBuilder.toString());
    }
}

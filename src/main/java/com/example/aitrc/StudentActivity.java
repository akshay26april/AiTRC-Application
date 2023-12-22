package com.example.aitrc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {
    TextView questionTextView;
    private RadioGroup radioGroup;
    private Button submitButton, backbutton1;
    private int currentQuestionIndex = 0;
    private int[] selectedOptions;
    private TextView total_question;

    // Replace with your actual questions and options


    private String[] question = {
            "Lectures are well planned and prepared",
            "Teacher teaches the subject in simple language.",
            "Teacher covers the syllabus points",
            "Teacher gives industrial knowledge apart from syllabus.",
            "Teacher repeats the point until everyone understood it.",
            "Teacher has good knowledge of the subject.",
            "Teacher uses PPTs, Videos, during teaching.",
            "Punctual and sincere in academic work.",
            "Teacher cares for academic and personal growth of students",
            // Add more questions as needed
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);

        selectedOptions = new int[question.length];
        displayQuestion();

        backbutton1 = findViewById(R.id.backbutton1);
        backbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this, User_main.class);
                startActivity(intent);
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOptionId = radioGroup.getCheckedRadioButtonId();

                if (selectedOptionId != -1) {
                    // Save the selected option for the current question
                    selectedOptions[currentQuestionIndex] = radioGroup.indexOfChild(findViewById(selectedOptionId));

                    // Move to the next question
                    currentQuestionIndex++;

                    // Check if all questions are answered
                    if (currentQuestionIndex < question.length) {
                        displayQuestion();
                    } else {
                        // All questions answered, move to AdminActivity
                        moveToAdminActivity();
                    }
                }
            }
        });
    }



    private void displayQuestion() {
        radioGroup.clearCheck();

        questionTextView = findViewById(R.id.question);
        questionTextView.setText(question[currentQuestionIndex]);

        // Set the question text
        RadioButton Average = findViewById(R.id.ans_A);
        RadioButton Above = findViewById(R.id.ans_B);
        RadioButton Good = findViewById(R.id.ans_C);
        RadioButton Excellent = findViewById(R.id.ans_D);

        Average.setText("Average");
        Above.setText("Above Average");
        Good.setText("Good");
        Excellent.setText("Excellent");

        // Update the question text
        // Replace with actual data retrieval for questions
        // You may use currentQuestionIndex to fetch the corresponding question
    }

    private void moveToAdminActivity() {
        Intent intent = new Intent(StudentActivity.this, AdminActivity.class);
        intent.putExtra("selectedOptions", selectedOptions);
        startActivity(intent);
        finish();
    }
}

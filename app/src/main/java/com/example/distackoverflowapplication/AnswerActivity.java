package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.distackoverflowapplication.api.Repository;

import java.util.List;

public class AnswerActivity extends AppCompatActivity {

    TextView isAccept;
    TextView answerText;
    TextView license;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        isAccept = findViewById(R.id.isaccept);
        answerText = findViewById(R.id.quesId);
        license = findViewById(R.id.lic);
        Intent i = getIntent();
        int quesId = i.getIntExtra("QuestionId",0);

        repository = new Repository();
        repository.getAnswerLiveData(quesId).observe(this, new Observer<List<Answers>>() {
            @Override
            public void onChanged(List<Answers> answers) {
                Answers ans = answers.get(0);
                isAccept.setText(ans.isAccepted()+"");
                answerText.setText(ans.getScore()+"");
                license.setText(ans.getContentLicense());

            }
        });
        

    }
}
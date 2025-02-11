package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.distackoverflowapplication.api.Repository;

import java.util.List;

public class AnswerActivity extends AppCompatActivity {

    TextView title2;
    TextView questionText;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        title2 = findViewById(R.id.title2);
        questionText = findViewById(R.id.questionbody);

        Intent i = getIntent();
        int quesId = i.getIntExtra("QuestionId",0);

        repository = new Repository();
        repository.getAnswerLiveData(quesId).observe(this, new Observer<List<Answers>>() {
            @Override
            public void onChanged(List<Answers> answers) {
                Answers ans = answers.get(0);
                title2.setText(ans.getTitle());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    questionText.setText(Html.fromHtml(ans.getQuestionBody(),Html.FROM_HTML_MODE_LEGACY));
                }else{
                    questionText.setText(Html.fromHtml(ans.getQuestionBody()));
                }

            }
        });
        

    }
}
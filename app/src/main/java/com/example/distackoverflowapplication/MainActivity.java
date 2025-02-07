package com.example.distackoverflowapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.distackoverflowapplication.api.Repository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    QuestionAdapter questionAdapter;
    ArrayList<Question> list;
    Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        repository = new Repository();
        questionAdapter = new QuestionAdapter(list);
        questionAdapter.setQuestionItemClickListener((view,position)->{
            int questionId = list.get(position).getQuestion_id();
            Intent i = new Intent(this,AnswerActivity.class);
            i.putExtra("QuestionId",questionId);
            startActivity(i);

        });

        recyclerView.setAdapter(questionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, new LinearLayoutManager(this).getOrientation()));

        repository.getMutableLiveData().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                list.clear();
                list.addAll(questions);
                questionAdapter.notifyDataSetChanged();
            }

        });



    }

    private void loadQuestion() {
    }


}
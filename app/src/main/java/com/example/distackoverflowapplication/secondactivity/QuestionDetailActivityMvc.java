package com.example.distackoverflowapplication.secondactivity;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.distackoverflowapplication.QuestionBody;
import com.example.distackoverflowapplication.R;

import java.util.ArrayList;

public class QuestionDetailActivityMvc extends AnswerView implements QuestionBodyViewMVCImp{

    TextView title2;
    TextView questionText;


    public QuestionDetailActivityMvc(LayoutInflater layoutInflater, ViewGroup container) {
        setRootView(layoutInflater.inflate(R.layout.activity_answer,container));
        title2 = findViewById(R.id.title2);
        questionText = findViewById(R.id.questionbody);

    }

    @Override
    public void bindQuestionBody(ArrayList<QuestionBody> questionBody) {
        QuestionBody ans = questionBody.get(0);
        title2.setText(ans.getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            questionText.setText(Html.fromHtml(ans.getQuestionBody(),Html.FROM_HTML_MODE_LEGACY));
        }else{
            questionText.setText(Html.fromHtml(ans.getQuestionBody()));
        }
    }
}

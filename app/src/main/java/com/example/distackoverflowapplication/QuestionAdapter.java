package com.example.distackoverflowapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

    ArrayList<Question> questionArrayList;
    QuestionItemClickListener questionItemClickListener;

    public QuestionAdapter(ArrayList<Question> questionArrayList) {
        this.questionArrayList = questionArrayList;
    }

    public void setQuestionItemClickListener(QuestionItemClickListener questionItemClickListener) {
        this.questionItemClickListener = questionItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView textView = holder.questionText;
        Question question = questionArrayList.get(position);
        textView.setText(question.getTitle());
    }

    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }

    public void addQuestion(Question question){
        questionArrayList.add(question);
        notifyDataSetChanged();
    }

    public void updateQuestionArray(ArrayList<Question> questions){
        questionArrayList.clear();
        questionArrayList.addAll(questions);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView questionText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionItem);

            questionText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Question question = questionArrayList.get(position);
                    questionItemClickListener.itemClick(question);
                }
            });
        }
    }
}

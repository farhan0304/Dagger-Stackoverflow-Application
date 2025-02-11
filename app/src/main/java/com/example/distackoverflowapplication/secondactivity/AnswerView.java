package com.example.distackoverflowapplication.secondactivity;

import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.example.distackoverflowapplication.mainui.ViewMVC;

public abstract class AnswerView implements ViewMVC {
    private View view;
    @Override
    public View getRootView() {
        return view.getRootView();
    }

    public void setRootView(View v){
        view = v;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(@IdRes int id){
        return (T) view.findViewById(id);
    }

    public Context getContext(){
        return getRootView().getContext();
    }

    public String getString(@StringRes int id){
        return getContext().getString(id);
    }

    public String getString(@StringRes int id, Object... formatArgs){
        return getContext().getString(id,formatArgs);
    }
}

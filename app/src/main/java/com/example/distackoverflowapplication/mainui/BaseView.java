package com.example.distackoverflowapplication.mainui;

import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

public abstract class BaseView<ListenerType> extends BaseObservable<ListenerType>{

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

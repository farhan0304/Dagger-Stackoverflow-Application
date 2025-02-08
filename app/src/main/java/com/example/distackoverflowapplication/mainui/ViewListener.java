package com.example.distackoverflowapplication.mainui;

public interface ViewListener<Listener_type> extends ViewMVC{

    void addNewListener(Listener_type listener);
    void removeListener(Listener_type listener);
}

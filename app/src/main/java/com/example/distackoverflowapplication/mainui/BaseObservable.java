package com.example.distackoverflowapplication.mainui;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseObservable<listener_type> implements ViewListener<listener_type> {

    private Set<listener_type> ListenersSet;

    public BaseObservable() {
        ListenersSet = Collections.newSetFromMap(new ConcurrentHashMap<listener_type,Boolean>(1));
    }


    @Override
    public final void addNewListener(listener_type listener) {
        ListenersSet.add(listener);
    }

    @Override
    public final void removeListener(listener_type listener) {
        ListenersSet.remove(listener);
    }

    public final Set<listener_type> getListeners(){
        return Collections.unmodifiableSet(ListenersSet);
    }

}

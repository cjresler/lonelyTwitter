package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by resler on 3/10/16.
 */
public interface MyObservable {
    //ArrayList<MyObserver> observers = new ArrayList<MyObserver>();
    public void registerObserver(MyObserver o);
    public void notifyObservers();
}

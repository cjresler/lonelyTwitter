package ca.ualberta.cs.lonelytwitter;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable, Parcelable, MyObservable {
    private String text;
    protected Date date;
    ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public Tweet(String tweet, Date date) throws TweetTooLongException {
        this.setText(tweet);
        this.date = date;
    }

    public Tweet(String tweet) throws TweetTooLongException {
        this.setText(tweet);
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TweetTooLongException {
        if (text.length() <= 140) {
            this.text = text;
            notifyObservers();
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + text;
    }

    public int describeContents() {
        return 0;
    }

    //http://stackoverflow.com/questions/7181526/how-can-i-make-my-custom-objects-be-parcelable codelogic 06-03-2016
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.text, this.date.toString()});
    }

    public Tweet(Parcel in) {
        String[] data = new String[2];

        in.readStringArray(data);
        this.text = data[0];
        this.date = new Date(Date.parse(data[1]));
    }

    public void registerObserver(MyObserver o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for(MyObserver o : observers){
            o.myNotify();
        }
    }
}

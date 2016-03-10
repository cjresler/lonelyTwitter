package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by joshua2 on 9/28/15.
 */
public class TweetTest extends ActivityInstrumentationTestCase2 implements MyObserver{

    boolean iWasNotified = false;

    public TweetTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testGetText() throws Exception {
        assertTrue(true); // should fail!
    }

    public void testSetText() throws Exception {

    }

    public void testGetDate() throws Exception {

    }

    public void testSetDate() throws Exception {

    }

    public void testIsImportant() throws Exception {

    }

    public void testToString() throws Exception {

    }

    public void testTweetTextChange() throws Exception{
        Tweet myTweet = new NormalTweet("My unset text");
        assertFalse(iWasNotified);
        myTweet.registerObserver(this);
        myTweet.setText("New set text. (To trigger observer!)");
        assertTrue(iWasNotified);
    }

    public void myNotify() {
        iWasNotified = true;
    }
}
package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Bundle extras = getIntent().getExtras();
        Tweet passedTweet = (Tweet) extras.getParcelable("Tweet");
        int tweetPosition = extras.getInt("TweetId");

        final EditText tweetText = (EditText) findViewById(R.id.editText_tweet);

        Button ok = (Button) findViewById(R.id.button_ok);
        Button cancel = (Button) findViewById(R.id.button_cancel);

        tweetText.setText(passedTweet.getText());

        Tweet mySelectedTweet = TweetList.getInstance().get(0);
        System.out.println("The text of the tweet was: " + mySelectedTweet);


        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO error check the tweet text later.
                String text = tweetText.toString();
                Intent result = new Intent();
                result.putExtra("EdittedTweet", new NormalTweet(text));
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });


    }


}

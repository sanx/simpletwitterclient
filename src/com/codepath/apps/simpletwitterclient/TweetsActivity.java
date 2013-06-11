package com.codepath.apps.simpletwitterclient;

import java.util.ArrayList;

import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class TweetsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);
        
    	SimpleTwitterApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler() {
    		@Override
    		public void onSuccess(int arg0, JSONArray jsonTweets) {
    			ArrayList<Tweet> tweets = Tweet.fromJson(jsonTweets);
    			TweetsAdapter adapter = new TweetsAdapter(getBaseContext(), tweets);
    			ListView lv = (ListView)findViewById(R.id.lvTweets);
    			lv.setAdapter(adapter);
    		}
    	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweets, menu);
        return true;
    }
    
}

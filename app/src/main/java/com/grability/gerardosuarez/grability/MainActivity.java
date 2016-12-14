package com.grability.gerardosuarez.grability;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import api.models.Entry;
import api.models.Feed;
import bus.BusProvider;
import events.GetFeedEvent;
import events.SendFeedEvent;

public class MainActivity extends AppCompatActivity{

    private final String LOG = MainActivity.class.getSimpleName();

    private final Bus mBus = BusProvider.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Post the event to call the API
        mBus.post(new GetFeedEvent());
    }

    @Subscribe
    public void onSendWeatherEvent(SendFeedEvent sendFeedEvent)
    {
        Feed feed = sendFeedEvent.getmFeed();
        List<Entry> entryList = feed.getEntry();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mBus.register(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mBus.unregister(this);
    }
}

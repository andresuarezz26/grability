package com.grability.gerardosuarez.grability;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import adapter.ActivityMainAdapter;
import api.models.AttributesCategory;
import api.models.Entry;
import api.models.Feed;
import bus.BusProvider;
import events.GetFeedEvent;
import events.SendFeedEvent;
import model.Converter;
import utils.SnackbarMsg;

public class MainActivity extends AppCompatActivity{

    private final String TAG = MainActivity.class.getSimpleName();

    private final Bus mBus = BusProvider.getInstance();

    private Converter mConverter;

    private View parentLayout ;

    //RecyclerView parametters
    private RecyclerView mRecyclerView;

    private ActivityMainAdapter adapter;

    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList <AttributesCategory> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        //Post the event to call the API
        mBus.post(new GetFeedEvent());
    }

    /**
     * Initialize toolbar,recyclerView, adapters and assign list to adapter
     */
    public void initComponents()
    {
        parentLayout = findViewById(R.id.recycler_view_main);

        //Initialize Toolbar
        Toolbar toolbar = (Toolbar)findViewById( R.id.toolbar );

        setSupportActionBar( toolbar );

        //RecyclerView components
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        categoryList = new ArrayList<AttributesCategory>(  );

       // mRecyclerView.addItemDecoration( new DividerItemDecoration( this, LinearLayoutManager.VERTICAL ) );

        adapter = new ActivityMainAdapter(categoryList);

        mRecyclerView.setAdapter(adapter);

    }

    /**
     * When the sendFeedEvent is called, do the logic to show the categories
     * @param sendFeedEvent
     */
    @Subscribe
    public void onSendFeedEvent(SendFeedEvent sendFeedEvent)
    {
        Log.e(TAG, "onSeedEvent");

        //Recover the data form API
        Feed feed = sendFeedEvent.getFeed();
        List<Entry> entryList = feed.getEntry();

        Log.e(TAG, entryList.get(0).toString()+"size "+entryList.size());

        SnackbarMsg.getInstance().getMessage(parentLayout,entryList.get(0).toString()+"size "+entryList.size());

        //Convert the entryList in AttributeCategory list and notify to adapter
        mConverter = new Converter(entryList);
        categoryList = mConverter.getCategories();

        Log.e(TAG, categoryList.get(0).toString()+"size "+categoryList.size());


        adapter.notifyDataSetChanged();

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

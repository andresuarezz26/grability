package com.grability.gerardosuarez.grability;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import api.interfaces.ITunesAPI;
import api.models.MyPojo;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements  Callback<MyPojo>{

    private final String BASE_URL = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";

    private final String LOG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ITunesAPI iTunesAPI = retrofit.create(ITunesAPI.class);

        Call<MyPojo> call = iTunesAPI.loadApps();

        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<MyPojo> response, Retrofit retrofit) {
        Log.e(LOG,"success");
        Log.e(LOG,response.body().toString());
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e(LOG,"failure");
        Log.e(LOG,t.getMessage());
    }
}

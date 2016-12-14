package Application;

import android.app.Application;

import com.squareup.otto.Bus;

import bus.BusProvider;
import manager.ApiManager;

/**
 * Created by gerardosuarez on 13/12/16.
 * This class represents the entire application. The methods inside onCreate are only executed once
 */
public class App extends Application
{
    private Bus mBus = BusProvider.getInstance();
    private ApiManager mApiManager;

    @Override
    public void onCreate()
    {
        mApiManager = new ApiManager(this, mBus);
        mBus.register(mApiManager);
        mBus.register(this);
    }
}

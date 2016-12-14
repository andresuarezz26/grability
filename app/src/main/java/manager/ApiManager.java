package manager;

import android.content.Context;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import api.ApiClient;
import api.models.Feed;
import events.GetFeedEvent;
import events.SendFeedEvent;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by gerardosuarez
 */
public class ApiManager
{
    private Context mContext;

    private Bus mBus;

    private ApiClient mApiClient;

    private final String TAG = ApiManager.class.getSimpleName();


    /**
     * ApiManager constructor that initialize the context,bus and the ApiClient classes
     * @param context
     * @param bus
     */
    public ApiManager(Context context, Bus bus)
    {
        this.mContext = context;
        this.mBus = bus;
        mApiClient = ApiClient.getClient();
    }

    /**
     * Obtain the Feed from the API
     * @param getFeedEvent
     */
    @Subscribe
    public void onGetFeedEvent(GetFeedEvent getFeedEvent)
    {
        Callback<Feed> callback = new Callback<Feed>()
        {
            @Override
            public void success(Feed feed, Response response)
            {
                mBus.post(new SendFeedEvent(feed));
                Log.e(TAG, "Success");
            }
            @Override
            public void failure(RetrofitError error)
            {
                Log.e(TAG, "Failure");
            }
        };

        mApiClient.getFeed(callback);
    }


}

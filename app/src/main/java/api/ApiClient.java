package api;

import com.squareup.okhttp.OkHttpClient;

import api.interfaces.ITunesAPI;
import api.models.Example;
import api.models.Feed;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by gerardosuarez
 * Class represents the API client that contains API url and RestAdapter
 */
public class ApiClient {

    private final String BASE_URL = "https://itunes.apple.com/us/rss/topfreeapplications/";

    private static ApiClient mApiClient;

    private static RestAdapter mRestAdapter;

    /**
     * Method that return the SingletonClient
     * @return
     */
    public static ApiClient getClient()
    {
        if(mApiClient == null)
        {
            mApiClient = new ApiClient();
        }
        return mApiClient;
    }

    /**
     * ApiClient Constructor
     */
    public ApiClient ()
    {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public void getFeed(Callback<Feed> callback)
    {
        ITunesAPI iTunesAPI = mRestAdapter.create(ITunesAPI.class);
        iTunesAPI.loadFeed();
    }
}

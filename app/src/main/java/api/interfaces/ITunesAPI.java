package api.interfaces;

import api.models.Feed;
import retrofit.http.GET;

/**
 * Created by gerardosuarez
 * Interface that implements the methods to query the iTunes Apps API
 */
public interface ITunesAPI
{
    /**
     * Get the Feed that contains the List of Entries
     * @return
     */
    @GET("limit=20/json")
    Feed loadFeed();
}

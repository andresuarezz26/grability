package api.interfaces;

import api.models.MyPojo;
import retrofit.http.GET;
import retrofit.Call;

/**
 * Created by gerardosuarez on 11/12/16.
 */
public interface ITunesAPI
{
    @GET(".")
    Call<MyPojo> loadApps();

}

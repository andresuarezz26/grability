package api.models;

/**
 * Created by gerardosuarez on 12/12/16.
 */

public class MyPojo
{
    private Feed feed;

    public Feed getFeed ()
    {
        return feed;
    }

    public void setFeed (Feed feed)
    {
        this.feed = feed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [feed = "+feed+"]";
    }
}

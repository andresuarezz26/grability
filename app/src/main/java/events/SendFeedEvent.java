package events;

import api.models.Feed;

/**
 * Created by gerardosuarez on 14/12/16.
 */
public class SendFeedEvent
{
    private Feed mFeed;

    public SendFeedEvent(Feed mFeed)
    {
        this.mFeed = mFeed;
    }

    public Feed getFeed()
    {
        return mFeed;
    }
}

package bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by gerardosuarez on 13/12/16.
 */
public final class BusProvider
{
    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    private BusProvider() {
    }

    public static Bus getInstance() {
        return BUS;
    }

}

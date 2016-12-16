package utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by gerardosuarez on 14/12/16.
 * Singleton Class for display Messages
 */
public class SnackbarMsg
{
    private static SnackbarMsg mSnackbarMsg;

    public static SnackbarMsg getInstance()
    {
        if(mSnackbarMsg == null){
            mSnackbarMsg = new SnackbarMsg();
        }
        return mSnackbarMsg;
    }

    private SnackbarMsg ()
    {

    }

    /**
     * Get Message from view
     * @param view
     * @param message
     */
    public void getMessage(View view, String message)
    {
        Snackbar snackbar = Snackbar
                .make(view, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);
        snackbar.show();
    }



}

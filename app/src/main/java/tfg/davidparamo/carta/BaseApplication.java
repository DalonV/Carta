package tfg.davidparamo.carta;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by david on 14/05/2017.
 */

public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}

package com.km2labs.mediacontent.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.BuildConfig;
import com.crashlytics.android.core.CrashlyticsCore;
import com.flurry.android.FlurryAgent;
import com.km2labs.mediacontent.dagger.AppComponent;
import com.km2labs.mediacontent.dagger.AppModule;
import com.km2labs.mediacontent.dagger.DaggerAppComponent;
import com.km2labs.mediacontent.dagger.core.ui.activity.ActivityComponentBuilder;
import com.km2labs.mediacontent.dagger.core.ui.activity.ActivitySubcomponentBuilders;

import java.util.Map;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * Created by : Subham Tyagi
 * Created on :  28/08/16.
 */

public class App extends Application implements ActivitySubcomponentBuilders {

    private static AppComponent sAppComponent;

    @Inject
    Map<Class<? extends Activity>, ActivityComponentBuilder> activityComponentBuilders;

    public static ActivitySubcomponentBuilders get(Context context) {
        return ((ActivitySubcomponentBuilders) context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashlyticsCore core = new CrashlyticsCore.Builder()
                //.disabled(BuildConfig.DEBUG)
                .build();
        FlurryAgent.setLogEnabled(false);
        FlurryAgent.init(this, "5CRSYGMX6ZVP56538W8J");
        Fabric.with(this, new Crashlytics.Builder().core(core).build(), new Answers());
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        //Timber.plant(new CrashlyticsTree());
        sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    public <T extends ActivityComponentBuilder> T getActivityComponentBuilder(Class<? extends Activity> activityClass) {
        return (T) activityComponentBuilders.get(activityClass);

    }
}

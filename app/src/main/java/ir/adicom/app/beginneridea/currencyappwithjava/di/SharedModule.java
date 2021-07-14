package ir.adicom.app.beginneridea.currencyappwithjava.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedModule {

    private Application application;

    public SharedModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context getContext() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("API", Context.MODE_PRIVATE);
    }

}

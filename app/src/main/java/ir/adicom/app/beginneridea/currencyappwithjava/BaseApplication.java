package ir.adicom.app.beginneridea.currencyappwithjava;

import android.app.Application;

import ir.adicom.app.beginneridea.currencyappwithjava.di.DaggerSharedComponent;
import ir.adicom.app.beginneridea.currencyappwithjava.di.SharedComponent;
import ir.adicom.app.beginneridea.currencyappwithjava.di.SharedModule;

public class BaseApplication extends Application {

    private SharedComponent sharedComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedComponent = DaggerSharedComponent.builder()
                .sharedModule(new SharedModule(this))
                .build();
    }

    public SharedComponent getSharedComponent() {
        return sharedComponent;
    }
}

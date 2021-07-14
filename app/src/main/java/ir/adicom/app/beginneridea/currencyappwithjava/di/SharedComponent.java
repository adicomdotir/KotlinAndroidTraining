package ir.adicom.app.beginneridea.currencyappwithjava.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import ir.adicom.app.beginneridea.MainActivity;
import ir.adicom.app.beginneridea.currencyappwithjava.CurrencyMainActivity;
import ir.adicom.app.beginneridea.currencyappwithjava.ui.fragments.HomeCurrencyFragment;

@Singleton
@Component(modules = {SharedModule.class})
public interface SharedComponent {
    void inject(Application application);
    void inject(CurrencyMainActivity currencyMainActivity);
    void inject(HomeCurrencyFragment homeCurrencyFragment);
}

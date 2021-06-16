package ir.adicom.app.beginneridea.dagger_training

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetModule::class])
public interface AppComponent {
    fun inject(activity: DaggerTrainingActivity)
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
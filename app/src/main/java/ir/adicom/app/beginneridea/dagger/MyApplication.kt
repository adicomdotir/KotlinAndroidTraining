package ir.adicom.app.beginneridea.dagger

import android.app.Application
import android.util.Log
import ir.adicom.app.beginneridea.dagger_training.AppComponent
import ir.adicom.app.beginneridea.dagger_training.DaggerAppComponent
import ir.adicom.app.beginneridea.eventbus.EventMessage
import org.greenrobot.eventbus.EventBus

class MyApplication : Application() {
    private lateinit var driverComponent: DriverComponent
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate: ")
        EventBus.getDefault().post(EventMessage("I'm event bus library!"))
        driverComponent = DaggerDriverComponent.create()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getDriverComponent(): DriverComponent {
        return driverComponent
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}
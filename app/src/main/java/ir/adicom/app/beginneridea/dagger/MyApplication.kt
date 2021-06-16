package ir.adicom.app.beginneridea.dagger

import android.app.Application
import ir.adicom.app.beginneridea.dagger_training.AppComponent
import ir.adicom.app.beginneridea.dagger_training.AppModule
import ir.adicom.app.beginneridea.dagger_training.DaggerAppComponent
import ir.adicom.app.beginneridea.dagger_training.NetModule

class MyApplication : Application() {
    private lateinit var driverComponent: DriverComponent
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
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
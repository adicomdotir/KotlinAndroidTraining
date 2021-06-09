package ir.adicom.app.beginneridea.dagger

import android.app.Application

class MyApplication : Application() {
    private lateinit var driverComponent: DriverComponent

    override fun onCreate() {
        super.onCreate()
        driverComponent = DaggerDriverComponent.create()
    }

    fun getDriverComponent(): DriverComponent {
        return driverComponent
    }
}
package ir.adicom.app.beginneridea.dagger

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component (modules = [WheelsModule::class, DieselEngineModule::class])
interface CarComponent {
    fun getCar(): Car

    fun inject(daggerActivity: DaggerActivity)
}
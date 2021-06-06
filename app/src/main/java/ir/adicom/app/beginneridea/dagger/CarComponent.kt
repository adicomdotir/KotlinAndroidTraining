package ir.adicom.app.beginneridea.dagger

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component
interface CarComponent {
    fun getCar(): Car

    fun inject(daggerActivity: DaggerActivity)
}
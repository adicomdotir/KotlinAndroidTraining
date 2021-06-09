package ir.adicom.app.beginneridea.dagger

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@PerActivityScope
@Component (modules = [WheelsModule::class, PetrolEngineModule::class], dependencies = [DriverComponent::class])
interface CarComponent {
    fun getCar(): Car

    fun inject(daggerActivity: DaggerActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun horsePower(@Named("horsePower") horsePower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engineCapacity") engineCapacity: Int): Builder

        fun driverComponent(driverComponent: DriverComponent): Builder

        fun build(): CarComponent
    }
}
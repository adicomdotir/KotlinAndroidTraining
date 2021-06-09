package ir.adicom.app.beginneridea.dagger

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Named
import javax.inject.Singleton

@PerActivityScope
@Subcomponent (modules = [WheelsModule::class, PetrolEngineModule::class])
interface CarComponent {
    fun getCar(): Car

    fun inject(daggerActivity: DaggerActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun horsePower(@Named("horsePower") horsePower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engineCapacity") engineCapacity: Int): Builder

        fun build(): CarComponent
    }
}
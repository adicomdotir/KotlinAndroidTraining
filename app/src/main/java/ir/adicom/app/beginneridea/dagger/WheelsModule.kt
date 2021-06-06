package ir.adicom.app.beginneridea.dagger

import dagger.Module
import dagger.Provides

@Module
class WheelsModule {
    @Provides
    fun getRims(): Rims {
        return Rims()
    }

    @Provides
    fun getTires(): Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @Provides
    fun getWheels(rims: Rims, tires: Tires): Wheels {
        return Wheels(rims, tires)
    }
}
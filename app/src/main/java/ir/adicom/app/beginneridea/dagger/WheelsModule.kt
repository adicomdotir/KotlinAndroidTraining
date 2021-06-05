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
        return Tires()
    }

    @Provides
    fun getWheels(rims: Rims, tires: Tires): Wheels {
        return Wheels(rims, tires)
    }
}
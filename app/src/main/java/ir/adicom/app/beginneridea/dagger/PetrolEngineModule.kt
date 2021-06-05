package ir.adicom.app.beginneridea.dagger

import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule(private var powerHorse: Int, private var engineCapacity: Int) {
    @Provides
    fun getPetrolEngine(): Engine {
        return PetrolEngine(powerHorse, engineCapacity)
    }
}
package ir.adicom.app.beginneridea.dagger

import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule(private val horsePower: Int, private val engineCapacity: Int)  {
    @Provides
    fun getPetrolEngine(): Engine {
        return PetrolEngine(horsePower, engineCapacity)
    }
}
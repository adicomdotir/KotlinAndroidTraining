package ir.adicom.app.beginneridea.dagger

import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule(private val horsePower: Int)  {
    @Provides
    fun getPetrolEngine(): Engine {
        return PetrolEngine(horsePower)
    }
}
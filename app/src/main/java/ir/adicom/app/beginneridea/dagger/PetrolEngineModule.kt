package ir.adicom.app.beginneridea.dagger

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PetrolEngineModule()  {
    @Binds
    abstract fun getPetrolEngine(petrolEngine: PetrolEngine): Engine
}
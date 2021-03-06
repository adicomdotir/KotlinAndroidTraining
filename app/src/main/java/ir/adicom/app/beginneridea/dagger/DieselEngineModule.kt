package ir.adicom.app.beginneridea.dagger

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DieselEngineModule {
    @Binds
    abstract fun getDieselEngine(dieselEngine: DieselEngine): Engine
}

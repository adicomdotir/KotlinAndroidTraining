package ir.adicom.app.beginneridea.dagger

import dagger.Module
import dagger.Provides

@Module
class Provider {
    companion object {
        @Provides
        fun providerPower(): Power {
            return Power()
        }
    }
}
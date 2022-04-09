package ir.adicom.app.beginneridea.dagger_codelab.di

import dagger.Binds
import dagger.Module
import ir.adicom.app.beginneridea.dagger_codelab.storage.SharedPreferencesStorage
import ir.adicom.app.beginneridea.dagger_codelab.storage.Storage

@Module
abstract class StorageModule {
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}
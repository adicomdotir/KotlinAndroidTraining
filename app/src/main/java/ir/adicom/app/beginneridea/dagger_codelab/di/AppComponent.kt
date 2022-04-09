package ir.adicom.app.beginneridea.dagger_codelab.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ir.adicom.app.beginneridea.dagger_codelab.registration.RegistrationActivity

@Component(modules = [StorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: RegistrationActivity)
}
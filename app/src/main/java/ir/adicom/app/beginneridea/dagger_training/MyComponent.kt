package ir.adicom.app.beginneridea.dagger_training

import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Component
interface MyComponent {
    fun getMySubcomponent(): MySubcomponent
}

@Subcomponent
interface MySubcomponent {
    fun getTargetClass(): TargetClass
}
package ir.adicom.app.beginneridea.dagger

import dagger.Component

@PerApplicationScope
@Component
interface DriverComponent {

    fun getDriver(): Driver

    fun getCarComponentBuilder(): CarComponent.Builder
}
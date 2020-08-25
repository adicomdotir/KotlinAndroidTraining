package ir.adicom.app.beginneridea.dagger

import dagger.Component

@Component(modules = [Provider::class])
interface Connector {
    fun injectPower(): Hero
}
package ir.adicom.app.beginneridea.dagger

import javax.inject.Inject

class Hero @Inject internal constructor(var power: Power) {
    override fun toString(): String {
        return power.toString()
    }
}
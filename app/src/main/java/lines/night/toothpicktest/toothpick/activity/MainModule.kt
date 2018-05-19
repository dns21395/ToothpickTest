package lines.night.toothpicktest.toothpick.activity

import lines.night.toothpicktest.Counter
import toothpick.config.Module

class MainModule : Module() {
    init {
        bind(Counter::class.java).to(Counter::class.java)
    }
}
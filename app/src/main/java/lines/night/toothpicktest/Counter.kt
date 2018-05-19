package lines.night.toothpicktest

import timber.log.Timber
import javax.inject.Inject

class Counter @Inject constructor() {

    init {
        Timber.i("Counter")
    }

    var count = 0
}
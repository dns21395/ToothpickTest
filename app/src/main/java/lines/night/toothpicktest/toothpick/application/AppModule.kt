package lines.night.toothpicktest.toothpick.application

import android.content.Context
import lines.night.toothpicktest.util.SchedulerProviderImpl
import night.lines.todo.util.SchedulerProvider
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
        bind(SchedulerProvider::class.java).toInstance(SchedulerProviderImpl())
    }
}
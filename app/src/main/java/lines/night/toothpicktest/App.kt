package lines.night.toothpicktest

import android.app.Application
import lines.night.toothpicktest.toothpick.DI
import lines.night.toothpicktest.toothpick.application.AppModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initToothpick()
        initAppScope()
    }

    private fun initTimber() {
        when(BuildConfig.DEBUG) {
            true -> Timber.plant(Timber.DebugTree())
            false -> {}
        }
    }

    private fun initToothpick() {
        when(BuildConfig.DEBUG) {
            true -> Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
            false -> {
                Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
                FactoryRegistryLocator.setRootRegistry(lines.night.toothpicktest.FactoryRegistry())
                MemberInjectorRegistryLocator.setRootRegistry(lines.night.toothpicktest.MemberInjectorRegistry())
            }
        }
    }

    private fun initAppScope() {
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        appScope.installModules(AppModule(this))
    }
}
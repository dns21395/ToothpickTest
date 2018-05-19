package lines.night.toothpicktest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lines.night.toothpicktest.toothpick.DI
import lines.night.toothpicktest.toothpick.activity.MainModule
import lines.night.toothpicktest.toothpick.activity.MainScope
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inject()

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MainFragment())
                .commitAllowingStateLoss()

        buttonPlus.setOnClickListener {
            counter.count++
        }

    }

    private fun inject() {
        Toothpick.openScopes(DI.APP_SCOPE, MainScope::class.java).apply {
            installModules(MainModule())
            Toothpick.inject(this@MainActivity, this)
        }
    }




}

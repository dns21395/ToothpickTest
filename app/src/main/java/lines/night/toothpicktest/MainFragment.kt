package lines.night.toothpicktest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import lines.night.toothpicktest.toothpick.activity.MainScope
import lines.night.toothpicktest.toothpick.fragment.FragmentScope
import timber.log.Timber
import toothpick.Toothpick
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        count.text = counter.count.toString()

        updateButton.setOnClickListener {
            count.text = counter.count.toString()
        }
    }

    private fun inject() {
        Timber.i("tree : ${
            Toothpick.openScopes(MainScope::class.java, FragmentScope::class.java).apply {
                Toothpick.inject(this@MainFragment, this)
            }
        }")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)
}
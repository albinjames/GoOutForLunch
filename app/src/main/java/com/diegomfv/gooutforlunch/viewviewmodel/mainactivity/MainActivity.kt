package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.GlobalVariables
import com.diegomfv.gooutforlunch.utils.HIDE_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.INEFFECTIVE_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.SHOW_PROGRESS_LAYOUT
import com.diegomfv.gooutforlunch.utils.customview.LoginBlock
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseActivity
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragment
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var factory: MainActivityViewModel.Factory

    lateinit var mainActivityViewModel: MainActivityViewModel

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun subscribeToModel() {
        mainActivityViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        GlobalVariables.progressBarLiveData.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                //TODO It is a TriggerOnce. We should fill the UIStateModel and listen to it ACTIVELY (not TriggerOnce)
                when (it) {
                    HIDE_PROGRESS_LAYOUT -> {}
                    SHOW_PROGRESS_LAYOUT -> {}
                    INEFFECTIVE_PROGRESS_LAYOUT  -> {}
                }
            }
        })

    }

    //TODO BaseActivity
    fun navigateTo (fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

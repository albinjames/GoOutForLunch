package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.customview.LoginBlock
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseActivity
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragment
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var emailBlock : LoginBlock
    lateinit var passwordBlock: LoginBlock

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

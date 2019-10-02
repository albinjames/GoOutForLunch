package com.diegomfv.gooutforlunch.viewviewmodel.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.diegomfv.gooutforlunch.utils.StaticVariables.isOnBackPressedEnabled
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    var vCompositeDisposable: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = fragmentInjector

    @Inject
    @field:Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    protected lateinit var actFragmentManager: FragmentManager

    private var mainLayout: View? = null //For snackBars
    private var snackBar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        vCompositeDisposable = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        unbindViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindViews()
    }

    private fun unbindViews () {
        vCompositeDisposable.let {
            if (!it.isDisposed) {
                it.dispose()
                it.clear()
            }
        }
    }

    protected fun showDialogFragment(dialogFragment: DialogFragment, tag: String) =
        dialogFragment.show(supportFragmentManager, tag)

    protected fun setMainLayoutForSnackBar(view: View) {
        this.mainLayout = view
    }

    abstract fun subscribeToModel()

    fun enableAndClickOnBackPressed () {
        isOnBackPressedEnabled = true
        onBackPressed()
    }
}
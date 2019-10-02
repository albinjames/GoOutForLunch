package com.diegomfv.gooutforlunch.viewviewmodel.base

import android.content.Context
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseChildAppCompatDialogFragment : AppCompatDialogFragment(), HasSupportFragmentInjector {

    var vCompositeDisposable: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var childChildFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childChildFragmentInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    abstract fun subscribeToModel()

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

}
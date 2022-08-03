package com.techyourchance.dagger2course.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel?> create(key: String,modelClass: Class<T>,handle: SavedStateHandle): T {
        val provider = providers[modelClass]
        val viewModel = provider?.get() ?: throw RuntimeException("unsupported viewmodel type: ${modelClass}")
        if(viewModel is SavedStateViewModel) {
            viewModel.init(handle)
        }
        return viewModel as T
    }
}
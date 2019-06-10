package com.nextcloud.client.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>,
    @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator : Provider<ViewModel>? = creators.get(modelClass)

        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }

        if (creator == null) {
            throw IllegalArgumentException("${modelClass.simpleName} view model class is not supported")
        }

        try {
            @Suppress("UNCHECKED_CAST")
            val vm = creator.get() as T
            return vm
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}

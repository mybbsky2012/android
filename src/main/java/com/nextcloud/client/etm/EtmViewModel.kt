package com.nextcloud.client.etm

import android.content.SharedPreferences
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nextcloud.client.etm.pages.EtmPreferencesFragment
import com.owncloud.android.R
import javax.inject.Inject

class EtmViewModel @Inject constructor(
    private val defaultPreferences: SharedPreferences
) : ViewModel() {
    val currentPage: LiveData<EtmMenuEntry?> = MutableLiveData()
    val pages: LiveData<List<EtmMenuEntry>> = MutableLiveData()

    val preferences: Map<String, String> get() {
        return defaultPreferences.all
            .map { it.key to "${it.value}" }
            .toMap()
    }

    init {
        (pages as MutableLiveData).apply {
            value = listOf(
                EtmMenuEntry(
                    iconRes = R.drawable.ic_settings,
                    titleRes = R.string.etm_preferences,
                    pageClass = EtmPreferencesFragment::class
                )
            )
        }
        (currentPage as MutableLiveData).apply {
            value = null
        }
    }

    fun onPageSelected(index: Int) {
        pages.value?.let {
            if (index < it.size) {
                currentPage as MutableLiveData
                currentPage.value = it[index]
            }
        }
    }

    fun onBackPressed(): Boolean {
        (currentPage as MutableLiveData)
        return if (currentPage.value != null) {
            currentPage.value = null
            true
        } else {
            false
        }
    }
}

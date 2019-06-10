package com.nextcloud.client.etm

import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

data class EtmMenuEntry(val iconRes: Int, val titleRes: Int, val pageClass: KClass<out Fragment>)

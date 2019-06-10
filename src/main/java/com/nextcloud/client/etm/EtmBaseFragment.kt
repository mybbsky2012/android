package com.nextcloud.client.etm

import androidx.fragment.app.Fragment

abstract class EtmBaseFragment : Fragment() {
    protected val vm: EtmViewModel get() {
        return (activity as EtmActivity).vm
    }
}

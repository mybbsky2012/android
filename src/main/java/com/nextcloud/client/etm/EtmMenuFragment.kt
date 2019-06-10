package com.nextcloud.client.etm


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.owncloud.android.R

class EtmMenuFragment : EtmBaseFragment() {

    private lateinit var adapter: EtmMenuAdapter
    private lateinit var list: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        adapter = EtmMenuAdapter(context!!, this::onClickedItem)
        adapter.pages = vm.pages.value!!
        val view = inflater.inflate(R.layout.fragment_etm_menu, container, false)
        list = view.findViewById(R.id.etm_menu_list)
        list.layoutManager = LinearLayoutManager(context!!)
        list.adapter = adapter
        return view
    }

    override fun onResume() {
        super.onResume()
        activity?.title = "Engineering & Test Module"
    }

    private fun onClickedItem(position: Int) {
        vm.onPageSelected(position)
    }

}

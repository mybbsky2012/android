package com.nextcloud.client.etm.pages

import android.os.Bundle
import android.view.*
import com.nextcloud.client.etm.EtmBaseFragment
import com.owncloud.android.R
import kotlinx.android.synthetic.main.fragment_etm_preferences.*
import android.content.Intent



class EtmPreferencesFragment : EtmBaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_etm_preferences, container, false)
    }

    override fun onResume() {
        super.onResume()
        val builder = StringBuilder()
        vm.preferences.forEach { builder.append("${it.key}: ${it.value}\n") }
        etm_preferences_text.text = builder
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.etm_preferences, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.etm_preferences_share -> { onClickedShare(); true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun onClickedShare() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Nextcloud preferences")
        intent.putExtra(Intent.EXTRA_TEXT, etm_preferences_text.text)
        intent.type = "text/plain"
        startActivity(intent)
    }

}

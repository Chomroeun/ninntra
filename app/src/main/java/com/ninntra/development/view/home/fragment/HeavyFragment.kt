package com.ninntra.development.view.home.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ninntra.development.R

class HavyFragment: BaseViewStubFragment(){
    override fun onCreateViewAfterViewStubInflated(inflatedView: View, savedInstanceState: Bundle?) {
        val titleView = inflatedView.findViewById<TextView>(R.id.fragmentTitle)
        titleView.text = arguments!!["title"] as String
    }

    override fun getViewStubLayoutResource(): Int {
        return R.layout.fragment_heavy
    }
}
package com.ninntra.development.view.home.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ninntra.development.view.home.fragment.HavyFragment

class SectionsPagerAdapter(var fragmentList: MutableList<Fragment>,var fragmentTitle:Array<String>, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val f = HavyFragment()
        val bundle = Bundle()
        bundle.putString("title",fragmentTitle[position])
        f.arguments = bundle
        return f
        //return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    override fun getCount(): Int {
        if(fragmentList !== null){
            return  fragmentList.size
        }

        return 0
    }
}
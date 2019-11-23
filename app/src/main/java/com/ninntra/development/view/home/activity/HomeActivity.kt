package com.ninntra.development.view.home.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.zagum.switchicon.SwitchIconView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.ninntra.development.R
import com.ninntra.development.model.AddressItem
import com.ninntra.development.model.Album
import com.ninntra.development.view.bottomview.fragment.BottomSheetFragment
import com.ninntra.development.view.home.adapter.SectionsPagerAdapter
import com.ninntra.development.view.home.viewmodel.AlbumViewModel
import com.ninntra.development.view.search.activity.MainActivity
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

val TAB_TITLES = arrayOf(
    "TAB 1","TAB 2","TAB 3","TAB 4","TAB 5"
)

val TAB_FRAGMENT: MutableList<Fragment> = arrayListOf(
    Fragment(),Fragment(), Fragment(), Fragment(), Fragment()
)

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private var albumViewModel: AlbumViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initTabData()

        val fab: SwitchIconView = findViewById(R.id.fab)
        fab.setOnClickListener {
            showBottomSheetDialogFragment()
        }

        val mToolbar:Toolbar = findViewById(R.id.toolbar)
        val imvSearch: MaterialButton = mToolbar.findViewById(R.id.buttonSearch)
        imvSearch.setOnClickListener{
            val intent = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intent)
        }

        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        //buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                       // buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        })

        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun initTabData(){

        val sectionsPagerAdapter = SectionsPagerAdapter(
            TAB_FRAGMENT,TAB_TITLES, supportFragmentManager
        )

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

    override fun onResume() {
        super.onResume()

        albumViewModel!!.getAlbums().observe(
            this,
            Observer {
                val listItem:List<Album> = it
                for(item in listItem){
                    Log.d("DDD",item.getAlbum())
                }
            }
        )
    }
}
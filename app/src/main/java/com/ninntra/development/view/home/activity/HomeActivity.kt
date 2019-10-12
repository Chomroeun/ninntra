package com.ninntra.development.view.home.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.zagum.switchicon.SwitchIconView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.ninntra.development.R
import com.ninntra.development.view.bottomview.fragment.BottomSheetFragment
import com.ninntra.development.view.home.adapter.SectionsPagerAdapter
import com.ninntra.development.view.search.activity.MainActivity
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
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
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
}
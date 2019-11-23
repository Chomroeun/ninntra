package com.ninntra.development.view.home.fragment

import AlbumsAdapter
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.ninntra.development.view.home.viewmodel.PageViewModel
import com.ninntra.development.model.Album
import androidx.recyclerview.widget.GridLayoutManager
import android.util.TypedValue
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ninntra.development.R
import kotlin.math.roundToInt



class PlaceholderFragment : Fragment(){

    //private lateinit var pageViewModel: PageViewModel

    private var recyclerView: RecyclerView? = null
    private var adapter: AlbumsAdapter? = null
    private var albumList: MutableList<Album> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
//            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        pageViewModel.text.observe(this, Observer<String> {
//            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
//        })

        recyclerView = root.findViewById(R.id.recycler_view)

        albumList = ArrayList()
        adapter = context?.let { AlbumsAdapter(it, albumList as ArrayList<Album>) }

        var mLayoutManager = GridLayoutManager(context, 2)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(10), true))
        recyclerView!!.adapter = adapter

        //prepareAlbums()

        return root
    }

    override fun onStart() {
        super.onResume()
        //Toast.makeText(context,"This is onStart()",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(context,"This is on onResume()",Toast.LENGTH_LONG).show()
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"


        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    inner class GridSpacingItemDecoration(
        private val spanCount: Int,
        private val spacing: Int,
        private val includeEdge: Boolean
    ) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column

            if (includeEdge) {
                outRect.left =
                    spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right =
                    (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right =
                    spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r = resources
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics).roundToInt()
    }


//    private fun prepareAlbums() {
//        val covers = intArrayOf(
//            R.drawable.album1,
//            R.drawable.album2,
//            R.drawable.album3,
//            R.drawable.album4,
//            R.drawable.album5,
//            R.drawable.album6,
//            R.drawable.album7,
//            R.drawable.album8,
//            R.drawable.album9,
//            R.drawable.album10,
//            R.drawable.album11
//        )
//
//        var a = Album("True Romance", 13, covers[0])
//        albumList.add(a)
//
//        a = Album("Xscpae", 8, covers[1])
//        albumList.add(a)
//
//        a = Album("Maroon 5", 11, covers[2])
//        albumList.add(a)
//
//        a = Album("Born to Die", 12, covers[3])
//        albumList.add(a)
//
//        a = Album("Honeymoon", 14, covers[4])
//        albumList.add(a)
//
//        a = Album("I Need a Doctor", 1, covers[5])
//        albumList.add(a)
//
//        a = Album("Loud", 11, covers[6])
//        albumList.add(a)
//
//        a = Album("Legend", 14, covers[7])
//        albumList.add(a)
//
//        a = Album("Hello", 11, covers[8])
//        albumList.add(a)
//
//        a = Album("Greatest Hits", 17, covers[9])
//        albumList.add(a)
//
//        adapter?.notifyDataSetChanged()
//    }

}


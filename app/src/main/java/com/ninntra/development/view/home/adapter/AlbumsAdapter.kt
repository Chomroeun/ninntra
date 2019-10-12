
import com.bumptech.glide.Glide
import com.ninntra.development.model.Album
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.*
import android.widget.*
import com.ninntra.development.R

class AlbumsAdapter(private val mContext: Context, private val albumList: List<Album>) :
    RecyclerView.Adapter<AlbumsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var count: TextView
        var thumbnail: ImageView
        var overflow: ImageView

        init {
            title = view.findViewById(R.id.title)
            count = view.findViewById(R.id.count)
            thumbnail = view.findViewById(R.id.thumbnail) as ImageView
            overflow = view.findViewById(R.id.overflow) as ImageView
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_card, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val album = albumList[position]
        holder.title.text = album.name
        holder.count.text = album.numOfSongs.toString() + " songs"

        // loading album cover using Glide library
        Glide.with(mContext).load(album.thumbnail).into(holder.thumbnail)

        holder.overflow.setOnClickListener {
            //showPopupMenu(holder.overflow)
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private fun showPopupMenu(view: View) {
        // inflate menu
        val popup = PopupMenu(mContext, view)
        val inflater = popup.getMenuInflater()
        inflater.inflate(R.menu.menu_album, popup.getMenu())
        popup.setOnMenuItemClickListener(MyMenuItemClickListener())
        popup.show()
    }

    /**
     * Click listener for popup menu items
     */
    internal inner class MyMenuItemClickListener : PopupMenu.OnMenuItemClickListener {

        override fun onMenuItemClick(menuItem: MenuItem): Boolean {
            when (menuItem.itemId) {
                R.id.action_add_favourite -> {
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show()
                    return true
                }
                R.id.action_play_next -> {
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show()
                    return true
                }
            }
            return false
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}
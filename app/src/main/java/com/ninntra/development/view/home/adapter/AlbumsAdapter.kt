
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
        var title: TextView = view.findViewById(R.id.title)
        var count: TextView = view.findViewById(R.id.count)
        var thumbnail: ImageView = view.findViewById(R.id.thumbnail) as ImageView
        var overflow: ImageView = view.findViewById(R.id.overflow) as ImageView

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

    override fun getItemCount(): Int {
        return albumList.size
    }
}
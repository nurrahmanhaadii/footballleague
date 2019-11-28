package id.haadii.submission.dicoding.footballleague

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.haadii.submission.dicoding.footballleague.FootballUi.Companion.iv_football
import id.haadii.submission.dicoding.footballleague.FootballUi.Companion.tv_football
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import java.util.*

class FootballAdapter(
    private val items: ArrayList<Football>,
    private val listener: (Football) -> Unit
) : RecyclerView.Adapter<FootballAdapter.FootballAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballAdapterViewHolder {
        return FootballAdapterViewHolder(
            FootballUi().createView(AnkoContext.Companion.create(parent.context, parent))
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FootballAdapterViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class FootballAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image : ImageView = view.find(iv_football)
        private val title : TextView = view.find(tv_football)
        fun bind(item: Football, listener: (Football) -> Unit) {
            Glide.with(itemView.context)
                .load(item.image)
                .into(image)
            title.text = item.name
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}
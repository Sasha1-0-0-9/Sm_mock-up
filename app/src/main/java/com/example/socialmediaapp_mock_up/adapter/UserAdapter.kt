import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialmediaapp_mock_up.Model.User
import com.example.socialmediaapp_mock_up.R
import com.example.socialmediaapp_mock_up.adapter.OnUserClick

class UserAdapter(val userClick: OnUserClick) :
    ListAdapter<User, UserAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
    }) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.user_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.userName1)
        private val onlineStatusTextView: TextView = itemView.findViewById(R.id.lastSeen1)
        private val profileImageView: ImageView = itemView.findViewById(R.id.profile_image1)

        fun bind(item: User, context: Context) {
            nameTextView.text = item.name
            onlineStatusTextView.text = item.online
            Glide.with(context)
                .load(item.photo)
                .error(R.drawable.ic_ava)
                .into(profileImageView)
            itemView.setOnClickListener {
                userClick.onClick(item.id)
            }
        }
    }
}


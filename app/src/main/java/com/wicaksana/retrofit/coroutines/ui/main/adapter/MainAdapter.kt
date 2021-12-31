package com.wicaksana.retrofit.coroutines.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wicaksana.retrofit.coroutines.R
import com.wicaksana.retrofit.coroutines.data.model.Post
import com.wicaksana.retrofit.coroutines.ui.main.adapter.MainAdapter.DataViewHolder
import kotlinx.android.synthetic.main.item_layout.view.imageViewAvatar
import kotlinx.android.synthetic.main.item_layout.view.textViewUserBody
import kotlinx.android.synthetic.main.item_layout.view.textViewUserName

class MainAdapter(private val posts: ArrayList<Post>) : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post) {
            itemView.apply {
                textViewUserName.text = post.title
                textViewUserBody.text = post.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    fun addPosts(posts: List<Post>) {
        this.posts.apply {
            clear()
            addAll(posts)
        }

    }
}
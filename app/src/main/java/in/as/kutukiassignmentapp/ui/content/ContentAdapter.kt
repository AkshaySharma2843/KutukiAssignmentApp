package `in`.`as`.kutukiassignmentapp.ui.content

import `in`.`as`.kutukiassignmentapp.data.model.ContentResponse
import `in`.`as`.kutukiassignmentapp.data.model.VideoDetails
import `in`.`as`.kutukiassignmentapp.databinding.ItemContentBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 04-04-2022.
 */
class ContentAdapter(private val list:ArrayList<VideoDetails>, val contentCallback: ContentCallback) : RecyclerView.Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val data = list.get(position)
        holder.bindData(data, contentCallback)
    }

    override fun getItemCount(): Int = list.size

}
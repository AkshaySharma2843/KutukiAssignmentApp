package `in`.`as`.kutukiassignmentapp.ui.content

import `in`.`as`.kutukiassignmentapp.data.model.ContentResponse
import `in`.`as`.kutukiassignmentapp.data.model.VideoDetails
import `in`.`as`.kutukiassignmentapp.databinding.ItemContentBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Akshay Sharma on 04-04-2022.
 */
class ContentViewHolder(
    val itemContentBinding: ItemContentBinding) : RecyclerView.ViewHolder(itemContentBinding.root) {


    fun bindData(data: VideoDetails, contentCallback: ContentCallback) {
        Glide.with(itemView.context).load(
            data.thumbnailURL
        ).into(itemContentBinding.ivImageView)
        itemView.setOnClickListener {
            contentCallback.onVideoClicked(data)

        }
    }

}
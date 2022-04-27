package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemSubjectBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class SubjectViewHolder(private val itemSubjectBinding : ItemSubjectBinding) : RecyclerView.ViewHolder(itemSubjectBinding.root){
    fun bindData(dataToBind: HomeApiResponse.Data.Subject) {
        Glide.with(itemView)
            .load(dataToBind.icon)
            .into(itemSubjectBinding.subIv)

        itemSubjectBinding.subTv.text = dataToBind.subName

    }

}
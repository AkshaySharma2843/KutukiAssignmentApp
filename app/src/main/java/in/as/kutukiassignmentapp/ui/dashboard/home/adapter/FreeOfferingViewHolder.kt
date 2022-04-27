package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.model.FreeOffering
import `in`.`as`.kutukiassignmentapp.databinding.ItemFreeOfferingBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class FreeOfferingViewHolder(private val itemFreeOfferingBinding: ItemFreeOfferingBinding) : RecyclerView.ViewHolder(itemFreeOfferingBinding.root) {
    fun bindData(dataToBind: FreeOffering) {
        itemFreeOfferingBinding.tvNewFreeLearning.text = dataToBind.name
        Glide.with(itemView)
            .load(dataToBind.image)
            .into(itemFreeOfferingBinding.ivNewFreeLearning)


    }


}
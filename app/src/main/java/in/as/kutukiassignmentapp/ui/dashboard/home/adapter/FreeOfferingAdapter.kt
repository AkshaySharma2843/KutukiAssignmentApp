package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.model.FreeOffering
import `in`.`as`.kutukiassignmentapp.databinding.ItemFreeOfferingBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class FreeOfferingAdapter(val arrayList: ArrayList<FreeOffering>) : RecyclerView.Adapter<FreeOfferingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreeOfferingViewHolder {
        return FreeOfferingViewHolder(ItemFreeOfferingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FreeOfferingViewHolder, position: Int) {
        val dataToBind = arrayList[position]
        holder.bindData(dataToBind)
    }

    override fun getItemCount(): Int {
      return  arrayList.size
    }
}
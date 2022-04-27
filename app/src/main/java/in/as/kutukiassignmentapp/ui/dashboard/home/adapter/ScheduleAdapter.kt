package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemScheduleBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class ScheduleAdapter(private val arrayList: ArrayList<ScheduleResponse.Data.ZoomClass>) : RecyclerView.Adapter<ScheduleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(ItemScheduleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
       val dataToBind = arrayList[position]
       holder.bindData(dataToBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
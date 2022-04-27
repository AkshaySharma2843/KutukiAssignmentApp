package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemSubjectBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class SubjectAdapter() : RecyclerView.Adapter<SubjectViewHolder>() {
   private var isAll:Boolean = false
    private var arrayList = ArrayList<HomeApiResponse.Data.Subject>()
    fun submitList(isAll: Boolean,arrayList: ArrayList<HomeApiResponse.Data.Subject>) {
            this.isAll = isAll
            this.arrayList = arrayList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        return SubjectViewHolder(ItemSubjectBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val dataToBind = arrayList[position]
        holder.bindData(dataToBind)
    }

    override fun getItemCount(): Int {
        return if(isAll){
            arrayList.size
        }else {
            arrayList.size.coerceAtMost(4)
        }

    }
}
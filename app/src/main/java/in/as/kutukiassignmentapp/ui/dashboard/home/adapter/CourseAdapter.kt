package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemCourseListBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class CourseAdapter(val arrayList: ArrayList<HomeApiResponse.Data.Course>) : RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(ItemCourseListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val dataToBind = arrayList[position]
        holder.bindData(dataToBind)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.HomeApiResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemCourseListBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class CourseViewHolder(private val itemCourseListBinding: ItemCourseListBinding) : RecyclerView.ViewHolder(itemCourseListBinding.root){
    fun bindData(dataToBind: HomeApiResponse.Data.Course) {
        itemCourseListBinding.title.text = dataToBind.course


    }


}
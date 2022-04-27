package `in`.`as`.kutukiassignmentapp.ui.dashboard.home.adapter

import `in`.`as`.kutukiassignmentapp.data.network.response.ScheduleResponse
import `in`.`as`.kutukiassignmentapp.databinding.ItemScheduleBinding
import `in`.`as`.kutukiassignmentapp.utils.common.CommonUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
class ScheduleViewHolder(private val itemScheduleBinding: ItemScheduleBinding) : RecyclerView.ViewHolder(itemScheduleBinding.root) {
    fun bindData(dataToBind: ScheduleResponse.Data.ZoomClass) {
        val calendar: Calendar = Calendar.getInstance()
        val dateFormat: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val time: String = dateFormat.format(calendar.time)
        var startTime = dataToBind.startTime
        var endTime = dataToBind.endTime
        itemScheduleBinding.name.text = dataToBind.meetingTopic
        itemScheduleBinding.by.text = dataToBind.faculty
        Glide.with(itemView)
            .load(dataToBind.facultyImage)
            .into(itemScheduleBinding.img)

        val time1 :String? = CommonUtils.formatDate(startTime!!,"HH:mm:ss","hh:mm")
        val time2 :String? = CommonUtils.formatDate(endTime!!,"hh:mm","hh:mm a")
        itemScheduleBinding.dur.text = "$time1-$time2"

        val currentValue = CommonUtils.compTime(
            dataToBind.meetingStartTime,dataToBind.meetingEndTime,time)
        if (currentValue.equals("Live")) {
            itemScheduleBinding.ivImage.setVisibility(View.VISIBLE)
            itemScheduleBinding.ivImageUpcoming.setVisibility(View.GONE)
            itemScheduleBinding.ivImageEnded.setVisibility(View.GONE)
        } else if (currentValue.equals("Upcoming")) {
            itemScheduleBinding.ivImage.setVisibility(View.GONE)
            itemScheduleBinding.ivImageUpcoming.setVisibility(View.VISIBLE)
            itemScheduleBinding.ivImageEnded.setVisibility(View.GONE)
        } else if (currentValue.equals("Ended")) {
            itemScheduleBinding.ivImage.setVisibility(View.GONE)
            itemScheduleBinding.ivImageUpcoming.setVisibility(View.GONE)
            itemScheduleBinding.ivImageEnded.setVisibility(View.VISIBLE)
        }

        itemScheduleBinding.tvLive.text = currentValue


    }

}
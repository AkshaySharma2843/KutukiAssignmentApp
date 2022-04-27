package `in`.`as`.kutukiassignmentapp.data.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
data class ScheduleRequest (
    @SerializedName("batch_id")
    @Expose
    val batch_id :Int?,
    @SerializedName("course_id")
    @Expose
    val course_id :Int?,
    @SerializedName("date")
    @Expose
    val date :String?,
    @SerializedName("day")
    @Expose
    val day :String?,
        )
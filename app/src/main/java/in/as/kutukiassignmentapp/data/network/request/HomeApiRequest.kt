package `in`.`as`.kutukiassignmentapp.data.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
data class HomeApiRequest(
    @SerializedName("apk_version")
    @Expose
    val apk_version : String?,

    @SerializedName("batch_id")
    @Expose
    val batch_id : Int,

    @SerializedName("class_id")
    @Expose
    val class_id : Int?,

    @SerializedName("course_id")
    @Expose
    val course_id : Int?,

    @SerializedName("device_id")
    @Expose
    val device_id : String?,

    @SerializedName("target_id")
    val target_id : Int?
)

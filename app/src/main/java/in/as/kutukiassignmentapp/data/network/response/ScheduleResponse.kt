package `in`.`as`.kutukiassignmentapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
data class ScheduleResponse (
    @SerializedName("status")
    @Expose
    val  status : Int?,
@SerializedName("message")
@Expose
val  message : String?,
@SerializedName("data")
@Expose
val  data : Data?,

        )
{
    data class Data(
        @SerializedName("video")
        @Expose
        val video : List<Object>?,
    @SerializedName("time")
    @Expose
    val  time :String?,
    @SerializedName("notes")
    @Expose
    val notes : List<Object>?,
    @SerializedName("liveclass")
    @Expose
    val liveclass : List<Object>?,
    @SerializedName("zoomclass")
    @Expose
    val zoomclass : List<ZoomClass>,
    ){
        data class ZoomClass(
            @SerializedName("id")
            @Expose
            val  id : Int?,
        @SerializedName("faculty")
        @Expose
        val faculty:String?,
        @SerializedName("meeting_topic")
        @Expose
        val meetingTopic:String?,
        @SerializedName("meetdate")
        @Expose
        val  meetdate:String?,
        @SerializedName("meeting_duration")
        @Expose
        val  meetingDuration:String?,
        @SerializedName("created_on")
        @Expose
        val  createdOn:String?,
        @SerializedName("start_time")
        @Expose
        val  startTime:String?,
        @SerializedName("end_time")
        @Expose
        val  endTime:String?,
        @SerializedName("course_id")
        @Expose
        val  courseId:Int?,
        @SerializedName("class_id")
        @Expose
        val classId :Int?,
        @SerializedName("subject_id")
        @Expose
        val subjectId :Int?,
        @SerializedName("topic_id")
        @Expose
        val  topicId :Int?,
        @SerializedName("batch_id")
        @Expose
        val  batchId : Int?,
        @SerializedName("status")
        @Expose
        val  status : Int?,
        @SerializedName("host_email")
        @Expose
        val hostEmail :String?,
        @SerializedName("start_url")
        @Expose
        val  startUrl :String?,
        @SerializedName("join_url")
        @Expose
        val  joinUrl :String?,
        @SerializedName("password")
        @Expose
        val  password :String?,
        @SerializedName("encrypted_password")
        @Expose
        val encryptedPassword :String?,
        @SerializedName("purchase_status")
        @Expose
        val  purchaseStatus :Int?,
        @SerializedName("zoom_id")
        @Expose
        val  zoomId :String?,
        @SerializedName("zoom_email")
        @Expose
        val  zoomEmail :String?,
        @SerializedName("meeting_start_datetime")
        @Expose
        val  meetingStartDatetime :String?,
        @SerializedName("zoom_uuid")
        @Expose
        val  zoomUuid :String?,
        @SerializedName("sdk_key")
        @Expose
        val  sdkKey  :String?,
        @SerializedName("sdk_secret_key")
        @Expose
        val  sdkSecretKey :String?,
        @SerializedName("api_key")
        @Expose
        val  apiKey : String?,
        @SerializedName("api_secret_key")
        @Expose
        val  apiSecretKey :String?,
        @SerializedName("scheduleTimezoomId")
        @Expose
        val  scheduleTimezoomId :String?,
        @SerializedName("scheduleDayTimeId")
        @Expose
        val  scheduleDayTimeId : String?,
        @SerializedName("zoomId")
        @Expose
        val  zoomId2 :Int?,
        @SerializedName("content_type")
        @Expose
        val  contentType :Int?,
        @SerializedName("subject")
        @Expose
        val  subject : String?,
        @SerializedName("by_upload")
        @Expose
        val  byUpload :String?,
        @SerializedName("faculty_image")
        @Expose
        val  facultyImage :String?,
        @SerializedName("meeting_start_time")
        @Expose
        val  meetingStartTime :String?,
        @SerializedName("meeting_end_time")
        @Expose
        val  meetingEndTime :String?,
        @SerializedName("meeting_course_id")
        @Expose
        val  meetingCourseId :Int?,
        @SerializedName("meeting_class_id")
        @Expose
        val  meetingClassId :Int?,
        @SerializedName("meeting_subject_id")
        @Expose
        val  meetingSubjectId :Int?,
        @SerializedName("meeting_topic_id")
        @Expose
        val  meetingTopicId :Int?,
        @SerializedName("meeting_batch_id")
        @Expose
        val meetingBatchId :Int?,
        @SerializedName("is_paid")
        @Expose
        val  isPaid :Boolean,

        )
    }

}
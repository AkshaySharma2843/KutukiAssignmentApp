package `in`.`as`.kutukiassignmentapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
data class HomeApiResponse(
    @SerializedName("status")
    @Expose
    val status: Int?,
    @SerializedName("message")
    @Expose
    val message: String?,
    @SerializedName("data")
    @Expose
    val data: Data?
) {
    data class Data(
        @SerializedName("user")
        @Expose
        val user: User?,
        @SerializedName("videoURL")
        @Expose
        val videoUrl: List<VideoURL>,
        @SerializedName("lastPlayedVideo")
        @Expose
        val lastPlayedVideo: LastPlayedVideo?,
        @SerializedName("apk")
        @Expose
        val apk: Apk?,
        @SerializedName("Package")
        @Expose
        val packageList: List<PackageList>?,
        @SerializedName("courses")
        @Expose
        val courses: List<Course>?,
        @SerializedName("subject")
        @Expose
        val subject: List<Subject>?,
        @SerializedName("UserProgessDetails")
        @Expose
        val userProgressDetails: UserProgessDetails?,
        @SerializedName("ScheduleWeek")
        @Expose
        val scheduleWeek: List<ScheduleWeek>?,
        @SerializedName("HomeContent")
        @Expose
        val homeContent: List<HomeContent>?
    ) {
        data class User(
            @SerializedName("user_id")
            @Expose
            val userId: Int?,
            @SerializedName("is_academic")
            @Expose
            val isAcademic: Int?,
            @SerializedName("user_name")
            @Expose
            val userName: String?,
            @SerializedName("name")
            @Expose
            val name: String?,
            @SerializedName("dob")
            @Expose
            val dob: String?,
            @SerializedName("gender")
            @Expose
            val gender: String?,
            @SerializedName("mobile")
            @Expose
            val mobile: String?,
            @SerializedName("email")
            @Expose
            val email: String?,
            @SerializedName("image")
            @Expose
            val image: String?,
            @SerializedName("roll_no")
            @Expose
            val rollNo: String?,
            @SerializedName("is_subscribe")
            @Expose
            val isSubscribe: Integer?,
            @SerializedName("created_on")
            @Expose
            val createdOn: String?,
            @SerializedName("exp_damo_date")
            @Expose
            val expDamoDate: String?,
            @SerializedName("last_pay_video_id")
            @Expose
            val lastPayVideoId: Int?,
            @SerializedName("profile_name")
            @Expose
            val profileName: String?,
            @SerializedName("class")
            @Expose
            val _class: String?,
            @SerializedName("class_id")
            @Expose
            val classId: Int?,
            @SerializedName("batch_id")
            @Expose
            val batchId: Int?,
            @SerializedName("batch")
            @Expose
            val batch: String?,
            @SerializedName("address")
            @Expose
            val address: AddressDetails?,
            @SerializedName("targets")
            @Expose
            val targets: List<TargetList>?,
            @SerializedName("UserLastPayVideo")
            @Expose
            val userLastPayVideo: UserLastPayVideo?,
            @SerializedName("UsertargetDetail")
            @Expose
            val usertargetDetail: List<UsertargetDetail>?,
            @SerializedName("is_cps_jee")
            @Expose
            val isCpsJee: Integer?,
            @SerializedName("is_cps_neet")
            @Expose
            val isCpsNeet: Int?
        ) {
            data class AddressDetails(
                @SerializedName("address_id")
                @Expose
                val addressId: Int?,
                @SerializedName("user_id")
                @Expose
                val userId: Int?,
                @SerializedName("state")
                @Expose
                val state: String?,
                @SerializedName("city")
                @Expose
                val city: String?,
                @SerializedName("area")
                @Expose
                val area: Object?,
                @SerializedName("pin_code")
                @Expose
                val pinCode: Object?,
                @SerializedName("address_type")
                @Expose
                val addressType: String?
            )

            data class TargetList(
                @SerializedName("course_id")
                @Expose
                val courseId: Int?,
                @SerializedName("course")
                @Expose
                val course: String?
            )

            data class UserLastPayVideo(
                @SerializedName("video_id")
                @Expose
                val videoId: Int?,
                @SerializedName("subject_id")
                @Expose
                val subjectId: Int?,
                @SerializedName("video_title")
                @Expose
                val videoTitle: String?,
                @SerializedName("video_url")
                @Expose
                val videoUrl: String?,
                @SerializedName("video_duration")
                @Expose
                val videoDuration: String?,
                @SerializedName("is_paid")
                @Expose
                val isPaid: Int?,
                @SerializedName("video_rating")
                @Expose
                val videoRating: String?,
                @SerializedName("thumnail")
                @Expose
                val thumnail: String?
            )

            data class UsertargetDetail(
                @SerializedName("target_id")
                @Expose
                val targetId: Int?,
                @SerializedName("target")
                @Expose
                val target: String?
            )
        }

        data class VideoURL(
            @SerializedName("id")
            @Expose
            val id: Int?,
            @SerializedName("youtube_id")
            @Expose
            val youtubeId: String?,
            @SerializedName("youtube_url")
            @Expose
            val youtubeUrl: String?,
            @SerializedName("created_on")
            @Expose
            val createdOn: String?,
            @SerializedName("status")
            @Expose
            val status: Int?,
            @SerializedName("type")
            @Expose
            val type: String?,
        )

        data class LastPlayedVideo(
            val id: Int?
        )

        data class Apk(
            @SerializedName("message")
            @Expose
            val message: String?,
            @SerializedName("device_authentication")
            @Expose
            val deviceAuthentication: Int?
        )

        data class PackageList(
            @SerializedName("package_id")
            @Expose
            val packageId: Int?,
            @SerializedName("course_id")
            @Expose
            val courseId: Int?,
            @SerializedName("batch_id")
            @Expose
            val batchId: Object,
            @SerializedName("package_name")
            @Expose
            val packageName: String?,
            @SerializedName("amount")
            @Expose
            val amount: String?,
            @SerializedName("discount")
            @Expose
            val discount: String?,
            @SerializedName("duration")
            @Expose
            val duration: String?,
            @SerializedName("active")
            @Expose
            val active: Int?,
            @SerializedName("is_delete")
            @Expose
            val isDelete: Int?,
            @SerializedName("created_on")
            @Expose
            val createdOn: String?,
            @SerializedName("description")
            @Expose
            val description: String?,
            @SerializedName("allow_installment")
            @Expose
            val allowInstallment: String?,
            @SerializedName("icon")
            @Expose
            val icon: String?,
            @SerializedName("course")
            @Expose
            val course: String?,
            @SerializedName("package_include_module")
            @Expose
            val packageIncludeModule: List<Object>?,
            @SerializedName("batch")
            @Expose
            val batch: List<Batch>?,
            @SerializedName("is_subscribe")
            @Expose
            val isSubscribe: Boolean?,
            @SerializedName("final_amount")
            @Expose
            val finalAmount: String?,
        ) {
            data class Batch(
                @SerializedName("batch")
                @Expose
                val batch: String?,
            )
        }

        data class Course(
            @SerializedName("course_id")
            @Expose
            val courseId: Int?,
            @SerializedName("course")
            @Expose
            val course: String,
            @SerializedName("icon")
            @Expose
            val icon: String,
            @SerializedName("batch")
            @Expose
            val batch: List<Batch__1>?,
        ) {
            data class Batch__1(
                @SerializedName("batch_id")
                @Expose
                val batchId: Int?,
                @SerializedName("batch")
                @Expose
                val batch: String,
            )
        }

        data class Subject(
            @SerializedName("sub_id")
            @Expose
            val subId: Int?,
            @SerializedName("sub_name")
            @Expose
            val subName: String?,
            @SerializedName("icon")
            @Expose
            val icon: String?,
            @SerializedName("is_show_others")
            @Expose
            val isShowOthers: Int?,
        )

        data class UserProgessDetails(
            @SerializedName("user_total_test")
            @Expose
            val userTotalTest: Int?,
            @SerializedName("userdatacorrect")
            @Expose
            val userdatacorrect: Int?,
            @SerializedName("userdataincorrect")
            @Expose
            val userdataincorrect: Int?,
            @SerializedName("total_questions_marks")
            @Expose
            val totalQuestionsMarks: Int?,
            @SerializedName("user_total_marks")
            @Expose
            val userTotalMarks: Int?,
            @SerializedName("userdataunattempt")
            @Expose
            val userdataunattempt: Int,
            @SerializedName("user_total_percentage")
            @Expose
            val userTotalPercentage: Int?
        )

        data class ScheduleWeek(
            @SerializedName("date")
            @Expose
            val date: String?,
            @SerializedName("day")
            @Expose
            val day: String?,
        )

        data class HomeContent(
            @SerializedName("title")
            @Expose
            val title: String?,
            @SerializedName("content")
            @Expose
            val content: String?,
            @SerializedName("img")
            @Expose
            val img: String?
        )
    }

}
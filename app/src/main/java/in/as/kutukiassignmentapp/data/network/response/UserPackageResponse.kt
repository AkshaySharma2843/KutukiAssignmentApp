package `in`.`as`.kutukiassignmentapp.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 20-04-2022.
 */
data class UserPackageResponse(
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
        @SerializedName("past")
        @Expose
        val past: List<Current?>?,
        @SerializedName("current")
        @Expose
        val current: List<Current>?
    ) {
        data class Current(

            @SerializedName("user_transaction_id")
            @Expose
            private var userTransactionId: Int?,
            @SerializedName("package_id")
            @Expose
            private val packageId: Int?,

            @SerializedName("user_id")
            @Expose
            private val userId: Int?,

            @SerializedName("course_id")
            @Expose
            private val courseId: Int?,

            @SerializedName("batch_id")
            @Expose
            private val batchId: Int?,

            @SerializedName("txnid")
            @Expose
            private val txnid: String?,

            @SerializedName("txn_amount")
            @Expose
            private val txnAmount: String?,

            @SerializedName("txn_discount_amount")
            @Expose
            private val txnDiscountAmount: String?,

            @SerializedName("txn_date")
            @Expose
            private val txnDate: String?,

            @SerializedName("package_duration")
            @Expose
            private val packageDuration: String?,

            @SerializedName("status")
            @Expose
            private val status: Int?,

            @SerializedName("is_delete")
            @Expose
            private val isDelete: Int?,

            @SerializedName("txn_expire_date")
            @Expose
            private val txnExpireDate: String?,

            @SerializedName("paid_type")
            @Expose
            private val paidType: Int?,

            @SerializedName("package_name")
            @Expose
            private val packageName: String?,

            @SerializedName("coursename")
            @Expose
            private val coursename: String?
        )
    }
}

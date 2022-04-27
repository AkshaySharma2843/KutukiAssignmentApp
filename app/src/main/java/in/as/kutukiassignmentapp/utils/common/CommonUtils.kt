package `in`.`as`.kutukiassignmentapp.utils.common

import android.text.TextUtils
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Akshay Sharma on 21-04-2022.
 */
object CommonUtils {

    fun compTime(timeStart: String?, timeClose: String?, timeCurrent: String?): String? {
        var output = ""
        val formatter = SimpleDateFormat("HH:mm")
        var start: Date? = null
        var end: Date? = null
        var current: Date? = null
        try {
            Log.d("xxxxxx", formatter.parse(timeStart).toString())
            Log.d("xxxxxx", formatter.parse(timeClose).toString())
            Log.d("xxxxxx", formatter.parse(timeCurrent).toString())
            start = formatter.parse(timeStart)
            end = formatter.parse(timeClose)
            current = formatter.parse(timeCurrent)
            output = if (current.after(start) && current.before(end)) {
                "Live"
            } else if (current.after(end)) {
                "Ended"
            } else if (current.before(start)) {
                "Upcoming"
            } else {
                "Live"
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return output
    }

    fun formatDate(timestamp: String, inputFormat: String?, outputFormat: String?): String? {
        val oneWayTripDate: Date
        var formatedDate = ""
        if (!TextUtils.isEmpty(timestamp)) {
            try {
                val time = timestamp.split(" ").toTypedArray()
                val input = SimpleDateFormat(inputFormat)
                val output = SimpleDateFormat(outputFormat)
                oneWayTripDate = input.parse(time[0])
                formatedDate = output.format(oneWayTripDate)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return formatedDate
    }
}
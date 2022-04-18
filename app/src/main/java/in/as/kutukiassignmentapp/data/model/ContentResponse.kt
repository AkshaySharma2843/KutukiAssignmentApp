package `in`.`as`.kutukiassignmentapp.data.model

/**
 * Created by Akshay Sharma on 04-04-2022.
 */
data class ContentResponse(

    val code : Int,
    val response : VideoResponse
)


data class VideoResponse(
    var videos : Map<String, VideoDetails>
)

data class VideoDetails(
    var title : String,
    var description : String,
    var thumbnailURL : String,
    var videoURL  : String,
    var categories : Any?

)
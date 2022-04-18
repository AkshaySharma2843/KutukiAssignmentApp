package `in`.`as`.kutukiassignmentapp.ui.content

import `in`.`as`.kutukiassignmentapp.data.model.VideoDetails

interface ContentCallback {

    fun onVideoClicked(videoDetails: VideoDetails)
}
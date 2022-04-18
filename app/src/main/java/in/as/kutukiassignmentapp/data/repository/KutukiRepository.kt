package `in`.`as`.kutukiassignmentapp.data.repository

import `in`.`as`.kutukiassignmentapp.data.network.NetworkService
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 31-03-2022.
 */
class KutukiRepository @Inject constructor(val apiService : NetworkService)
{

    fun getCategories() = apiService.getCategory(buildUrl())
    fun getVideosList() = apiService.getVideoList(buildVideoUrl())

    private fun buildVideoUrl() = "http://www.mocky.io/v2/5e2beb5a3100006600267e4e"

    private fun buildUrl(): String  = "http://www.mocky.io/v2/5e2bebd23100007a00267e51"
}
package `in`.`as`.kutukiassignmentapp.data.model

import java.io.Serializable

/**
* Created by Akshay Sharma on 01-04-2022.
*/
data class CategoryResponse(

    var code : Int,
    var response : Response
)

data class Response (
    var videoCategories : Map<String, Categories>
    )


data class Categories(
    var name : String,
    var image : String
) :Serializable
package Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@kotlinx.serialization.Serializable
//data class ApiResponseSample(
//    @SerialName("products")
//    var list: List<Products>
//)
//@Serializable
//data class Products (
//    @SerialName("id")
//    var id: Int=0,
//    @SerialName("title")
//    var title: String="",
//    @SerialName("description")
//    val description: String="",
//    @SerialName("price")
//    val price: Double=0.0,
//    @SerialName("discountPercentage")
//    val discountPercentage: Double=0.0,
//    @SerialName("category")
//    val category: String="",
//    @SerialName("thumbnail")
//    val thumbnail: String="",
//)
//
//@Serializable
//data class ApiResponse(
//    @SerialName("meal_category")
//    val list: List<MealCategory>
//)
//
//
//@Serializable
//data class MealCategory(
//    @SerialName("id")
//    val idCategory: String,
//    @SerialName("category")
//    val strCategory: String,
//    @SerialName("description")
//    val strCategoryDescription: String,
//    @SerialName("thumbnail")
//    val strCategoryThumb: String
//)



@Serializable
data class ApiResponse(
    @SerialName("products")
    var list: List<Products>
)
@Serializable
data class Products (
    @SerialName("id")
    var id: Int=0,
    @SerialName("title")
    var title: String="",
    @SerialName("description")
    val description: String="",
    @SerialName("price")
    val price: Double=0.0,
    @SerialName("discountPercentage")
    val discountPercentage: Double=0.0,
    @SerialName("category")
    val category: String="",
    @SerialName("thumbnail")
    val thumbnail: String="",
)
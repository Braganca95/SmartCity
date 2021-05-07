package a23227.smartcity.api

data class Report (
    val id: Int,
    val titulo: String,
    val descricao: String,
    val latitude: String,
    val longitude: String,
    val imagem: String,
    val user_id: Int,
    val type_id: Int
)
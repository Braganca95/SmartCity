package a23227.smartcity.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("api/users")
    fun getUsers(): Call<List<User>>

    @GET("api/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>


    @FormUrlEncoded
    @POST("api/login")
    fun login(@Field("username") username: String,
              @Field("password") password: String): Call<User>

    @GET("api/reports")
    fun getReports(): Call<List<Report>>

    @GET("api/reports/{api}")
    fun getReportsById(@Path("id")id: Int): Call<Report>

    @Multipart
    @POST("addReport")
    fun addReport(
        @Part("title") title: RequestBody,
        @Part("description") description: RequestBody,
        @Part("latitude") latitude: RequestBody,
        @Part("longitude") longitude: RequestBody,
        @Part image: MultipartBody.Part,
        @Part("user_id") user_id: Int?,
        @Part("type_id") type_id: Int?
    ): Call<OutputReport>

    @FormUrlEncoded
    @POST("deleteReport")
    fun deleteReport(@Field("id") first: Int?): Call<Report>

    @FormUrlEncoded
    @POST("editReport")
    fun editReport(
        @Field("id") first: Int?,
        @Field("title") second: String?,
        @Field("description") third: String?
    ): Call<String>


    @GET("reports/users/{id}")
    fun getUserRep(@Path("id") id: Int): Call<List<Report>>

}
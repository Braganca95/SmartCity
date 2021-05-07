package a23227.smartcity.api

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

}
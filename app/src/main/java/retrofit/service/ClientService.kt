package retrofit.service

import retrofit.model.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientService {

    @GET("client")
    fun list(): Call<List<Client>>

    @POST("client")
    fun insert(@Body client: Client): Call<Client>

}
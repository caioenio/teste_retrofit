package retrofit.service

import retrofit.model.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientService {

    @POST("client")
    fun insert(@Body client: Client): Call<Client>

}
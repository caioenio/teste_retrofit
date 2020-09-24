package retrofit

import retrofit.service.ClientService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.11.1:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun clientservice() : ClientService = retrofit.create(ClientService::class.java)
}
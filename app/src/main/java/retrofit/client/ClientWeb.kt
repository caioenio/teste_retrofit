package retrofit.client

import retrofit.model.Client
import retrofit.RetrofitInitializer
import retrofit.callback

class ClientWeb {

    fun insert(
        client: Client, success: (client: Client) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val call = RetrofitInitializer().clientservice().insert(client)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }
}
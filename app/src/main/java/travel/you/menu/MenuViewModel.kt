package travel.you.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import travel.you.App
import travel.you.util.Util

class MenuViewModel() : ViewModel() {

    val places : MutableLiveData<List<Place>> = MutableLiveData()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(App.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService: AppService = RetrofitClient.getClient(App.URL).create(AppService::class.java)
        retrofitService.getPlaces().enqueue(object : Callback<List<Place>> {
            override fun onFailure(call: Call<List<Place>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                places.value = response.body()
            }
        })
    }

}

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}

interface AppService {
    @GET("places")
    fun getPlaces(): Call<List<Place>>
}
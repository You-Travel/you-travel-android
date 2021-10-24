package travel.you.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import travel.you.util.Util

class MenuViewModel() : ViewModel() {

    val places : LiveData<List<Place>> = MutableLiveData()

    init {
        Retrofit.Builder()
            .baseUrl(Util.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

interface AppService {
    @GET("places")
    fun listRepos(@Path("user") user: String?): Call<List<Place>>
}
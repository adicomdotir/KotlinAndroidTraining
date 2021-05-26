package ir.adicom.app.beginneridea.training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.coroutine.Repo
import ir.adicom.app.beginneridea.coroutine.RetrofitClient
import ir.adicom.app.beginneridea.coroutine.Webservice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class TrainingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_training)

        val githubRepository = GithubRepository()
        CoroutineScope(Dispatchers.Default).launch {
            githubRepository.getTodo().take(5).forEach {
                Log.e("TAGB", "${it.id} - ${it.name}")
            }

        }
    }
}

interface WebApi {
    @GET("/users/adicomdotir/repos")
    suspend fun getRepos(): List<Repo>
}

class MyRetrofitClient {
    companion object {
        val retrofit: WebApi = Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebApi::class.java)
    }
}

class GithubRepository {

    private var client: WebApi = MyRetrofitClient.retrofit

    suspend fun getTodo() = client.getRepos()
}
package ir.adicom.app.beginneridea.github

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.coroutine.Repo
import kotlinx.android.synthetic.main.activity_github.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class GithubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        val retrofit= Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation()))
            .build()

        val githubApiService = retrofit.create(GithubApiService::class.java)
        githubApiService.getUserInformation()
            .observeOn(Schedulers.computation())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<GithubUser> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    println("Init")
                    runOnUiThread {
                        tv_info.text = resources.getText(R.string.loading)
                    }
                }

                override fun onNext(t: GithubUser) {
                    println(t.toString())



                    runOnUiThread {
                        tv_name.text = t.name
                        Glide.with(applicationContext).load(t.avatar_url).into(iv_avatar)
                        runOnUiThread {
                            tv_info.text = resources.getText(R.string.status)
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    println("OnError" + e.message)
                    runOnUiThread {
                        tv_info.text = resources.getText(R.string.error_message)
                    }
                }

            })
    }
}


interface GithubApiService {
    @GET("adicomdotir")
    fun getUserInformation(): Observable<GithubUser>

    @GET("adicomdotir/repos")
    fun getRepo(): Observable<List<Repo>>
}

data class GithubUser (
    val login : String,
    val id : Int,
    val node_id : String,
    val avatar_url : String,
    val gravatar_id : String,
    val url : String,
    val html_url : String,
    val followers_url : String,
    val following_url : String,
    val gists_url : String,
    val starred_url : String,
    val subscriptions_url : String,
    val organizations_url : String,
    val repos_url : String,
    val events_url : String,
    val received_events_url : String,
    val type : String,
    val site_admin : Boolean,
    val name : String,
    val company : String,
    val blog : String,
    val location : String,
    val email : String,
    val hireable : String,
    val bio : String,
    val twitter_username : String,
    val public_repos : Int,
    val public_gists : Int,
    val followers : Int,
    val following : Int,
    val created_at : String,
    val updated_at : String
)
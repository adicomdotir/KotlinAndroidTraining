package ir.adicom.app.beginneridea.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ir.adicom.app.beginneridea.R
import ir.adicom.app.beginneridea.coroutine.Repo
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
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<GithubUser> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    println("Not yet implemented")
                }

                override fun onNext(t: GithubUser) {
                    println(t.toString())
                }

                override fun onError(e: Throwable) {
                    println("OnError" + e.message)
                }

            })

        githubApiService.getRepo()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Repo>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: List<Repo>) {
                    println(t.size)
                }

                override fun onError(e: Throwable) {
                    println("OnError" + e.message)
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
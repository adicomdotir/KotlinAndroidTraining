package ir.adicom.app.beginneridea.coroutine

class GithubRepository {

    var client: Webservice = RetrofitClient.retrofit

    suspend fun getTodo() = client.getRepos()
}
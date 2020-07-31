package ir.adicom.app.beginneridea.coroutine

import retrofit2.http.GET

interface Webservice {
    @GET("/users/adicomdotir/repos")
    suspend fun getRepos(): List<Repo>
}
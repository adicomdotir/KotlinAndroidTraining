package ir.adicom.app.beginneridea.quiz

class Score {
    var id: Int = 0
    var username: String = ""
    var score: Int = 0

    fun setScore(id: Int, username: String, score: Int) {
        this.id = id
        this.username = username
        this.score = score
    }
}

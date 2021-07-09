package ir.adicom.app.beginneridea.retrofitwithdagger;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApiService {
    @GET("users")
    Observable<List<CustomUser>> getUsers();
}

package ir.adicom.app.beginneridea.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ir.adicom.app.beginneridea.R;
import ir.adicom.app.beginneridea.coroutine.Repo;
import ir.adicom.app.beginneridea.github.GithubApiService;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        final String[] listFirst = {"A1", "A2", "A3", "A4"};
        final String[] listSecond = {"B1", "B2", "B3"};

        final Observable<String> observableFirst = Observable.fromArray(listFirst).delay(2500, TimeUnit.MILLISECONDS);
        final Observable<String> observableSecond = Observable.fromArray(listSecond).delay(750, TimeUnit.MILLISECONDS);

        Observable.merge(observableFirst, observableSecond).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d("TAG", "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
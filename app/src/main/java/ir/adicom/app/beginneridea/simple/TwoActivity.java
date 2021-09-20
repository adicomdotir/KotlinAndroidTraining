package ir.adicom.app.beginneridea.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ir.adicom.app.beginneridea.R;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        findViewById(R.id.btn_two_to_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutoMobile autoMobile = new AutoMobile("Toyota", "Corolla");
                Intent intent = new Intent();
                intent.putExtra("auto", autoMobile);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }
}
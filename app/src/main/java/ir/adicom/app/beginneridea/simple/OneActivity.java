package ir.adicom.app.beginneridea.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ir.adicom.app.beginneridea.R;

public class OneActivity extends AppCompatActivity {

    private TextView tvCounter;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("cnt");
        }

        tvCounter = findViewById(R.id.tv_counter);
        tvCounter.setText("" + counter);

        findViewById(R.id.btn_one_to_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(OneActivity.this, TwoActivity.class), 111);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("cnt", counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 111 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                AutoMobile autoMobile = (AutoMobile) data.getSerializableExtra("auto");
                counter++;
                tvCounter.setText("" + counter);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
package ir.adicom.app.beginneridea.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import ir.adicom.app.beginneridea.R;

public class TwoActivity extends AppCompatActivity {
    private EditText edtCountry;
    private EditText edtFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        edtCountry = findViewById(R.id.edt_country);
        edtFullName = findViewById(R.id.edt_fullname);

        findViewById(R.id.btn_two_to_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String fullName = edtFullName.getText().toString();
                String country = edtCountry.getText().toString();
                Player player = new Player(fullName, country);
                intent.putExtra("player", player);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }
}
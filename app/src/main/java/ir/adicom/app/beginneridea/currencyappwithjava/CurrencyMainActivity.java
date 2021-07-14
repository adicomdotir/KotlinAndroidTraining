package ir.adicom.app.beginneridea.currencyappwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import ir.adicom.app.beginneridea.R;

public class CurrencyMainActivity extends AppCompatActivity {
    @Inject
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_main);

        ((BaseApplication) getApplication()).getSharedComponent().inject(this);

        EditText edtKey = findViewById(R.id.edt_key);
        findViewById(R.id.btn_key).setOnClickListener(view -> {
            if (edtKey.getText().length() == 0) {
                Toast.makeText(this, "Please Enter Api Key", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("APIKEY", edtKey.getText().toString());
                editor.apply();

                startActivity(new Intent(CurrencyMainActivity.this, HomeActivity.class));
            }
        });

    }
}
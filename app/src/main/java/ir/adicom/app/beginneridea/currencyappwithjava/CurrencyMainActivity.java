package ir.adicom.app.beginneridea.currencyappwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ir.adicom.app.beginneridea.R;

public class CurrencyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_main);

        startActivity(new Intent(CurrencyMainActivity.this, HomeActivity.class));
    }
}
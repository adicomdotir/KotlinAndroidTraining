package ir.adicom.app.beginneridea.currencyappwithjava.ui.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import ir.adicom.app.beginneridea.R;
import ir.adicom.app.beginneridea.currencyappwithjava.BaseApplication;

public class HomeCurrencyFragment extends Fragment {

    @Inject
    public SharedPreferences sharedPreferences;
    private TextView txtApiKey;

    public HomeCurrencyFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((BaseApplication) getActivity().getApplication()).getSharedComponent().inject(this);

        return inflater.inflate(R.layout.fragment_home_currency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtApiKey = view.findViewById(R.id.txt_api_key);
        String apiKey = sharedPreferences.getString("APIKEY", "001122");
        txtApiKey.setText(apiKey);
    }
}
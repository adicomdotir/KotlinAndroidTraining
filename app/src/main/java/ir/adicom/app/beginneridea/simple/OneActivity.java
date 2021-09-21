package ir.adicom.app.beginneridea.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.adicom.app.beginneridea.R;

public class OneActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 111;
    private List<Player> playerList = new ArrayList<>();
    private PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        findViewById(R.id.btn_one_to_two).setOnClickListener(view -> startActivityForResult(new Intent(OneActivity.this, TwoActivity.class), REQUEST_CODE));
        RecyclerView recyclerView = findViewById(R.id.rv_player);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        playerAdapter = new PlayerAdapter(playerList);
        recyclerView.setAdapter(playerAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Player player = (Player) data.getSerializableExtra("player");
                playerAdapter.addPlayer(player);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
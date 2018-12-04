package pl.kwiateksoft.pilkarskiebingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
    }
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.hajto:
                Intent intent = new Intent(ListActivity.this, Game.class);
                startActivity(intent);
                break;


        }

    }
}

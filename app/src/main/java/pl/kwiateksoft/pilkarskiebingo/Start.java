package pl.kwiateksoft.pilkarskiebingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.play:
                intent = new Intent(Start.this, ListActivity.class);
                startActivity(intent);
                break;

            case R.id.create:
                intent = new Intent(Start.this, Create.class);
                startActivity(intent);
                break;

            case R.id.info:
                break;

            case R.id.report:
                break;
        }

    }
}

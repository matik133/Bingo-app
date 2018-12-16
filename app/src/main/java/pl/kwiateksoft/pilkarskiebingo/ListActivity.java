package pl.kwiateksoft.pilkarskiebingo;

import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class ListActivity extends AppCompatActivity {

    Database db;
    TextView showGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        showGames = (TextView) findViewById(R.id.GamesListView);
        if (db==null){
            db = new Database(this);
        }

        /*
        metoda wyświetlająca zawartość bazy (lista plansz lub tekstów)
         */
        SQLiteCursor kursor = db.getData();
            if (kursor.getCount()>0) {
                StringBuffer buff = new StringBuffer();
                while (kursor.moveToNext()){
                    buff.append("ID: " + kursor.getString(0) + "\n");
                    buff.append("Autor: " + kursor.getString(1) + "\n");
                    buff.append("Tekst: " + kursor.getString(2) + "\n");
                }
                //typeData("Dane z bazy", buff.toString());
                //dataView.setText(kursor.toString());
                showGames.setText(buff.toString());

                //Toast.makeText(Game.this, "Dane z bazy", Toast.LENGTH_LONG).show();
            }
            else
                showGames.setText("Brak wyników");
                //Toast.makeText(Game.this, "Nie można pobrać", Toast.LENGTH_LONG).show();



    }

    /*
    Przekierowanie do widoków za pomocą buttonów
     */
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()){
            case R.id.hajto:
                intent = new Intent(ListActivity.this, Game.class);
                startActivity(intent);
                break;

            case R.id.manageButton:

                break;


        }

    }
}

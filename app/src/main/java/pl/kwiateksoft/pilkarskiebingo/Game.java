package pl.kwiateksoft.pilkarskiebingo;

import android.database.sqlite.SQLiteCursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    Database db;
    Button insert, show;
    EditText autor, sentence;
    TextView dataView;
    TextView t;
    boolean isClicked;
    List<TextView> fieldsList = new ArrayList<>();
    List<String> bingoWordList = new LinkedList<>(Arrays.asList("text1", "text2","text3","text4","text5","text6","text7","text8","text9","text10","text11","text12","text13","text14","text15","text16","text17","text18","text19","text20","text21","text22","text23","text24","text25"));

    public void typeData (String tittle, String message){
        AlertDialog.Builder list = new AlertDialog.Builder(this);
        list.setMessage(message);
        list.setTitle(tittle);
        list.show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (db==null){
            db = new Database(this);
        }
        insert = (Button) findViewById(R.id.saveButton);
        show = (Button) findViewById(R.id.showButton);
        autor = (EditText) findViewById(R.id.autorField);
        sentence = (EditText) findViewById(R.id.sentenceField);
        dataView = (TextView) findViewById(R.id.showButton);

        fillFieldsList(); //wywołanie metody uzupełniającej listę i pola


        /*
        wyświetlanie zawartości bazy (lista plansz lub tekstów)
         */
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteCursor kursor = db.getData();
                if (kursor.getCount()>0) {
                    StringBuffer buff = new StringBuffer();
                    while (kursor.moveToNext()){
                        buff.append("ID: " + kursor.getString(0) + "\n");
                        buff.append("Autor: " + kursor.getString(1) + "\n");
                        buff.append("Tekst: " + kursor.getString(2) + "\n");
                    }
                    typeData("Dane z bazy", buff.toString());
                    //dataView.setText(kursor.toString());
                    Toast.makeText(Game.this, "Dane z bazy", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Game.this, "Nie można pobrać", Toast.LENGTH_LONG).show();
            }
        });



        /*
        metoda zapisu do bazy danych
         */
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSuccess;
                isSuccess = db.instertData(autor.getText().toString(), sentence.getText().toString());
                if (isSuccess==true){
                    Toast.makeText(Game.this, "Udało się", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Game.this, "Nie udało się", Toast.LENGTH_LONG).show();
            }
        });


    }

    /*
    uzupełnienie listy tekstów (tmp)
     */
    public void fillFieldsList (){
        fieldsList.add((TextView)findViewById(R.id.field1));
        fieldsList.add((TextView)findViewById(R.id.field2));
        fieldsList.add((TextView)findViewById(R.id.field3));
        fieldsList.add((TextView)findViewById(R.id.field4));
        fieldsList.add((TextView)findViewById(R.id.field5));
        fieldsList.add((TextView)findViewById(R.id.field6));
        fieldsList.add((TextView)findViewById(R.id.field7));
        fieldsList.add((TextView)findViewById(R.id.field8));
        fieldsList.add((TextView)findViewById(R.id.field9));
        fieldsList.add((TextView)findViewById(R.id.field10));
        fieldsList.add((TextView)findViewById(R.id.field11));
        fieldsList.add((TextView)findViewById(R.id.field12));
        fieldsList.add((TextView)findViewById(R.id.field13));
        fieldsList.add((TextView)findViewById(R.id.field14));
        fieldsList.add((TextView)findViewById(R.id.field15));
        fieldsList.add((TextView)findViewById(R.id.field16));
        fieldsList.add((TextView)findViewById(R.id.field17));
        fieldsList.add((TextView)findViewById(R.id.field18));
        fieldsList.add((TextView)findViewById(R.id.field19));
        fieldsList.add((TextView)findViewById(R.id.field20));
        fieldsList.add((TextView)findViewById(R.id.field21));
        fieldsList.add((TextView)findViewById(R.id.field22));
        fieldsList.add((TextView)findViewById(R.id.field23));
        fieldsList.add((TextView)findViewById(R.id.field24));
        fieldsList.add((TextView)findViewById(R.id.field25));
        fillFields();
    }

    /*
    metoda uzupełniająca pola bingo tekstami z listy (będzie z bazy)
     */
    public void fillFields(){

        List<String> bingoWordList2=bingoWordList; //lista zapasowa do usuwania elementów
        Random generator = new Random();

        for (TextView field : fieldsList)
        {
            int sizeOfList = bingoWordList2.size();
            int pick = generator.nextInt(sizeOfList);
            field.setText(bingoWordList2.get(pick));
            bingoWordList2.remove(pick);

        }
    }

    public void onClick(View view) {
        String test = view.getResources().getResourceEntryName(view.getId());
        TextView t = findViewById(view.getId());
        t.setText("SPRAWDZAM");
        Toast.makeText(this, test, Toast.LENGTH_LONG).show();

        switch (view.getId()) {
            case R.id.field1:
                t= findViewById(R.id.field1);
                t.setBackgroundColor(Color.RED);
                //t.setText("DUPA");

                break;
            case R.id.field2:
                // do something else
                break;
            case R.id.field3:
                // i'm lazy, do nothing
                break;
            case R.id.field4:
                // do something else
                break;
            case R.id.field5:
                // i'm lazy, do nothing
                break;
        }



    }
}

package pl.kwiateksoft.pilkarskiebingo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView t;
    boolean isClicked;
    List<TextView> fieldsList = new ArrayList<>();
    List<String> bingoWordList = new LinkedList<>(Arrays.asList("text1", "text2","text3","text4","text5","text6","text7","text8","text9","text10","text11","text12","text13","text14","text15","text16","text17","text18","text19","text20","text21","text22","text23","text24","text25"));


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



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

        t = (TextView)findViewById( R.id.field1);




        if (isClicked==false){
            for (TextView field : fieldsList)
            {
                field.setBackgroundColor(Color.BLUE);

            }
            isClicked=true;
            t.setText("Clicked");
        }
        else {
            for (TextView field : fieldsList)
            {
                field.setBackgroundColor(Color.RED);

            }
            t.setText("Click me");
            isClicked=false;
        }


    }
}

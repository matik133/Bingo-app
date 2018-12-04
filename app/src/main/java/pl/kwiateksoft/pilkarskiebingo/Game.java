package pl.kwiateksoft.pilkarskiebingo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView t;
    String text_click;
    String text_default;
    boolean isClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void onClick(View view) {

        t = (TextView)findViewById( R.id.textView5);
        String text = (String) t.getText();

        if (isClicked==false){
            t.setBackgroundColor(Color.RED);
            isClicked=true;
            t.setText("Clicked");
        }
        else {
            t.setBackgroundColor(Color.BLUE);
            t.setText("Click me");
            isClicked=false;
        }

    }
}

package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */
    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView Score;
    private static final String TAG = "Whack-A-Mole!";
    int scoreText = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Score = (TextView) findViewById(R.id.Score);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button 1 clicked!");
                if(ButtonLeft.getText().toString().equals("*"))
                {
                    Log.v(TAG,"Hit, score added!");
                    scoreText = scoreText + 1;
                }
                else{
                    Log.v(TAG,"Missed point deducted!");
                    scoreText = scoreText - 1;
                }
                setNewMole();
                Score.setText("" + scoreText);
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button 2 clicked!");
                if(ButtonMiddle.getText().toString().equals("*"))
                {
                    Log.v(TAG,"Hit, score added!");
                    scoreText = scoreText + 1;
                }
                else{
                    Log.v(TAG,"Missed point deducted!");
                    scoreText = scoreText - 1;
                }
                setNewMole();
                Score.setText("" + scoreText);
            }
        });


        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Log.v(TAG, "Button 3 clicked!");
                if(ButtonRight.getText().toString().equals("*"))
                {
                    Log.v(TAG,"Hit, score added!");
                    scoreText = scoreText + 1;
                }
                else{
                    Log.v(TAG,"Missed point deducted!");
                    scoreText = scoreText - 1;
                }
                setNewMole();
                Score.setText("" + scoreText);
            }
        });

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"Paused GUI!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"Stopped!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"Destroyed!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"Resumed!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if(randomLocation == 0) {
            ButtonLeft.setText("*");
            ButtonMiddle.setText("O");
            ButtonRight.setText("O");
        }
        else if(randomLocation == 1) {
            ButtonLeft.setText("O");
            ButtonMiddle.setText("*");
            ButtonRight.setText("O");
        }
        else if(randomLocation == 2) {
            ButtonLeft.setText("O");
            ButtonMiddle.setText("O");
            ButtonRight.setText("*");
        }
    }
}

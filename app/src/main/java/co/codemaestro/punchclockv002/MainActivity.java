package co.codemaestro.punchclockv002;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Handler;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {


    TextView textView ;
    Button start, pause, reset, lap ;
    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;
    Handler handler;
    int Seconds, Minutes, MilliSeconds ;

    //Required for putExtras
    public final static String TIME_MAIN = "co.codemaestro.punchclockv002.MESSAGE";
    public final static String CATEGORY_NAME = "co.codemaestro.punchclockv002.MESSAGE";
    public final static String TIME_BANK_NAME = "co.codemaestro.punchclockv002.MESSAGE";
    public final static String CURRENT_TIME = "co.codemaestro.punchclockv002.MESSAGE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning reference variables for interface
        textView = findViewById(R.id.timerView);
        start = findViewById(R.id.startButton);
        pause = findViewById(R.id.pauseButton);
        reset = findViewById(R.id.resetButton);
        //Assigning Handler
        handler = new Handler() ;


    }

    //Starts timeMain value counting
    public void startButton(View view) {

        StartTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        reset.setEnabled(false);
    }

    //Stops the timeMain as is
    //Changes startButton text to "Resume"
    public void pauseButton(View view) {

        TimeBuff += MillisecondTime;
        handler.removeCallbacks(runnable);
        reset.setEnabled(true);
    }

    //Asks the User if they are sure they want to reset
    //If yes reset timeMain to 00:00:00
    //If no, back to MainActivity
    public void resetButton(View view) {

        MillisecondTime = 0L ;
        StartTime = 0L ;
        TimeBuff = 0L ;
        UpdateTime = 0L ;
        Seconds = 0 ;
        Minutes = 0 ;
        MilliSeconds = 0 ;
        textView.setText(R.string.time_main_at_zero);
    }

    //StopWatch Logic
    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
            UpdateTime = TimeBuff + MillisecondTime;
            Seconds = (int) (UpdateTime / 1000);
            Minutes = Seconds / 60;
            Seconds = Seconds % 60;
            MilliSeconds = (int) (UpdateTime % 1000);
            textView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));
            handler.postDelayed(this, 0);
        }
    };

    //Save Time Button
    //Starts timeDataBase Activity Class
    //Passes the CATEGORY_NAME, TIME_BANK_NAME, TIME_MAIN extras to the next activity
    //TimeDataBase must be able to accept these extras for a RecyclerView
    public void startTimeDatabase(View view) {
        Intent startTimeDataBase = new Intent(this, timeDatabase.class);
        startTimeDataBase.putExtra("CATEGORY_NAME", category);
        startTimeDataBase.putExtra("TIME_BANK_MAIN", timeBankName);
        startTimeDataBase.putExtra("CURRENT TIME", MilliSeconds);
        startActivity(startTimeDataBase);
    }
}

package co.codemaestro.punchclockv002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;


public class timeDatabase extends AppCompatActivity {

    Long millisecondsTime;
    String category, timeBankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_database);

        Intent turnMeOn = getIntent();
        timeBankName = turnMeOn.getStringExtra("TIME_BANK_NAME");
        category = turnMeOn.getStringExtra("CATEGORY_NAME");
        millisecondsTime = turnMeOn.getLongExtra("CURRENT_TIME", 0L);

    }
}

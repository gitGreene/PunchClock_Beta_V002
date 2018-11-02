package co.codemaestro.punchclockv002;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class TimeTable extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        recyclerView = findViewById(R.id.timeRecyclerView);

        Intent turnMeOn = getIntent();
        String category = turnMeOn.getStringExtra("CATEGORY_NAME");
        String savedTime = turnMeOn.getStringExtra("CURRENT_TIME");


        TimeDatabase db = Room.databaseBuilder(getApplicationContext(), TimeDatabase.class, "placeholder")
                .allowMainThreadQueries()
                .build();

        TimeData timeData = new TimeData(savedTime, category);
        db.timeDataDao().insertAll(timeData);


        List<TimeData> timeDatabase = db.timeDataDao().getAllData();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TimeTableAdapter(timeDatabase);
        recyclerView.setAdapter(adapter);


    }


    public void NUKE(View view) {
    }
}

package co.codemaestro.punchclockv002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

// Refactor the name to "TimeDataBase" with the right caps
public class timeDatabase extends AppCompatActivity {

    String category, timeBankName, savedTime;
    private final LinkedList<String> myDataSet = new LinkedList<>();
    private RecyclerView myRecyclerView;
    private TimeDatabaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_database);

        Intent turnMeOn = getIntent();
        //timeBankName = turnMeOn.getStringExtra("TIME_BANK_NAME");
        //category = turnMeOn.getStringExtra("CATEGORY_NAME");
        savedTime = turnMeOn.getStringExtra("CURRENT_TIME");

        // Put data in the list "Dataset" as a String
        myDataSet.addLast(savedTime);

        myRecyclerView = findViewById(R.id.timeRecyclerView);

        //Create an adapter then supply the data
        myAdapter = new TimeDatabaseAdapter(this, myDataSet);

        // Connects the adapter to the RecView
        myRecyclerView.setAdapter(myAdapter);

        // Gives the RecView a default Layout Manager
        myRecyclerView.setLayoutManager(new LinearLayoutManager((this)));





    }

    public void tempAddToList(View view) {

        // Put data in the list "Dataset" as a String
        myDataSet.addLast(savedTime);

        myRecyclerView = findViewById(R.id.timeRecyclerView);

        //Create an adapter then supply the data
        myAdapter = new TimeDatabaseAdapter(this, myDataSet);

        // Connects the adapter to the RecView
        myRecyclerView.setAdapter(myAdapter);

        // Gives the RecView a default Layout Manager
        myRecyclerView.setLayoutManager(new LinearLayoutManager((this)));

    }


}

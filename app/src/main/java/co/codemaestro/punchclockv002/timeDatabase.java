package co.codemaestro.punchclockv002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class timeDatabase extends AppCompatActivity {
    private RecyclerView timeDataBaseRecycler;
    private RecyclerView.Adapter timeDataBaseRecyclerAdapter;
    private RecyclerView.LayoutManager timeDatabaseLayoutManager;
    private final LinkedList<String> myDataset = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_database);

        //Data for RecyclerView
        for (int i = 0; i < 20; i++) {
            myDataset.addLast("Word " + i);
        }

        //Setting Reference Variable
        timeDataBaseRecycler = findViewById(R.id.time_Database_Recycler);

        //Sets all items in the RecyclerView to same size
        //Required for optimization
        timeDataBaseRecycler.setHasFixedSize(true);

        //Set RecyclerView Layout Manager
        timeDatabaseLayoutManager = new LinearLayoutManager(this);
        timeDataBaseRecycler.setLayoutManager(timeDatabaseLayoutManager);

        //Set RecyclerView Adapter
//        timeDataBaseRecyclerAdapter = new MyAdapter(myDataset);
        timeDataBaseRecycler.setAdapter(timeDataBaseRecyclerAdapter);

    }
}

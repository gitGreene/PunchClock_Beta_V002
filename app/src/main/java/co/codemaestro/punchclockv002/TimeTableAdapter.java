package co.codemaestro.punchclockv002;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TheViewHolder>  {

    List<TimeData> timeData;

    public TimeTableAdapter(List<TimeData> timeData) {
        this.timeData = timeData;
    }

    @NonNull
    @Override
    public TimeTableAdapter.TheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_table_list_item, parent, false);
        return new TheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeTableAdapter.TheViewHolder viewHolder, int position) {

        viewHolder.category.setText(timeData.get(position).getTime());
        viewHolder.time.setText(timeData.get(position).getCategory());
        //viewHolder.category.setText("Category");
        //viewHolder.time.setText("Time");
    }

    @Override
    public int getItemCount() {
        return timeData.size();
    }

    public class TheViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public TextView time;

        public TheViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.textView_Category);
            time = itemView.findViewById(R.id.textView_Time);
        }
    }
}































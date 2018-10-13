package co.codemaestro.punchclockv002;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

 

import java.util.LinkedList;

public class TimeDatabaseAdapter extends
        RecyclerView.Adapter<TimeDatabaseAdapter.TimeDatabaseHolder> {

    private final LinkedList<String> myTimeList;
    private final LinkedList<String> myCategoryList;
    private LayoutInflater myInflater;




    //TimeDatabaseHolder Class
    class TimeDatabaseHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public final TextView timeListTime;
        public final TextView timeListCategory;
        final TimeDatabaseAdapter myAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views
         *                for the RecyclerView.
         */

        public TimeDatabaseHolder(View itemView, TimeDatabaseAdapter adapter) {
            super(itemView);
            timeListTime = itemView.findViewById(R.id.timeListTime);
            timeListCategory = itemView.findViewById(R.id.timeListCategory);
            this.myAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            // Get position of item clicked
            //int myPosition = getLayoutPosition();

            // Use that position to access affected item in myTimeList
            //String myElement = myTimeList.get(myPosition);

            //Change the word in myTimeList
            // myTimeList.set(myPosition, "Has been Clicked!" + myElement);

            // update RecView to display data
            //myAdapter.notifyDataSetChanged();

        }
    }









    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to
     * represent an item.
     *
     * This new ViewHolder should be constructed with a new View that can
     * represent the items of the given type. You can either create a new View
     * manually or inflate it from an XML layout file.
     *
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List). Since it will be reused to
     * display different items in the data set, it is a good idea to cache
     * references to sub views of the View to avoid unnecessary findViewById()
     * calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after
     *                 it is bound to an adapter position.
     * @param viewType The view type of the new View. @return A new ViewHolder
     *                 that holds a View of the given view type.
     */

    @NonNull
    @Override
    public TimeDatabaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myItemView = myInflater.inflate(R.layout.time_database_list_item, parent, false);
        return new TimeDatabaseHolder(myItemView, this);
    }

    @Override
    public void onBindViewHolder(TimeDatabaseHolder holder, int position) {

        //Retrieve data for that position
        String myTime = myTimeList.get(position);

        String myCategory = myCategoryList.get(position);

        // Add data to view holder
        holder.timeListTime.setText(myTime);
        holder.timeListCategory.setText(myCategory);

    }

    @Override
    public int getItemCount() {
        return myTimeList.size();
    }



    public TimeDatabaseAdapter(Context context, LinkedList<String> timeList, LinkedList<String> categoryList) {
        myInflater = LayoutInflater.from(context);
        this.myTimeList = timeList;
        this.myCategoryList = categoryList;
    }





}

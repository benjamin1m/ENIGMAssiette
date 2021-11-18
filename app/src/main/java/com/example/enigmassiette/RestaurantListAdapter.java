package com.example.enigmassiette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {

    private Context mContext;
    private int mCount;


    public RestaurantListAdapter(Context context, int count) {
        this.mContext = context;
        // COMPLETED (10) Set the local mCount to be equal to count
        mCount = count;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantListAdapter.RestaurantViewHolder holder, int position) {
        
    }


    @Override
    public int getItemCount() {
        return mCount;
    }


    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class RestaurantViewHolder extends RecyclerView.ViewHolder {

        TextView nameResTextView;
        TextView dateResTextView;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            nameResTextView = (TextView) itemView.findViewById(R.id.nameRes);
            dateResTextView = (TextView) itemView.findViewById(R.id.dateRes);
        }
    }
}

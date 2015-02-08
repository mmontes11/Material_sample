package com.apm.mmontes.apm02;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private List<Item> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextViewTitle;
        public TextView mTextViewDate;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    TextView tv_title = (TextView) v.findViewById(R.id.tv_title_item);
                    String title = tv_title.getText().toString();
                    TextView tv_date = (TextView) v.findViewById(R.id.tv_date_item);
                    String date = tv_date.getText().toString();

                    Intent intent = new Intent(context,Details.class);
                    intent.putExtra("title",title);
                    intent.putExtra("date",date);
                    context.startActivity(intent);
                }
            });
            mTextViewTitle = (TextView) v.findViewById(R.id.tv_title_item);
            mTextViewDate = (TextView) v.findViewById(R.id.tv_date_item);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SimpleAdapter(List<Item> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextViewTitle.setText(mDataset.get(position).getTitle());
        holder.mTextViewDate.setText(mDataset.get(position).getDate());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

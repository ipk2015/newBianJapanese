package com.ipk.newbianjapanese.recyclerView_unit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.SimpleClassInfo;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(TextView itemView) {
            super(itemView);
            mTextView = itemView;
        }
    }

    public List<SimpleClassInfo> mDataset;
    public MyRecyclerViewAdapter(List<SimpleClassInfo> myDateset){
        mDataset = myDateset;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getClassTitle());
    }

//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

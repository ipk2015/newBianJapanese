package com.ipk.newbianjapanese.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.SimpleClassInfo;

import java.util.List;

public class UnitClassRecyclerViewAdapter extends RecyclerView.Adapter<UnitClassRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{


    @Override
    public void onClick(View v) {
        if(null != onItemClickListener){
            onItemClickListener.onItemClick((Integer) v.getTag());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    private OnItemClickListener onItemClickListener;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public View mItemView;
        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mTextView = (TextView) itemView.findViewById(R.id.textView_classTitle);
        }
    }

    public List<SimpleClassInfo> mDataset;
    public UnitClassRecyclerViewAdapter(List<SimpleClassInfo> myDateset){
        mDataset = myDateset;
    }

    public void setDataset(List<SimpleClassInfo> dataset) {
        this.mDataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public UnitClassRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_class_title,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mItemView.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UnitClassRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItemView.setTag(position);
        holder.mTextView.setText(mDataset.get(position).getClassTitle());
    }


    @Override
    public int getItemCount() {
        if(null != mDataset){
            return mDataset.size();
        }
        return 0;
    }
}

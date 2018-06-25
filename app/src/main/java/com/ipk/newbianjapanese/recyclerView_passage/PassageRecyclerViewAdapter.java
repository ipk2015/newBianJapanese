package com.ipk.newbianjapanese.recyclerView_passage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.PassageInfo;

import java.util.List;

public class PassageRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class PassageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewPassage;
        public  PassageViewHolder(View itemView) {
            super(itemView);
            textViewPassage = itemView.findViewById(R.id.textView_passage_item_view);
        }
    }

    public static class TalkViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTalkName;
        public TextView textViewTalkContent;
        public  TalkViewHolder(View itemView) {
            super(itemView);
            textViewTalkName = itemView.findViewById(R.id.textView_talk_name_item_view);
            textViewTalkContent = itemView.findViewById(R.id.textView_talk_content_item_view);
        }
    }
    private List<PassageInfo> mDataList;
    public PassageRecyclerViewAdapter() {
    }
    public PassageRecyclerViewAdapter(List<PassageInfo> dataList) {
        this.mDataList = dataList;
    }
    public void setDataList(List<PassageInfo> dataList){
        this.mDataList = dataList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if(null != mDataList){
            return mDataList.get(position).getType();
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview_talk, parent, false);
            TalkViewHolder talkViewHolder = new TalkViewHolder(view);
            return talkViewHolder;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview_passage, parent, false);
        PassageViewHolder talkViewHolder = new PassageViewHolder(view);
        return talkViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PassageInfo passageInfo = mDataList.get(position);
        if(holder instanceof PassageViewHolder){
            ((PassageViewHolder) holder).textViewPassage.setText(passageInfo.getPassage());
        }else if(holder instanceof  TalkViewHolder){
            ((TalkViewHolder) holder).textViewTalkName.setText(passageInfo.getTalkName());
            ((TalkViewHolder) holder).textViewTalkContent.setText(passageInfo.getTalkContent());
        }
    }

    @Override
    public int getItemCount() {
        if(null != mDataList){
            return mDataList.size();
        }
        return 0;
    }


}

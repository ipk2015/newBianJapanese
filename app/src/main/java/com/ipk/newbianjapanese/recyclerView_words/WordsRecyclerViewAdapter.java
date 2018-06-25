package com.ipk.newbianjapanese.recyclerView_words;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipk.newbianjapanese.Constants;
import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.WordInfo;

import java.util.List;

public class WordsRecyclerViewAdapter extends RecyclerView.Adapter<WordsRecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView writingTextView;
        public TextView posTextView;
        public TextView meaningTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            writingTextView = itemView.findViewById(R.id.textView_writing_word_item_view);
            posTextView = itemView.findViewById(R.id.textView_pos_word_item_view);
            meaningTextView = itemView.findViewById(R.id.textView_meaning_word_item_view);
        }
    }
    private List<WordInfo> mDataList;

    public WordsRecyclerViewAdapter(List<WordInfo> dataList) {
        this.mDataList = dataList;
    }

    @Override
    public WordsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview_word, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WordInfo wordInfo = mDataList.get(position);
        holder.writingTextView.setText(wordInfo.getWriting()+ Constants.getToneByString(wordInfo.getTone()));
        holder.posTextView.setText(Constants.addBrackets(wordInfo.getPos()));
        holder.meaningTextView.setText(wordInfo.getMeaning());
    }


    @Override
    public int getItemCount() {
        if(null != mDataList){
            return mDataList.size();
        }
        return 0;
    }
}

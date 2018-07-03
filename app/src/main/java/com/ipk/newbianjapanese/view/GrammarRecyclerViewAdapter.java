package com.ipk.newbianjapanese.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.GrammarInfo;

import java.util.List;

public class GrammarRecyclerViewAdapter extends RecyclerView.Adapter<GrammarRecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView explanationTextView;
        public TextView exampleTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textView_grammar_name_item_view);
            explanationTextView = itemView.findViewById(R.id.textView_grammar_explanation_item_view);
            exampleTextView = itemView.findViewById(R.id.textView_grammar_example_item_view);
        }
    }

    private List<GrammarInfo> mDataList;
    public GrammarRecyclerViewAdapter(List<GrammarInfo> dataList) {
        mDataList = dataList;
    }

    @Override
    public GrammarRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itemview_grammar, parent, false);
        GrammarRecyclerViewAdapter.ViewHolder holder = new GrammarRecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(GrammarRecyclerViewAdapter.ViewHolder holder, int position) {
        GrammarInfo grammarInfo = mDataList.get(position);
        holder.nameTextView.setText(grammarInfo.getName());
        holder.explanationTextView.setText(grammarInfo.getExplanation());
        holder.exampleTextView.setText(grammarInfo.getExample());
    }

    @Override
    public int getItemCount() {
        if(null != mDataList){
            return mDataList.size();
        }
        return 0;
    }
}

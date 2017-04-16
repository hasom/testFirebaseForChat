package com.hasom.testfirebase.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hasom.testfirebase.adapter.holder.ChatViewHolder;

import java.util.ArrayList;

/**
 * Created by leejunho on 2017. 1. 7..
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private Activity mAct;

    private ArrayList<String> list = new ArrayList<String>();

    public ChatAdapter(Activity act) {
        super();
        this.mAct = act;
    }

    public void setListData(ArrayList<String> list) {
        this.list.addAll(list);
    }

    public void addListItem(String data) {
        this.list.add(data);
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }



    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatViewHolder(mAct, parent);

    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        if (holder == null) {
            return;
        }

        holder.onBind(list.get(position), position);
    }


}
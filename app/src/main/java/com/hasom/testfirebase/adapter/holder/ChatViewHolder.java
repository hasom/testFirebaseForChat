package com.hasom.testfirebase.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hasom.testfirebase.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leejunho on 2017. 1. 12..
 */
public class ChatViewHolder extends RecyclerView.ViewHolder {

    private Context mCtx;

    @BindView(R.id.tvUserName)
    TextView tvUserName;


    public ChatViewHolder(Context ctx, ViewGroup parent) {
        super(LayoutInflater.from(ctx).inflate(R.layout.row_comment_other, parent, false));

        this.mCtx = ctx;

        ButterKnife.bind(this, itemView);

    }

    public void onBind(String data, final int position) {

        try {

            tvUserName.setText("" + data);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

package com.example.miniproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRvListAdapter extends RecyclerView.Adapter<MyRvListAdapter.ViewHolder> {
    private List<NoteModel> noteList;
    private Context mContext;

    public MyRvListAdapter(List<NoteModel> infoBeans, Context mContext) {
        this.noteList = infoBeans;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @Override
    public MyRvListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_sample_item, parent, false);
        return new MyRvListAdapter.ViewHolder(view);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layoutItem;
        public TextView title;
        public TextView contents;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.note_item);
            title = itemView.findViewById(R.id.note_title);
            contents = itemView.findViewById(R.id.note_content);
        }
    }
    public void onBindViewHolder(@NonNull final MyRvListAdapter.ViewHolder viewHolder, int i) {
        final NoteModel item = noteList.get(i);

        viewHolder.title.setText(item.title);
        if(item.contents.length()<=160)
        {
            viewHolder.contents.setText(item.contents);
        }
        else
        {
            viewHolder.contents.setText(item.contents.substring(0,160)+ "...");
        }
        viewHolder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, NoteActivity.class);
                i.putExtra("title",item.title);
                i.putExtra("contents",item.contents);
                mContext.startActivity(i);
            }
        });
    }

}

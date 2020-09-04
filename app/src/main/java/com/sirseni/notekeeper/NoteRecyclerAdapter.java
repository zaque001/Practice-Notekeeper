package com.sirseni.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  NoteRecyclerAdapter extends RecyclerView.Adapter <NoteRecyclerAdapter.ViewHolder>{
    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> note) {
        mContext = context;
        mNotes = note;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mLayoutInflater.inflate(R.layout.item_note_list,parent,false);

        return new ViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
   NoteInfo note =mNotes.get(position);
   holder.mTextcourse.setText(note.getCourse().getTitle());
   holder.mTexttitle.setText(note.getTitle());
   holder.mCurrentPosition=position;
    }

    @Override
    public int getItemCount() {

        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextcourse;
        public TextView mTexttitle;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextcourse = (TextView) itemView.findViewById(R.id.text_course);
            mTexttitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mContext,NoteActivity.class );
                    intent.putExtra(NoteActivity.NOTE_POSITION,mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });

        }
    }

}

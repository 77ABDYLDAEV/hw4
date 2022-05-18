package com.example.hw4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private final List<NotesModel> list = new ArrayList<>();
    private FragmaentActivity activity;

    public void addNote(NotesModel model){
        this.list.add(model);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes,parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtTitle.setText(list.get(position).getTitle());
        holder.txtDescription.setText(list.get(position).getDescription());
        holder.txtDate.setText(list.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = list.get(position).getTitle();
                String description = list.get(position).getDescription();

                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("description", description);



            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle, txtDescription, txtDate;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_note_title);
            txtDescription = itemView.findViewById(R.id.txt_note_description);
            txtDate = itemView.findViewById(R.id.txt_note_date);
        }
        }

    private class FragmaentActivity {
    }
}

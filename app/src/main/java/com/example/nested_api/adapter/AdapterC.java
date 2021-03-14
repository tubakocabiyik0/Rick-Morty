package com.example.nested_api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nested_api.R;
import com.example.nested_api.model.ResultList;
import com.example.nested_api.model.Results;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterC extends RecyclerView.Adapter<AdapterC.MYHolder> {
    List<Results> lists;
    Context context;

    public AdapterC(List<Results> lists, Context context) {
        this.lists = lists;
        this.context = context;

    }

    @NonNull
    @Override
    public MYHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter, parent, false);

        return new MYHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MYHolder holder, int position) {
        holder.name.setText(lists.get(position).getName());
        holder.episode.setText(lists.get(position).getEpisode());
        Picasso.get().load("https://m.media-amazon.com/images/M/MV5BZjRjOTFkOTktZWUzMi00YzMyLThkMmYtMjEwNmQyNzliYTNmXkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_.jpg").into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class MYHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView episode;
        TextView name;


        public MYHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            episode = itemView.findViewById(R.id.textView2);
            name = itemView.findViewById(R.id.textView);


        }


    }



}

package com.example.appmusic.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.LGandRG.Utils;
import com.example.appmusic.R;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    ArrayList<Album> lstAlbum;
    Context context;
    AlbumCallBack albumCallBack;

    public AlbumAdapter(ArrayList<Album> lstAlbum,AlbumCallBack albumCallBack) {
        this.lstAlbum = lstAlbum;
        this.albumCallBack = albumCallBack;
    }
    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View albumView = inflater.inflate(R.layout.layoutitem, parent, false);
        AlbumViewHolder viewHolder = new AlbumViewHolder(albumView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album item = lstAlbum.get(position);
        holder.ivAvatar.setImageBitmap(Utils.convertToBitmapFromAssets(context,item.getAvatar()));
        holder.tvName.setText(item.getName());
        holder.itemView.setOnClickListener(view->albumCallBack.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {
        return lstAlbum.size();
    }

    class  AlbumViewHolder extends RecyclerView.ViewHolder{
        ImageView ivAvatar;
        TextView tvName;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
    public interface AlbumCallBack{
        void onItemClick(String id);
    }
}

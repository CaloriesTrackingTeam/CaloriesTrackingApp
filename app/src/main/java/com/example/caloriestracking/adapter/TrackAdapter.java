package com.example.caloriestracking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.caloriestracking.R;
import com.example.caloriestracking.model.Food;
import com.example.caloriestracking.model.Track;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder>{
    private List<Track> trackList;

    private Float caloneed;
    public TrackAdapter(List<Track> trackList, Float caloneed) {
        this.trackList = trackList;
        this.caloneed = caloneed;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        return new TrackAdapter.TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        Track f = trackList.get(position);
        if(f == null) return;

        holder.NameElement.setText(f.getDate().toString());
        holder.InfoNameElement.setText(f.getCalo() + " calo");
        holder.imgDelete.setImageResource(R.drawable.calories);
    }

    @Override
    public int getItemCount() {
        if(trackList != null){
            return trackList.size();
        }
        return 0;
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder{
        private TextView NameElement, InfoNameElement;
        private CardView cardview_Ele;
        private ImageView imgDelete;
        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            //-----------item_list_home
            NameElement = itemView.findViewById(R.id.NameElement);
            InfoNameElement = itemView.findViewById(R.id.InfoNameElement);
            cardview_Ele = itemView.findViewById(R.id.cardview_Ele);
            imgDelete = itemView.findViewById(R.id.imgDelete);
        }
    }
}

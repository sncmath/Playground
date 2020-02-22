package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.weather.R;

import java.util.ArrayList;


import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<ListItem> listItems;
    private Context mcontext;
    private OnItemClickistener mListener;

    public interface OnItemClickistener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickistener listener) {
        mListener = listener;
    }

    public MyAdapter(ArrayList<ListItem> listItems, Context mcontext) {
        this.listItems = listItems;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem currentItem = listItems.get(position);

        String date = currentItem.getDate();
        String weatherstate = currentItem.getWeatherstate();

        holder.date.setText(String.format("DATE: %s", date));
        holder.weatherstate.setText(String.format("WEATHER: %s", weatherstate));

        if (position % 6 == 0) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade1));
        }
        else if (position % 6 == 1) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade2));
        }
        else if (position % 6 == 2) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade3));
        }
        else if (position % 6 == 3) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade1));
        }
        else if (position % 6 == 4) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade2));
        }
        else if (position % 6 == 5) {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade3));
        }
        else {
            holder.mcard.setCardBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade3));
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView weatherstate;
        public TextView speed;
        public TextView humidity;
        public CardView mcard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date =  itemView.findViewById(R.id.date);
            weatherstate =  itemView.findViewById(R.id.weatherstate);
            mcard = itemView.findViewById(R.id.card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}

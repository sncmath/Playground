package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.carmel.jsonmovie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.ExampleItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<ExampleItem> mExampleItem;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void  setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(Context mcontext, ArrayList<ExampleItem> mExampleItem) {
        this.mcontext = mcontext;
        this.mExampleItem = mExampleItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExampleItem currentItem = mExampleItem.get(position);

        String mimageview = currentItem.getMimageview();
        String mtextview = currentItem.getMtextview();
        String mrelease = currentItem.getMrelease();

        holder.mtextview.setText(mtextview);
        Picasso.with(mcontext).load("https://image.tmdb.org/t/p/w200"+mimageview).placeholder(R.mipmap.ic_launcher).into(holder.mimageview);
        holder.mrelease.setText(mrelease);


        if (position % 5 == 0){
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade1));
        }
        else if (position % 5 == 1){
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade2));
        }
         else if (position % 5 == 2){
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade3));
        }
        else if (position % 5 == 3){
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade4));
        }
        else if (position % 5 == 4){
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade5));
        }
        else {
            holder.mcard.setBackgroundColor(ContextCompat.getColor(mcontext,R.color.fade5));
        }
    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mimageview;
        public TextView mtextview;
        public TextView mrelease;
        public CardView mcard;
        public TextView moverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageview = itemView.findViewById(R.id.imageView);
            mtextview = itemView.findViewById(R.id.textView);
            mrelease = itemView.findViewById(R.id.release);
            mcard = itemView.findViewById(R.id.card);
            moverview = itemView.findViewById(R.id.overviewDetail);

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

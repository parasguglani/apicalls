package com.passionategeekz.parser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class gitadapter extends RecyclerView.Adapter<gitadapter.githubViewHolder> {

    private  Context context;
    private  User[] data;

    public  gitadapter(Context context , User[] data )
    {
            this.context= context;

            this.data= data;
    }



    @NonNull
    @Override
    public githubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.activity_main ,parent,false);

        return new githubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull githubViewHolder holder, int position) {
            User user = data[position];
            holder.t.setText(user.getLogin());
        Glide.with(holder.img.getContext()).load(user.getAvatarUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public  class  githubViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView t;

        public githubViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imageView);
            t=(TextView) itemView.findViewById(R.id.textView);
        }
    }
}

package com.project.alex.reciclabcn;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by alexbruch on 11/2/17.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {
    private Context context;
    private List<Card> contenidorList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;
        public CardView cardView;

        /** DEFINICIO VISTA **/

        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            name = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListContenidor.class);
                    intent.putExtra("1", name.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }

    public CardsAdapter(Context context, List<Card> contenidorList) {
        this.context = context;
        this.contenidorList = contenidorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** PASEM TOT AL LAYOUT DE TARGETA **/
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenidor_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        /** PASEM TOT A LA TARGETA CORRESPONENT SEGONS POSICIO **/
        final Card contenidor = contenidorList.get(position);
        holder.name.setText(contenidor.getName());
        holder.cardView.setBackgroundColor(Color.parseColor(contenidor.getColor()));

        //carregar imatge fent servir la llibreria Glide
        Glide.with(context).load(contenidor.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return contenidorList.size();
    }
}

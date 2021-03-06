package com.project.alex.reciclabcn.cards;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project.alex.reciclabcn.Card;
import com.project.alex.reciclabcn.R;
import com.project.alex.reciclabcn.lists.LlistaMaterialsContenidor;

import java.util.List;

/**
 * Created by alexbruch on 11/2/17.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {
    private Context context;
    private List<Card> contenidorList;

    public CardsAdapter(Context context, List<Card> contenidorList) {
        this.context = context;
        this.contenidorList = contenidorList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;
        public CardView cardView;

        /** DEFINICIO VISTA **/

        public MyViewHolder(View view) {
            super(view);
            this.cardView = (CardView) view.findViewById(R.id.card_view);
            this.name = (TextView) view.findViewById(R.id.title);
            this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), LlistaMaterialsContenidor.class);
                    intent.putExtra("title", name.getText().toString());
                    intent.putExtra("color1", cardView.getCardBackgroundColor());
                    //Toast.makeText(context, cardView.getCardBackgroundColor().toString(), Toast.LENGTH_LONG).show();
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** PASEM TOT AL LAYOUT DE TARGETA **/
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_contenidor, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        /** PASEM TOT A LA TARGETA CORRESPONENT SEGONS POSICIO **/
        Card contenidor = contenidorList.get(position);
        //holder.itemView.setTag(contenidor);

        holder.name.setText(contenidor.getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(contenidor.getColor1()));

        //carregar imatge fent servir la llibreria Glide
        //Glide.with(context).load(contenidor.getThumbnail()).into(holder.thumbnail);
        //Glide.with(context).load(R.drawable.contenidor).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return contenidorList.size();
    }
}
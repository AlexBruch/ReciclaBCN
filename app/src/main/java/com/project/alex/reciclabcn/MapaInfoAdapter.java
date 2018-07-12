package com.project.alex.reciclabcn;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.alex.reciclabcn.DetallMaterial.MaterialDetail;

import java.util.List;

public class MapaInfoAdapter extends RecyclerView.Adapter<MapaInfoAdapter.MyViewHolder> {
    private Context context;
    private List<Material> materialList;

    /** DEFINICIO VISTA **/
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView material;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);

            material = (TextView) view.findViewById(R.id.material);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail_material);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /** Al fer click sobre una element obrim nou layout am la info que toca **/
                    Intent intent = new Intent(view.getContext(), MaterialDetail.class);
                    //intent.putExtra("title", name.getText().toString());
                    intent.putExtra("material", material.getText().toString());
                    intent.putExtra("title", material.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
    public MapaInfoAdapter(Context context, List<Material> materialList) {
        this.context = context;
        this.materialList = materialList;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Material material = materialList.get(position);
        holder.material.setText(material.getMaterial());
        holder.material.setTextColor(Color.parseColor(material.getColor1()));
        //carregar imatge fent servir la llibreria Glide
        Glide.with(context).load(R.drawable.material_icon).into(holder.thumbnail);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mapa_info_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }
}

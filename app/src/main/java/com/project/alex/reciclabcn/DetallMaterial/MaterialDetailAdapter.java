package com.project.alex.reciclabcn.DetallMaterial;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.project.alex.reciclabcn.Material;
import com.project.alex.reciclabcn.R;

import java.util.List;

public class MaterialDetailAdapter extends RecyclerView.Adapter<MaterialDetailAdapter.MyViewHolder> {
    private Context context;
    private List<Material> materialDetail;

    /** DEFINICIO VISTA **/
    public class MyViewHolder extends RecyclerView.ViewHolder{
        /** fila contenidor **/
        public TextView textContenidor;
        public ImageView ContenidorIcon;
        /** fila localitzacio **/
        public TextView textLocalitzacio;
        public ImageView localitzacioIcon;
        /** fila descripcio **/
        public TextView textDescription;
        public ImageView descriptionIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            textContenidor = (TextView) itemView.findViewById(R.id.material_text);
            ContenidorIcon = (ImageView) itemView.findViewById(R.id.icon_text);
            textLocalitzacio = (TextView) itemView.findViewById(R.id.material_loca);
            localitzacioIcon = (ImageView) itemView.findViewById(R.id.icon_loca);
            textDescription = (TextView) itemView.findViewById(R.id.material_desc);
            descriptionIcon = (ImageView) itemView.findViewById(R.id.icon_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, "wazaaaaaaa",Toast.LENGTH_LONG).show();
                }

            });
        }
    }
    public MaterialDetailAdapter(Context context, List<Material> materialDetail) {
        this.context = context;
        this.materialDetail = materialDetail;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** PASEM TOT AL LAYOUT A LA FILA DE LA LLISTA **/
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_row_text, parent, false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /** Ho pasem tot a la fila corresponent segons posicio **/
        Material text = materialDetail.get(position);
        holder.textContenidor.setText(text.getCubo());
        Glide.with(context).load(R.drawable.ic_action_name).into(holder.ContenidorIcon);

        holder.textLocalitzacio.setText(text.getLocalitzacio());
        Glide.with(context).load(R.drawable.ic_location).into(holder.localitzacioIcon);

        holder.textDescription.setText(text.getDescription());
        Glide.with(context).load(R.drawable.ic_reciclar).into(holder.descriptionIcon);
    }

    @Override
    public int getItemCount() {
        return materialDetail.size();
    }

}

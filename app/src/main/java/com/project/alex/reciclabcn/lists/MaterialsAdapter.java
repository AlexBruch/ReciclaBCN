package com.project.alex.reciclabcn.lists;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.alex.reciclabcn.MaterialDetail;
import com.project.alex.reciclabcn.R;

import java.util.List;

/**
 * Created by alexbruch on 13/2/17.
 */

public class MaterialsAdapter extends RecyclerView.Adapter<MaterialsAdapter.MyViewHolder> {
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
                    Intent intent = new Intent(view.getContext(), MaterialDetail.class);
                    intent.putExtra("material", material.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    public MaterialsAdapter(Context context, List<Material> materialList) {
        this.context = context;
        this.materialList = materialList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** PASEM TOT AL LAYOUT A LA FILA DE LA LLISTA **/
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_material, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /** PASEM TOT A LA FILA CORRESPONENT SEGONS POSICIO **/
        Material material = materialList.get(position);
        holder.material.setText(material.getMaterial());

        //carregar imatge fent servir la llibreria Glide
        //Glide.with(context).load(material.getThumbnail()).into(holder.thumbnail);
        Glide.with(context).load(R.drawable.contenidor).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }
}

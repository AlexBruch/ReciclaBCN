package com.project.alex.reciclabcn;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.project.alex.reciclabcn.lists.LlistaMaterialsContenidorAdapter;
import com.project.alex.reciclabcn.sqlite.ItemsDatasource;

import java.util.List;

public class MapaInfo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LlistaMaterialsContenidorAdapter llistaMaterialsContenidorAdapter;
    private List<Material> materialList;
    private RecyclerView.LayoutManager layoutManager;
    private ItemsDatasource itemsDatasource;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_info);



        itemsDatasource = new ItemsDatasource(getApplicationContext());
        /**
         * passar color material aquí!!!
         * */
        materialList = itemsDatasource.getMaterialsList("Punt verd / Deixalleria");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color1")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Fletxa



        getSupportActionBar().setDisplayShowHomeEnabled(true); //Fletxa
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Punt Verd Pedralbes");

        // Agafar recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.mapa_info_recyclerview);
        recyclerView.setHasFixedSize(true);

        // Administrar layout
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        // Adaptador
        llistaMaterialsContenidorAdapter = new LlistaMaterialsContenidorAdapter(getApplicationContext(), materialList);
        recyclerView.setAdapter(llistaMaterialsContenidorAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}

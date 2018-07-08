package com.project.alex.reciclabcn.DetallMaterial;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.project.alex.reciclabcn.Material;
import com.project.alex.reciclabcn.R;
import com.project.alex.reciclabcn.sqlite.ItemsDatasource;

import java.util.List;

public class MaterialDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    private MaterialDetailAdapter materialDetailAdapter;
    private List<Material> materialList;
    private RecyclerView.LayoutManager layoutManager;
    private ItemsDatasource itemsDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_detail); /** Carrega LAYOUT MATERIAL **/

        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("title"), Toast.LENGTH_SHORT).show();

        /** agafem info **/
        itemsDatasource = new ItemsDatasource(getApplicationContext());
        materialList = itemsDatasource.getDetallMaterial(getIntent().getStringExtra("material"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Fletxa
        getSupportActionBar().setDisplayShowHomeEnabled(true); //Fletxa

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(getIntent().getStringExtra("title"));

        /** PROVES SENSE RECYCLERVIEW **/



        /** FI PROVES **/


        /** Agafem recyclerView **/

        recyclerView = (RecyclerView) findViewById(R.id.material_detail_recycler_view);
        recyclerView.setHasFixedSize(true);

        /** Afministrat layout **/
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        /** Adaptador **/

        materialDetailAdapter = new MaterialDetailAdapter(getApplicationContext(), materialList);
        recyclerView.setAdapter(materialDetailAdapter);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dynamicToolbarColor();
        toolbarTextApperence();
    }

    private void dynamicToolbarColor() {

    }

    private void toolbarTextApperence () {

    }
}

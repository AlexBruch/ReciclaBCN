package com.project.alex.reciclabcn.lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.project.alex.reciclabcn.R;
import com.project.alex.reciclabcn.sqlite.ItemsDatasource;

import java.util.List;

public class ListContenidor extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MaterialsAdapter materialsAdapter;
    private List<Material> materialList;
    private RecyclerView.LayoutManager layoutManager;
    private ItemsDatasource itemsDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_materials);

        itemsDatasource = new ItemsDatasource(getApplicationContext());
        /**
         * passar color material aquí!!!
         * */
        materialList = itemsDatasource.getMaterialsList(getIntent().getStringExtra("title"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Fletxa
        getSupportActionBar().setDisplayShowHomeEnabled(true); //Fletxa
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));

        // Agafar recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.material_recycler_view);
        recyclerView.setHasFixedSize(true);

        // Administrar layout
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        // Adaptador
        materialsAdapter = new MaterialsAdapter(getApplicationContext(), materialList);
        recyclerView.setAdapter(materialsAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /** MENÚ TRES PUNTS VERTICALS
     *  carpeta menu -> menu.xml
     * **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /** CLICLAR ALS ÍTEMS DE MENÚ **/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(ListContenidor.this, "Per què reciclar?", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(ListContenidor.this, "Consells medi ambient", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(ListContenidor.this, "Informació sobre l'app", Toast.LENGTH_LONG).show();
                return true;
            default : return super.onOptionsItemSelected(item);
        }
    }
}

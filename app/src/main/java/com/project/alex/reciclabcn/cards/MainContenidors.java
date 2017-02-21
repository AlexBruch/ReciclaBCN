package com.project.alex.reciclabcn.cards;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.alex.reciclabcn.R;
import com.project.alex.reciclabcn.sqlite.ItemsDatasource;

import java.util.List;

/**
 * Created by alexbruch on 7/2/17.
 */

public class MainContenidors extends Fragment {

    private RecyclerView recyclerView;
    private CardsAdapter cardsAdapter;
    private List<Card> contenidorList;
    private RecyclerView.LayoutManager layoutManager;
    private ItemsDatasource itemsDatasource;

    public MainContenidors() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.cards_main, container, false);

        itemsDatasource = new ItemsDatasource(getContext());

        contenidorList = itemsDatasource.getCardsList();

        // Agafar RecyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // Administrador per el layout
        layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        // Adaptador
        cardsAdapter = new CardsAdapter(getContext(), contenidorList);
        recyclerView.setAdapter(cardsAdapter);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(6), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //contenidorList = new ArrayList<>();

        return rootView;
    }

    /** Numero columnes de targetes **/
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); //posicio item
            int column = position % spanCount; //item columna

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) { //Espai de d'alt
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; //Espai abaix
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing; //item top
                }
            }
        }
    }

    /** Espai entre targetes **/
    private int dpToPx(int dp) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics()));
    }
}
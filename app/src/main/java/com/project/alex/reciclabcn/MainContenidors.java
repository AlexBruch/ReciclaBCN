package com.project.alex.reciclabcn;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexbruch on 7/2/17.
 */

public class MainContenidors extends Fragment {

    private RecyclerView recyclerView;
    private CardsAdapter cardsAdapter;
    private List<Card> contenidorList;

    public MainContenidors() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contenidor_main, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        contenidorList = new ArrayList<>();
        cardsAdapter = new CardsAdapter(getContext(), contenidorList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(6), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cardsAdapter);

        prepareCards();

        return rootView;
    }

    private void prepareCards() {
        int[] covers = new int[]{
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor};

        Card a = new Card("Paper i cartró", "#283593", covers[0]);
        contenidorList.add(a);

        a = new Card("Envàs de vidre", "#2E7D32", covers[1]);
        contenidorList.add(a);

        a = new Card("Envàs lleuger", "#F9A825", covers[2]);
        contenidorList.add(a);

        a = new Card("Orgànic", "#4E342E", covers[3]);
        contenidorList.add(a);

        a = new Card("Rebuig", "#424242", covers[4]);
        contenidorList.add(a);

        a = new Card("Punt verd / Deixalleria", "#C62828", covers[5]);
        contenidorList.add(a);

        a = new Card("Roba", "#EF6C00", covers[6]);
        contenidorList.add(a);

        a = new Card("Medicaments", "#AEEA00", covers[7]);
        contenidorList.add(a);

        a = new Card("Altres", "#4527A0", covers[8]);
        contenidorList.add(a);

        cardsAdapter.notifyDataSetChanged();

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

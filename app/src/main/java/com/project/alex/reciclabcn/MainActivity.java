package com.project.alex.reciclabcn;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.project.alex.reciclabcn.cards.MainContenidors;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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
                Intent intent = new Intent(MainActivity.this, Info.class);
                intent.putExtra("infoid", R.string.reciclar);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(MainActivity.this, Info.class);
                intent2.putExtra("infoid", R.string.consells);
                startActivity(intent2);
                return true;
            case R.id.item3:
                Intent intent3 = new Intent(MainActivity.this, Info.class);
                intent3.putExtra("infoid", R.string.infoapp);
                startActivity(intent3);
                return true;
            default : return super.onOptionsItemSelected(item);
        }
    }

    /** MUNTAR TABS PANTALLA PRINCIPAL
     *  layouts activity_main.xml / cards_main.xml / mapa.xml
     *  **/

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainContenidors(), "CONTENIDORS");
        adapter.addFragment(new Mapa(), "MAPA");
        viewPager.setAdapter(adapter);
    }

    /** ADAPTADOR PER ALS TABS **/

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

         public ViewPagerAdapter(FragmentManager manager) {
             super(manager);
         }

         @Override
         public Fragment getItem(int position) {
             return mFragmentList.get(position);
         }

         @Override
         public int getCount() {
             return mFragmentList.size();
         }

         public void addFragment(Fragment fragment, String title) {
             mFragmentList.add(fragment);
             mFragmentTitleList.add(title);
         }

         @Override
         public CharSequence getPageTitle(int position) {
             return mFragmentTitleList.get(position);
         }
    }
}

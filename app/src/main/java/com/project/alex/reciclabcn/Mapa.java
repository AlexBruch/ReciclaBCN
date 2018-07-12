package com.project.alex.reciclabcn;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.alex.reciclabcn.lists.LlistaMaterialsContenidor;

/**
 * Created by alexbruch on 7/2/17.
 */

public class Mapa extends Fragment {

    MapView mapView;
    private GoogleMap googleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.mapa, container, false);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume(); // per visualitzar el mapa inmediatament

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Mapa", "No rutlla");
        }



        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap map) {
                googleMap = map;

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);

                if ( Build.VERSION.SDK_INT >= 23 &&
                        ContextCompat.checkSelfPermission( getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                        ContextCompat.checkSelfPermission( getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                // Mostrar la nostra posició
                googleMap.setMyLocationEnabled(true);

                // Posició Barcelona per centrar Google maps
                final LatLng barcelona = new LatLng(41.3851, 2.1734);

                // Posicions marcadors
                final LatLng deixalleria1 = new LatLng(41.40, 2.1730);
                LatLng deixalleria2 = new LatLng(41.39, 2.1830);
                LatLng deixalleria3 = new LatLng(41.381, 2.17);
                LatLng deixalleria4 = new LatLng(41.375, 2.1540);
                LatLng deixalleria5 = new LatLng(41.391, 2.1630);
                LatLng deixalleria6 = new LatLng(41.389, 2.1530);


                googleMap.addMarker(new MarkerOptions().position(deixalleria1).title("Deixalleria1").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                googleMap.addMarker(new MarkerOptions().position(deixalleria2).title("Deixalleria2").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                googleMap.addMarker(new MarkerOptions().position(deixalleria3).title("Deixalleria3").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                googleMap.addMarker(new MarkerOptions().position(deixalleria4).title("Deixalleria4").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                googleMap.addMarker(new MarkerOptions().position(deixalleria5).title("Deixalleria5").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
                googleMap.addMarker(new MarkerOptions().position(deixalleria6).title("Deixalleria6").snippet("Punt verd / Deixalleria").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

                // Posicionar la camera a la posició de la ciutat
                CameraPosition cameraPosition = new CameraPosition.Builder().target(barcelona).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                    @Override
                    public View getInfoWindow(Marker marker) {

                        //marker.showInfoWindow();
                        return null;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {

                        View v = getLayoutInflater().inflate(R.layout.mapa, null);

                        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Toast.makeText(getContext(), "weaaaa", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getContext(), MapaInfo.class);
                                //intent.putExtra(googleMap.getP);
                                startActivity(intent);
                            }
                        });

                        return v;
                    }
                });

/**
               googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                   @Override
                   public boolean onMarkerClick(Marker marker) {
                       Toast.makeText(getContext(), "weaaaa", Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(getContext(), Info.class);
                       startActivity(intent);
                       return true;
                   }
               });**/

            }
        });

        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "Permis de localització denegat", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}

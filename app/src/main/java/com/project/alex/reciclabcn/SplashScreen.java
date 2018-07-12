package com.project.alex.reciclabcn;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.project.alex.reciclabcn.sqlite.ItemsDatasource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by alexbruch on 15/2/17.
 */

public class SplashScreen extends Activity {

    private static String Jsonurl = "http://www.nononbcn.com/reciclabcn.json";
    ItemsDatasource itemsDatasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        itemsDatasource = new ItemsDatasource(this);

        new GetData().execute();
    }

    private class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(SplashScreen.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(SplashScreen.this,
                            new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                            1);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }

            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(SplashScreen.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(SplashScreen.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {

                    // Show an expanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {

                    // No explanation needed, we can request the permission.

                    ActivityCompat.requestPermissions(SplashScreen.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            1);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
            }
            itemsDatasource.cleanDB();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();

            // request to json data url and getting response
            String jsonString = httpHandler.makeServiceCall(Jsonurl);
            //Log.e(TAG, "Response from url: " + jsonString);
            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);

                    /** PARSE AND SAVE CONTENIDORS **/

                    JSONArray contenidors = jsonObject.getJSONArray("contenidors");

                    for (int i = 0; i < contenidors.length(); i++) {

                        JSONObject c = contenidors.getJSONObject(i);

                        String contenidor = c.getString("contenidor");
                        String color1 = c.getString("color1");
                        String color2 = c.getString("color2");
                        String thumbnail = c.getString("thumbnail");

                        //Log.e("TEXT", "JSON " + contenidor);

                        itemsDatasource.saveContenidors(contenidor, color1, color2, thumbnail); // guardar dades a la BD

                    }

                    /** PARSE AND SAVE MATERIALS**/

                    JSONArray materials = jsonObject.getJSONArray("materials");

                    for (int i = 0; i < materials.length(); i++) {
                        JSONObject m = materials.getJSONObject(i);

                        String material = m.getString("material");
                        String thumbnail = m.getString("thumbnail");
                        String contenidor = m.getString("contenidor");
                        String cubo = m.getString("cubo");
                        String color1 = m.getString("color1");
                        String color2 = m.getString("color2");
                        String localitzacio = m.getString("loca");
                        String descripcio = m.getString("desc");

                        itemsDatasource.saveMaterials(material, thumbnail, contenidor, cubo, color1, color2, localitzacio, descripcio); // guardar dades a la BD
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "Could not get json from server.");
            }

            return null;
        }
    }
}

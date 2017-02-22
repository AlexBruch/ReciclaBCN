package com.project.alex.reciclabcn;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
            itemsDatasource.cleanContenidors();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);

            Toast.makeText(getApplicationContext(), "onPostExecute", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();

            // request to json data url and getting response
            String jsonString = httpHandler.makeServiceCall(Jsonurl);
            Log.e(TAG, "Response from url: " + jsonString);
            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    // Contingut dels contenidors
                    JSONArray contenidors = jsonObject.getJSONArray("contenidors");

                    for (int i = 0; i < contenidors.length(); i++) {

                        JSONObject c = contenidors.getJSONObject(i);

                        int id = c.getInt("id");
                        String contenidor = c.getString("contenidor");
                        String color1 = c.getString("color1");
                        String color2 = c.getString("color2");
                        String thumbnail = c.getString("thumbnail");

                        Log.e("TEXT", "JSON " + contenidor);

                        // guardamos los datos en la base de datos
                        itemsDatasource.saveContenidors(contenidor, color1, color2, thumbnail);

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

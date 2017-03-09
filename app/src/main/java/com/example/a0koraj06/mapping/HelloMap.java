package com.example.a0koraj06.mapping;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;
import android.widget.EditText;





public class HelloMap extends Activity {

    MapView mv;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView) findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(40.1, 22.5));

    }


    public void onStart()
    {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9") );
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4") );
        mv.getController().setCenter(new GeoPoint(lat,lon));
        int zoom = Integer.parseInt(prefs.getString("zoom", "14"));
        mv.getController().setZoom(zoom);




    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item)
    // handles user selecting a menu item
    {
        if (item.getItemId() == R.id.choosemap) {
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent, 0);            // react to the menu item being selected...
            return true;
        }


        if (item.getItemId() == R.id.setlocation) {
            Intent intent = new Intent(this, SetLocation.class);
            startActivityForResult(intent, 1);            // react to the menu item being selected...
            return true;
        }

        if (item.getItemId() == R.id.poilist) {
            Intent intent = new Intent(this, PoiListActivity.class);
            startActivityForResult(intent, 0);            // react to the menu item being selected...
            return true;
        }

        return false;
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (resultCode == RESULT_OK) {

            if (requestCode == 0) {
                Bundle extras = intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if (cyclemap == true) {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                } else {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }

            if (requestCode == 1){

                Bundle extras = intent.getExtras();
                double latitudesl = extras.getDouble("com.example.SetLatitude");
                double longitudesl = extras.getDouble("com.example.SetLongitude");
                mv.getController().setCenter(new GeoPoint(latitudesl, longitudesl));

            }
        }
    }


}




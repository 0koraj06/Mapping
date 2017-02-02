package com.example.a0koraj06.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;
import android.widget.EditText;
import android.view.View.onClickListener;




public class HelloMap extends Activity implements View.onClickListener {

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
        mv.getController().setCenter(new GeoPoint(51.3966, -0.1335));

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);



    }


    public void onClick(View view)
    {

        EditText latitude = (EditText)findViewById(R.id.latitude);
        EditText longitude = (EditText)findViewById(R.id.longitude);

    }



    }




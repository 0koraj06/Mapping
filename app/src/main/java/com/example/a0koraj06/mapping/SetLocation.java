package com.example.a0koraj06.mapping;

/**
 * Created by 0koraj06 on 09/02/2017.
 */

import android.app.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import org.osmdroid.views.MapView;
        import org.osmdroid.util.GeoPoint;
        import org.osmdroid.config.Configuration;

public class SetLocation extends Activity implements OnClickListener {

    MapView mv;


        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



            mv = (MapView) findViewById(R.id.map1);

            mv.setBuiltInZoomControls(true);
            mv.getController().setZoom(14);
            mv.getController().setCenter(new GeoPoint(51.5074, 0.1278));

            Button buttonsl = (Button) findViewById(R.id.buttonsl);
            buttonsl.setOnClickListener(this);

        }

    public void onClick(View view) {
        EditText et1 = (EditText) findViewById(R.id.latitudesl);
        double latitudesl = Double.parseDouble(et1.getText().toString());
        EditText et2 = (EditText) findViewById(R.id.longitudesl);
        double longitudesl = Double.parseDouble(et2.getText().toString());
        mv.getController().setCenter(new GeoPoint(latitudesl, longitudesl));

    }
}

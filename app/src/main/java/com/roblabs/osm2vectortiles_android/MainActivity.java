package com.roblabs.osm2vectortiles_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.MapboxAccountManager;

public class MainActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapboxAccountManager.start(this, getString(R.string.access_token));
        setContentView(R.layout.activity_main);

        // Create a mapView
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Add a MapboxMap
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                // Customize map with markers, polylines, etc.

                // Local Style JSON in the Android `assets` folder
//                mapboxMap.setStyleUrl("asset://mapbox-raster-v8.json");
                 mapboxMap.setStyleUrl("asset://styles/geography-class-local.json");

                // Style JSON hosted on a server
//                mapboxMap.setStyleUrl("https://www.mapbox.com/android-sdk/files/mapbox-raster-v8.json");

                // Examples of built in Mapbox Styles
//                mapboxMap.setStyleUrl(Style.MAPBOX_STREETS);
//                mapboxMap.setStyleUrl(Style.OUTDOORS);
//                mapboxMap.setStyleUrl(Style.LIGHT);
//                mapboxMap.setStyleUrl(Style.DARK);

            }
        });
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }


}

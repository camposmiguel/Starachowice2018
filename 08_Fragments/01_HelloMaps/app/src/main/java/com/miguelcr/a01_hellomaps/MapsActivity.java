package com.miguelcr.a01_hellomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private LatLng lastPosition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Map type
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        // Add a marker in Sydney and move the camera
        LatLng starachowice = new LatLng(51.047330,21.059400);

        mMap.addMarker(new MarkerOptions()
                .position(starachowice)
                .title("My mum is waiting me here ;) (written by Adam)"));

        // New marker in Sevilla > "Miguel will continue teaching here!
        LatLng sevilla = new LatLng(37.3753501,-6.0250983);

        mMap.addMarker(new MarkerOptions()
                .position(sevilla)
                .title("Miguel will continue teaching here!")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pink_marker))
                .draggable(true)
        );

        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapClickListener(this);

        // Polyline
        // Instantiates a new Polyline object and adds points to define a rectangle
        PolylineOptions rectOptions = new PolylineOptions()
                .add(new LatLng(37.380069,-6.005958))
                .add(new LatLng(37.381506,-6.00688))  // North of the previous point, but at the same longitude
                .add(new LatLng(37.383507,-6.003769))  // Same latitude, and 30km to the west
                .add(new LatLng(37.381787,-6.002739)) ; // Closes the polyline.

        // Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sevilla));

    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        LatLng position = marker.getPosition();
        Log.i("MARKER"," Location: " + position.latitude + "," + position.longitude);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        marker.showInfoWindow();
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("New marker!")
        );

        if(lastPosition != null) {
            // Add the polyline from "latLng" position to "lastPosition"
        }


    }
}

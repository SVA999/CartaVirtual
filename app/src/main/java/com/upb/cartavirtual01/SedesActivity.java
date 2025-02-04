package com.upb.cartavirtual01;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.cartavirtual01.databinding.ActivitySedesBinding;

public class SedesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivitySedesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySedesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add marker in brasil
        LatLng brasil = new LatLng(-38.416097, -63.616672);
        mMap.addMarker(new MarkerOptions().position(brasil).title("Marker in Brasil"));

        // Add a marker in UPB
        LatLng upbMed = new LatLng(6.2442623,-75.5873705);
        mMap.addMarker(new MarkerOptions().position(upbMed).title("UPB Medellin"));

        // Add a marker in Medellin and move the camera
        LatLng medellin = new LatLng(6.25184, -75.56359);
        mMap.addMarker(new MarkerOptions().position(medellin).title("Marker in Medellin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 15f));
        //mMap.setMaxZoomPreference(5000f);
        mMap.setMinZoomPreference(13f);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        float zoomLevel = 12.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, zoomLevel));


        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
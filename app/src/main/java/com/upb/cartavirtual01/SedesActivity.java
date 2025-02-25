package com.upb.cartavirtual01;

import androidx.fragment.app.FragmentActivity;

import com.upb.cartavirtual01.Clases.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.upb.cartavirtual01.databinding.ActivitySedesBinding;

import java.util.ArrayList;


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

        LatLng sedeLaureles = new LatLng(6.2413659,-75.5946323);
        mMap.addMarker(new MarkerOptions()
            .position(sedeLaureles)
            .title("Laureles")
            .snippet("Dirección: Cq 73 #34 - 65, Laureles - Estadio, Medellín, Laureles, Medellín, Antioquia")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        );


        // Add a marker in Medellin and move the camera
        LatLng sedeCiudadDelRio = new LatLng(6.2240859, -75.5740472);
        mMap.addMarker(new MarkerOptions()
                .position(sedeCiudadDelRio)
                .title("Ciudad del Rios")
                .snippet("Dirección: Cl. 20 #43g-158, El Poblado, Medellín, El Poblado, Medellín, Antioquia")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        );


        LatLng upbMed = new LatLng(6.2442623,-75.5873705);
        mMap.addMarker(new MarkerOptions()
                .position(upbMed)
                .title("UPB Medellin")
                .snippet("Universidad Pontificia Bolivariana")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upbMed, 15f));
        //mMap.setMaxZoomPreference(5000f);
        mMap.setMinZoomPreference(5f);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        float zoomLevel = 12.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upbMed, zoomLevel));


        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
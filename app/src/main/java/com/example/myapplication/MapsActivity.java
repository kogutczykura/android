package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    static class Shop {
        private final LatLng latLng;
        private final String name;

        public Shop(LatLng latLng, String name) {
            this.latLng = latLng;
            this.name = name;
        }

        public LatLng getLatLng() {
            return latLng;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        final List<Shop> shops = Arrays.asList(
                new Shop(new LatLng(51.751965, 19.458410), "Sklep 1"),
                new Shop(new LatLng(51.781856, 19.431790), "Sklep 2"),
                new Shop(new LatLng(51.794083, 19.483308), "Sklep 3")
        );

        final LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        shops.forEach(new Consumer<Shop>() {
            @Override
            public void accept(Shop shop) {
                mMap.addMarker(new MarkerOptions().position(shop.getLatLng()).title(shop.getName()));
                boundsBuilder.include(shop.getLatLng());
            }
        });

        mMap.setLatLngBoundsForCameraTarget(boundsBuilder.build());
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 15));
    }
}
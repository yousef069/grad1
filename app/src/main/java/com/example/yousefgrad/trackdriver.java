package com.example.yousefgrad;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class trackdriver extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Polyline currentPolyline;
    ArrayList<LatLng> listPoints;
    driver driver;
    FirebaseDatabase database,database2;
    DatabaseReference databaseReference;
    String recievedkey;
    Double lat1;
    Double lat2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackdriver);
        driver= (driver) getIntent().getSerializableExtra("driver");


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2track);
        mapFragment.getMapAsync(this);

recievedkey=driver.getDriverid();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("driver").child(recievedkey);

    }




    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        googleMap.getUiSettings().setZoomControlsEnabled(true);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                databaseReference.
                        addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {

                                    lat1= (Double) dataSnapshot.child("location1").getValue();
                                    lat2= (Double) dataSnapshot.child("location2").getValue();
                                    LatLng latLng = new LatLng(lat1, lat2);
                                    MarkerOptions markerOptions = new MarkerOptions();
                                    markerOptions.position(latLng);
                                    markerOptions.title("Current Position");

                                    markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.caricon));
                                    mMap.setIndoorEnabled(true);
                                    mMap.getCameraPosition();
                                    mMap.setBuildingsEnabled(true);
                                    mMap.getUiSettings().setZoomControlsEnabled(true);
                                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                    mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                                    mMap.addMarker(markerOptions);
                                    System.out.println("aaaaaaaaa"+lat1+lat2);



                                }




                            }


                            @Override
                            public void onCancelled(DatabaseError error) {

                                Log.d("dddddddddd", "onCancelled: " + error.getMessage());
                            }
                        });

            }

        }
        else
        {

        }
    }








    @Override
    protected void onStart() {
        super.onStart();
    }


}
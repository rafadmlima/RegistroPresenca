package com.example.rafael.registropresenca.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;

import com.example.rafael.registropresenca.util.DadosUsuario;
import com.example.rafael.registropresenca.util.Local;
import com.google.android.gms.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.location.LocationRequest;
import com.example.rafael.registropresenca.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;




public class MapaActivity extends FragmentActivity implements OnMapReadyCallback , GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = "Mapa_Activity";
    private GoogleMap mMap;
    private String cordenadas = ""; //-21.671406,-49.726823";
    String numero = "";
    double [] latitude;// = {-21.671406};
    double [] longitude;// = {-49.726823};
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location l;
    private LocationManager gps;
    private boolean isOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        verificarGps();
        startLocationUpdate();

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

    private void verificarGps() {
        gps = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
        isOn = gps.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isOn){
            Local local = new Local(this);
            callConnection();
        }else{
            Toast.makeText(this, "Você precisará ativar o gps do seu aparelho!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()){
            startLocationUpdate();
        }
    }
    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
    public void initLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000);
        mLocationRequest.setFastestInterval(2000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        try{
            MarkerOptions options;
//        mMap = googleMap;

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            options = new MarkerOptions();

            String[] cordenadas = DadosUsuario.getCoordenadas().split(",");//this.cordenadas.split(", ");
            LatLng local = new LatLng(Double.parseDouble(cordenadas[0]), Double.parseDouble(cordenadas[1]));
            options.position(local);
        try {
            //options.title(Util.formatDataDDmesYYYY(getIntent().getStringExtra("data"))).visible(true);
        }catch (Exception e){
            options.title(getIntent().getStringExtra("data")).visible(true);
        }
            options.snippet(getIntent().getStringExtra("nome")).visible(true);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(local));
            googleMap.addMarker(options);
            googleMap.setMinZoomPreference(10);
        }catch(SecurityException ex){
            Log.e(TAG, "Error", ex);
        }

    }
    @Override
    public void onConnected(Bundle bundle) {
        Log.i("LOG", "onConnected(" + bundle + ")");


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        l = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (l != null) {
            Log.i("LOG", "Latitude: " + l.getLatitude());
            Log.i("LOG", "Longitude: " + l.getLongitude());
            Toast.makeText(this, "Latitude: " + l.getLatitude() + "\nLongitude: " + l.getLongitude(), Toast.LENGTH_LONG).show();
        }

        startLocationUpdate();

        Toast.makeText(this, "Latitude: " + l.getLatitude() + "\nLongitude: " + l.getLongitude(), Toast.LENGTH_LONG).show();
    }
    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i +")");
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }
    @Override
    public void onLocationChanged(Location location) {
        latitude[0] = location.getLatitude();
        longitude[0] = location.getLongitude();
    }

    private void startLocationUpdate() {
        initLocationRequest();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }



       //LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,this);
    }
    private void stopLocationUpdate(){
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }}




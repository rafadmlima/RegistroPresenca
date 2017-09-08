package com.example.rafael.registropresenca.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.rafael.registropresenca.view.FuncActivity;
import com.example.rafael.registropresenca.view.LoginActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import me.drakeet.materialdialog.MaterialDialog;
/**
 * Created by RAFAEL on 02/06/2017.
 */
public class Local extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    private Context contexto;
    private GoogleApiClient googleApiClient;
    private LocationManager gps;
    private MaterialDialog mMaterialDialog;
    private boolean isOn;
    private final int REQUEST_PERMISSIONS_CODE = 128;
    public Local(Context contexto) {
        this.contexto = contexto;
        verificarGps();
    }

    public synchronized void callConnection() {
        googleApiClient = new GoogleApiClient.Builder(this.contexto)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i("LOG", "onConnected (" + bundle + ")");
        if (ContextCompat.checkSelfPermission(contexto,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(((FuncActivity)contexto), Manifest.permission.ACCESS_FINE_LOCATION)){
                    callDialog("Autorizar o aplicativo acessar sua Localização", new String[]{Manifest.permission.ACCESS_FINE_LOCATION});
            }else{
                ActivityCompat.requestPermissions(((FuncActivity)contexto), new String[]{Manifest.permission.ACCESS_FINE_LOCATION} , REQUEST_PERMISSIONS_CODE);
            }
        } else {

            Location l = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            if (l != null) {

                DadosUsuario.setCoordenadas(getLatLng(l.getLatitude(), l.getLongitude()));
                // Toast.makeText(this.contexto, "LAT..." + l.getLatitude() + " | LONGI..." + l.getLongitude(), Toast.LENGTH_LONG).show();
                //System.out.println("LAT>>..." + l.getLatitude() + " | LONGI..." + l.getLongitude());
                //Toast.makeText(this.contexto, "TESTE"+ DadosUsuario.getCoordenadas(),Toast.LENGTH_LONG).show();
            }
        }
    }
    private void callDialog(String message, final String[] permissions) {
        mMaterialDialog = new MaterialDialog(this.contexto)
                .setTitle("Permissões")
                .setMessage(message)
                .setPositiveButton("OK",new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(((FuncActivity) contexto), permissions, REQUEST_PERMISSIONS_CODE);
                        mMaterialDialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });
    }

    private String getLatLng(double latitude, double longitude) {
        String latLng = "";
        latLng = String.valueOf(latitude + "," + longitude);
        return latLng;
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended (" + i + ")");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed (" + connectionResult + ")");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        switch (requestCode){
            case REQUEST_PERMISSIONS_CODE:
                for (int i = 0; i < permissions.length; i++){
                    if(permissions[i].equalsIgnoreCase(Manifest.permission.ACCESS_FINE_LOCATION)
                    && grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        verificarGps();
                    }
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void verificarGps() {
        gps = (LocationManager) this.contexto.getSystemService(Context.LOCATION_SERVICE);
        isOn = gps.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isOn) {
            callConnection();
        } else {
            Toast.makeText(this.contexto, "Você precisará ativar o gps do seu aparelho!", Toast.LENGTH_LONG).show();
            this.contexto.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

}

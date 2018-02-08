package com.example.enric.lectorbarras;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Camera;
import android.hardware.camera2.CameraManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;
import android.view.View;
import android.widget.RelativeLayout;

import me.dm7.barcodescanner.core.CameraPreview;
import me.dm7.barcodescanner.core.CameraWrapper;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView escanerView;
    private static final int REQUEST_CAMERA = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escanerView = new ZXingScannerView(this);
        RelativeLayout rl = findViewById(R.id.relative_scan);
        rl.addView(escanerView);
        //setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
        /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.blankFragment, new BlankFragment());
        ft.commit();*/
        //this.escanerView = new CameraPreview(this.getApplicationContext());

    }

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del escaner");
        builder.setMessage(result.getText()+" Formato BAR: "+result.getBarcodeFormat());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
    }

    public void escanerQR(View view) {
        /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.blankFragment, new BlankFragment());
        ft.commit();*/
        /*escanerView = new ZXingScannerView(this);
        RelativeLayout rl = findViewById(R.id.relative_scan);
        rl.addView(escanerView);
        //setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();*/


        /*setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();*/
        escanerView.stopCameraPreview();
        //this.finish();
        setContentView(R.layout.activity_main);
    }
    /*@SuppressLint("NewApi")
    public void startPreview() {
        Camera theCamera = new CameraManager();
        if (theCamera != null && !previewing) {
            theCamera.
            theCamera.setDisplayOrientation(90);
            theCamera.startPreview();
            previewing = true;
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }


}

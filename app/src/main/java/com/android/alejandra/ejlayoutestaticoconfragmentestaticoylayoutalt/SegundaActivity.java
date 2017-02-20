package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.EXTRA_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_visor_webview);

        //recojo la url que me llega desde la otra activity
        String url = getIntent().getStringExtra(EXTRA_URL);

        //obtengo referencia al WebViewFragment
        WebViewFragment wvFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.webFragment);

        if (!wvFragment.getActualUrl().equals(url)) {
            wvFragment.mostrarUrl(url);
        }

    }
}

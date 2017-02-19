package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Sandra on 15/11/2016.
 */
public class WebViewFragment extends Fragment {

    private static final String ID_URL_GUARDADA = "id_url_guardada";
    private String actualUrl = ""; //usado para no recargar una url si está visible en ese momento

    private WebView webView;


    public WebViewFragment() {
    }


    public String getActualUrl() {
        return actualUrl;
    }


    /**
     * Método que mostrará la url que se pasa
     *
     * @param url url a mostrar
     */
    public void mostrarUrl(String url) {

        //actualizo la url actual
        actualUrl = url;

        //obtengo la webview
        webView = (WebView) getView().findViewById(R.id.wvWebPage);
        //activo javascript
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            //cargo la url
            webView.loadUrl(url);

        }
    }


    //MÉTODOS DEL CICLO DE VIDA DEL FRAGMENT

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflo layout
        View v=inflater.inflate(R.layout.web_layout, container, false);
        webView= (WebView) v.findViewById(R.id.wvWebPage);
        return v;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




}

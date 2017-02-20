package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model.LinkData;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener {

    private WebViewFragment wvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //cargo datos de los recursos
        LinkData.inicializarItemsFromResources(getResources().getStringArray(R.array.lista_enlaces_tutoriales_Android),
                getResources().getStringArray(R.array.urls_enlaces_tutoriales_Android));


    }


    @Override
    public void onListFragmentSelection(String tituloElegido) {
        String url = LinkData.ITEM_MAP.get(tituloElegido).getEnlaceContenido();

        wvFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.webFragment);
        if(wvFragment==null){
            //No hay fragment WebViewFragment. Por tanto, estamos en un dispositivo pequeño
            //Lanzamos la otra activity
            Intent i=new Intent(this,SegundaActivity.class);
            i.putExtra(SegundaActivity.EXTRA_URL,url);
            startActivity(i);
        }
        else {
            //muestro la url
            if (!wvFragment.getActualUrl().equals(url))
                wvFragment.mostrarUrl(url);
        }

    }


}

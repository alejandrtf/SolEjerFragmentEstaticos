package com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.alejandra.ejlayoutestaticoconfragmentestaticoylayoutalt.model.LinkData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LinkListFragment.OnListFragmentSelectionListener {

    private WebViewFragment wvFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

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

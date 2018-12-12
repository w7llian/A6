package com.example.w7495.facturacion;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentRealizarPedido.OnFragmentInteractionListener, FragmentHistorialPedidos.OnFragmentInteractionListener, FragmentInicio.OnFragmentInteractionListener, FragmentLogin.OnFragmentInteractionListener, FragmentAgregarProducto.OnFragmentInteractionListener, FragmentPedidoRealizado.OnFragmentInteractionListener, FragmentAgregarDetalle.OnFragmentInteractionListener {

    ListView listView;
    ArrayList<E_Articulos> arrayArticulos;
    AdaptadorTabla adapter;
    Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment fragment = new FragmentInicio();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragmentSeleccionado = false;

        if (id == R.id.nav_camera) {
            miFragment = new FragmentInicio();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_gallery) {
            miFragment = new FragmentRealizarPedido();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_slideshow) {
            miFragment = new FragmentHistorialPedidos();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_manage) {
            miFragment = new FragmentAgregarProducto();
            fragmentSeleccionado = true;
        } else if (id == R.id.nav_share) {
            miFragment = new FragmentLogin();
            fragmentSeleccionado = true;
        }

        if(fragmentSeleccionado == true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

        /*listView = (ListView)findViewById(R.id.list);
        arrayArticulos = new ArrayList<E_Articulos>();

        E_Articulos articulo = new E_Articulos(1,"Juan Perez","12/08/2018",1000.00);
        arrayArticulos.add(articulo);
        articulo = new E_Articulos(2,"Juan Perez","12/08/2018",1000.00);
        arrayArticulos.add(articulo);
        articulo = new E_Articulos(3,"Juan Perez","12/08/2018",1000.00);
        arrayArticulos.add(articulo);

        adapter = new AdaptadorTabla(getApplicationContext(),arrayArticulos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent, View item,int position,long id){
                Toast.makeText(getApplicationContext(),arrayArticulos.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        }); */

    }

}

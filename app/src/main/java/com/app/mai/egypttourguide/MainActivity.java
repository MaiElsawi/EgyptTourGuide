package com.app.mai.egypttourguide;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragmentObject;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("hi", "onCreate");
        fragmentObject = new FragmentMainScreen();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();


        // define drawer layout
        drawer = findViewById(R.id.drawer);

        // define toggle to open drawer
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);

        // add toggle to drawer
        drawer.addDrawerListener(toggle);

        // define navigation viewer
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        super.onSupportActionModeStarted(mode);
    }

    // implement the method to display toggle btn
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_popular:
                fragmentObject = new FragmentMainScreen();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();
                break;
            case R.id.menu_historical:
                fragmentObject = new FragmentHistorical();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();
                break;
            case R.id.menu_green_area:
                fragmentObject = new FragmentGreenArea();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();

                break;
            case R.id.menu_shoping:
                fragmentObject = new FragmentShopping();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();

                break;
            case R.id.menu_mobile_services:
                fragmentObject = new FragmentMobileServices();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentObject).commit();
                break;

            // TODO how to set the another language xml file
            case R.id.menu_language:

                break;
            case R.id.menu_share:
Toast.makeText(this,"under construction",Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_contact:
                Toast.makeText(this,"under construction",Toast.LENGTH_LONG).show();
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

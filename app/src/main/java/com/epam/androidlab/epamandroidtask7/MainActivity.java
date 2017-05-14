package com.epam.androidlab.epamandroidtask7;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "https://loyl.me/wp-content/uploads/2013/08/loyalty500x500.png";

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private DrawerLayout drawerLayout;

    private NavigationView.OnNavigationItemSelectedListener itemSelectedListener = item -> {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.item1:
                fragmentTransaction.replace(R.id.frame, firstFragment);
                break;
            case R.id.item2:
                fragmentTransaction.replace(R.id.frame, secondFragment);
                break;
        }
        drawerLayout.closeDrawers();
        fragmentTransaction.commit();
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(itemSelectedListener);

        drawerLayout.addDrawerListener(new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close){

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(R.string.drawer_close);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.drawer_open);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //     LinearLayout headerLayout= (LinearLayout)navigationView.findViewById(R.id.header);
        //  ImageView imageView = (ImageView)headerLayout.findViewById(R.id.imageView);
        // Picasso.with(this).load(URL).into(imageView);
    }
}

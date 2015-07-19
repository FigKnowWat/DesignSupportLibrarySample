package by.iba_mobile.designsupportlibrarysample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Alex on 19.07.2015.
 */
public class FloatingActionButtonActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);
        setupNavigationView();
        setupToolbar();
        setupFAB();
    }

    private void setupFAB() {
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fabBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.rootLayout), "Great teacher onizuka!", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(FloatingActionButtonActivity.this, "undo", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void setupNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        ((NavigationView) findViewById(R.id.navigation_view)).setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navigation_item_inputtext:
                        startActivity(new Intent().setClass(FloatingActionButtonActivity.this, InputTextActivity.class));
                        FloatingActionButtonActivity.this.finish();
                        break;

                    case R.id.navigation_item_main:
                        startActivity(new Intent().setClass(FloatingActionButtonActivity.this, MainActivity.class));
                        FloatingActionButtonActivity.this.finish();
                        break;

                    case R.id.navigation_item_super_puper_view:
                        startActivity(new Intent().setClass(FloatingActionButtonActivity.this, SuperPuperActivity.class));
                        FloatingActionButtonActivity.this.finish();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

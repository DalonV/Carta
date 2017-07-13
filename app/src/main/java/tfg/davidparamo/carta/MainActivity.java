package tfg.davidparamo.carta;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static tfg.davidparamo.carta.GlobalSettings.isSetNumMesa;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager  pager;
    TabLayout tabLayout;
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
                Intent intent = new Intent(getApplicationContext(), ResumenPedido.class);
                getApplicationContext().startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View nav = navigationView.getHeaderView(0);
        ImageView image = (ImageView) nav.findViewById(R.id.fondonavbar);
        Picasso.with(MainActivity.this).load("https://blobstfg.blob.core.windows.net/config/navImage")
                .into(image, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("BIEN","successfully load the image");
                    }

                    @Override
                    public void onError() {
                        Log.d("Mal","fail to load the image");
                    }
                });

        pager= (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.sliding_tabs);

        FragmentManager manager=getSupportFragmentManager();
        PagerAdapter adapter=new PagerAdapter(manager);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        // mTabLayout.setupWithViewPager(mPager1);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setTabsFromPagerAdapter(adapter);
        if(!isSetNumMesa) lanzarDialogo();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.reciboBar:
                Intent intent = new Intent(this, Recibo.class);
                this.startActivity(intent);
                return true;
                
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_primeros) {
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            tab.select();
        } else if (id == R.id.nav_segundos) {
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(1);
            tab.select();
        } else if (id == R.id.nav_postres) {
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            TabLayout.Tab tab = tabLayout.getTabAt(2);
            tab.select();
        } else if (id == R.id.nav_cuenta) {
            Intent intent = new Intent(this, Recibo.class);
            this.startActivity(intent);
        }
        else if(id == R.id.nav_manage){
            lanzarDialogo();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void irAlCarrito(View view){
        Intent intent = new Intent(this, ResumenPedido.class);
        this.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                }).create().show();
    }

    public void lanzarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Número de mesa");
        builder.setMessage("Introduce el número de la mesa en la que estás sentado");

        float dpi = getApplicationContext().getResources().getDisplayMetrics().density;
        final EditText input = new EditText(this);
        final FrameLayout frame = new FrameLayout(this);
        frame.setPadding((int) (20 * dpi), 0, (int) (20 * dpi), 0);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        frame.addView(input);
        builder.setView(frame);

        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                GlobalSettings.numMesa = Integer.parseInt(input.getText().toString());
                isSetNumMesa = true;
            }
        });

        builder.show();
    }
}

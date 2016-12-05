package com.example.administrator.schoolbus;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private View v1, v2, v3, v4, v5, v6, v7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        v1=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v2=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v3=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v4=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v5=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v6=getLayoutInflater().inflate(R.layout.net_layout, null);
//        v7=getLayoutInflater().inflate(R.layout.login_layout, null);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);  //工具栏
//        setSupportActionBar(toolbar);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(
//                toggle);
//        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater = getMenuInflater();
        return true;
    }

    /**
     * 响应菜单项
     * 重写activity类的 onOptionsItemSelected(MenuItem)回调方法
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
//        switch (item.getItemId()) {
//            case R.id.nav_camera:
//                    setContentView(v1);
//                break;
//            case R.id.nav_gallery:
//                    setContentView(v2);
//                break;
//            case R.id.nav_slideshow:
//                     setContentView(v3);
//                break;
//            case R.id.nav_manage:
//                    setContentView(v4);
//                break;
//            case R.id.nav_share:
//                     setContentView(v5);
//                break;
//            case R.id.nav_send:
//                     setContentView(v6);
//                break;
//            case R.id.nav_exit:
//                     setContentView(v7);
//               break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//             DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//            drawer.closeDrawer(GravityCompat.START);
//        return true;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
//        setContentView(v1);
            Intent intent=new Intent(MainActivity.this,SystemActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
//            setContetView(v2);
            Intent intent=new Intent(MainActivity.this,NetActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
//            setContentView(v3);
            Intent intent=new Intent(MainActivity.this,VideoActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
//            setContentView(v4);
            Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
//            setContentView(v5);
            Intent intent=new Intent(MainActivity.this,DiskActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
//            setContentView(v6);
            Intent intent=new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);
        }
        return true;
       }
}

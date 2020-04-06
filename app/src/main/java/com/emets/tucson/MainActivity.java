package com.emets.tucson;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    Intent intent;
    private int categoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                intent = new Intent(MainActivity.this, TextContentActivity.class);
                intent.putExtra("category", categoryIndex);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        array = getResources().getStringArray(R.array.chapter1_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        adapter.notifyDataSetChanged();
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_chapter1);
        return true;
    }

    private void myStartActivity(){
        intent = new Intent(MainActivity.this, TextContentActivity.class);
        intent.putExtra("category", categoryIndex);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        adapter.clear();
        switch (id){
            case R.id.id_introduction:
                categoryIndex = 0;
                myStartActivity();
                break;
            case R.id.id_chapter1:
                categoryIndex = 1;
                array = getResources().getStringArray(R.array.chapter1_array);
                toolbar.setTitle(R.string.menu_chapter1);
                break;
            case R.id.id_chapter2a:
                categoryIndex = 21;
                myStartActivity();
                break;
            case R.id.id_chapter2b:
                categoryIndex = 22;
                myStartActivity();
                break;
            case R.id.id_chapter2c:
                categoryIndex = 23;
                myStartActivity();
                break;
            case R.id.id_chapter3:
                categoryIndex = 3;
                array = getResources().getStringArray(R.array.chapter3_array);
                toolbar.setTitle(R.string.menu_chapter3);
                break;
            case R.id.id_chapter4:
                categoryIndex = 4;
                myStartActivity();
                break;
            case R.id.id_chapter5:
                categoryIndex = 5;
                array = getResources().getStringArray(R.array.chapter5_array);
                toolbar.setTitle(R.string.menu_chapter5);
                break;
            case R.id.id_chapter6a:
                categoryIndex = 61;
                array = getResources().getStringArray(R.array.chapter6a_array);
                toolbar.setTitle(R.string.menu_chapter6a);
                break;
            case R.id.id_chapter6b:
                categoryIndex = 62;
                array = getResources().getStringArray(R.array.chapter6a_array);
                toolbar.setTitle(R.string.menu_chapter6b);
                break;
            case R.id.id_chapter6c:
                categoryIndex = 63;
                array = getResources().getStringArray(R.array.chapter6a_array);
                toolbar.setTitle(R.string.menu_chapter6c);
                break;
            case R.id.id_chapter7:
                categoryIndex = 7;
                array = getResources().getStringArray(R.array.chapter7_array);
                toolbar.setTitle(R.string.menu_chapter7);
                break;
            case R.id.id_chapter8:
                categoryIndex = 8;
                array = getResources().getStringArray(R.array.chapter8_array);
                toolbar.setTitle(R.string.menu_chapter8);
                break;
            case R.id.id_chapter9:
                categoryIndex = 9;
                array = getResources().getStringArray(R.array.chapter9_array);
                toolbar.setTitle(R.string.menu_chapter9);
                break;
            case R.id.id_chapter10:
                categoryIndex = 10;
                array = getResources().getStringArray(R.array.chapter10_array);
                toolbar.setTitle(R.string.menu_chapter10);
                break;
            case R.id.id_chapter11a:
                categoryIndex = 111;
                array = getResources().getStringArray(R.array.chapter11a_array);
                toolbar.setTitle(R.string.menu_chapter11a);
                break;
            case R.id.id_chapter11b:
                categoryIndex = 112;
                array = getResources().getStringArray(R.array.chapter11b_array);
                toolbar.setTitle(R.string.menu_chapter11b);
                break;
            case R.id.id_chapter11c:
                categoryIndex = 113;
                array = getResources().getStringArray(R.array.chapter11c_array);
                toolbar.setTitle(R.string.menu_chapter11c);
                break;
            case R.id.id_chapter11d:
                categoryIndex = 114;
                array = getResources().getStringArray(R.array.chapter11d_array);
                toolbar.setTitle(R.string.menu_chapter11d);
                break;
            case R.id.id_chapter12:
                categoryIndex = 12;
                array = getResources().getStringArray(R.array.chapter12_array);
                toolbar.setTitle(R.string.menu_chapter12);
                break;
            case R.id.id_chapter13:
                categoryIndex = 13;
                array = getResources().getStringArray(R.array.chapter13_array);
                toolbar.setTitle(R.string.menu_chapter13);
                break;
            case R.id.id_chapter14:
                categoryIndex = 14;
                array = getResources().getStringArray(R.array.chapter14_array);
                toolbar.setTitle(R.string.menu_chapter14);
                break;
            case R.id.id_chapter15:
                categoryIndex = 15;
                array = getResources().getStringArray(R.array.chapter14_array);
                toolbar.setTitle(R.string.menu_chapter14);
                break;
            case R.id.id_chapter16:
                categoryIndex = 16;
                array = getResources().getStringArray(R.array.chapter16_array);
                toolbar.setTitle(R.string.menu_chapter16);
                break;
            case R.id.id_chapter17:
                categoryIndex = 17;
                array = getResources().getStringArray(R.array.chapter17_array);
                toolbar.setTitle(R.string.menu_chapter17);
                break;
            case R.id.id_chapter18:
                categoryIndex = 18;
                array = getResources().getStringArray(R.array.chapter18_array);
                toolbar.setTitle(R.string.menu_chapter14);
                break;
            case R.id.id_chapter19a:
                categoryIndex = 191;
                array = getResources().getStringArray(R.array.chapter19a_array);
                toolbar.setTitle(R.string.menu_chapter19a);
                break;
            case R.id.id_chapter19b:
                categoryIndex = 192;
                array = getResources().getStringArray(R.array.chapter19b_array);
                toolbar.setTitle(R.string.menu_chapter19b);
                break;
            case R.id.id_chapter20:
                categoryIndex = 20;
                array = getResources().getStringArray(R.array.chapter20_array);
                toolbar.setTitle(R.string.menu_chapter20);
                break;
        }
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

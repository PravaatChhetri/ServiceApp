package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.car.ui.toolbar.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class img extends AppCompatActivity {

    ListView imgTxt;
    private ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        img = (ImageView) findViewById(R.id.imageView2);
        txt=(TextView) findViewById(R.id.img_text);
        registerForContextMenu(txt);


    }
         // @Override
          public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                  super.onCreateContextMenu(menu, v, menuInfo);
                  // you can set menu header with title icon etc
                  menu.setHeaderTitle("Select Image to Display");
                  // add menu items
                  menu.add(0, v.getId(), 0, "Image1");
                  menu.add(0, v.getId(), 0, "Image2");
                  menu.add(0, v.getId(), 0, "Image3");
                  menu.add(0,v.getId(),0,"Image4");
              }

              // menu item select listener
              //@Override
    public boolean onContextItemSelected(android.view.MenuItem item){

                  if (item.getTitle() == "Image1") {
                      img.setImageResource(R.drawable.wallpaper3);

                  }
                  else if (item.getTitle() == "Image2") {
                      img.setImageResource(R.drawable.wallpaper4);

                  }
                  else if (item.getTitle() == "Image3") {
                      img.setImageResource(R.drawable.wallpaperflare_com_wallpaper);

                  }
                  else if (item.getTitle() == "Image4") {
                      img.setImageResource(R.drawable.wallpaperflare_com_wallpaper__1_);

                  }
                  return true;
              }
          }





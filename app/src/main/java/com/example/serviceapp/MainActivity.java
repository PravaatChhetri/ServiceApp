package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String txt;

    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView) findViewById(R.id.MyList);
        String data[]={"Message","Map","Image"};
        List<String> dList=new ArrayList<String>(Arrays.asList(data));
        ArrayAdapter<String> adpt=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dList);
        myList.setAdapter(adpt);
        myList.setOnItemClickListener((adapterView, view, i, l) -> {

            String  sctItem=(String) adapterView.getItemAtPosition(i);

            switch (sctItem){
                case "Message": openMsg(view); break;
                case "Map":openMap(view); break;
                case "Image":openImage(view); break;
            }
        });

    }

    public void openMsg(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        startActivity((intent));

    }

        public void openMap(View view) {
            AlertDialog.Builder dBuilder =new AlertDialog.Builder(this);

            dBuilder.setTitle("Enter the Location");
            final EditText locationTxt=new EditText(MainActivity.this);
            locationTxt.setInputType(InputType.TYPE_CLASS_TEXT);
            dBuilder.setView(locationTxt);

            dBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    txt=locationTxt.getText().toString();
                    String loc="https://www.google.com/maps/search/?api=1&query="+txt;
                    Intent map=new Intent(Intent.ACTION_VIEW, Uri.parse(loc));
                    startActivity(map);
                }
            });
            dBuilder.show();

        }

        public void openImage(View view) {
        Intent img= new Intent(this,img.class);
        startActivity(img);
    }


}
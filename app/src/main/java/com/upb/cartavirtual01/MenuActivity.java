package com.upb.cartavirtual01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Declaramos variables

    static String [] Categorias = new String [] {"Platos Fuertes","Entrada", "Bebidas", "Postres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView lv =findViewById(android.R.id.list);

        ListAdapter la = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1,Categorias );

        lv.setAdapter(la);

        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        switch (i){
            case 0:
                Intent intencion0 = new Intent(this, PlatosfuertesActivity.class);
                startActivity(intencion0);
                break;
            case 1:
                Intent intencion1 = new Intent(this, EntradasActivity.class);
                startActivity(intencion1);
                break;
            case 2:
                Intent intencion2 = new Intent(this, BebidasActivity.class);
                startActivity(intencion2);
                break;
            case 3:
                Intent intencion3 = new Intent(this, PostresActivity.class);
                startActivity(intencion3);
                break;
        }
    }
}
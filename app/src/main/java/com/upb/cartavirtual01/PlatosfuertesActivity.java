package com.upb.cartavirtual01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class PlatosfuertesActivity extends AppCompatActivity {

    public class Plato  {

        public String titulo;
        public Integer image;
        public String descripcion="";

        public Plato(String titulo, Integer image) {
            this.titulo = titulo;
            this.image = image;
        }
    }

    private static ArrayList<Plato> l_categorias = new ArrayList<>();
    static ArrayList<String> lString_categorias = new ArrayList<>();
    //static String [] Categorias = new String [] {"Platos Fuertes","Entrada", "Bebidas", "Postres"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platosfuertes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //setData();

        ListView lv =findViewById(android.R.id.list);

        ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lString_categorias);

        lv.setAdapter(la);

        //lv.setOnItemClickListener(this);

    }

    public void setData( ) {

        l_categorias.clear();

        Plato platosFuerte = new Plato(getResources().getString(R.string.catPlatosFuertes), R.drawable.pf1);
        l_categorias.add(platosFuerte);
        lString_categorias.add(l_categorias.get(0).titulo);

        Plato entradas = new Plato(getResources().getString(R.string.catPlatosFuertes), R.drawable.pf1);
        l_categorias.add(entradas);
        lString_categorias.add(l_categorias.get(1).titulo);

        Plato bebidas = new Plato(getResources().getString(R.string.catPlatosFuertes), R.drawable.pf2);
        l_categorias.add(bebidas);
        lString_categorias.add(l_categorias.get(2).titulo);

        Plato postres = new Plato(getResources().getString(R.string.catPlatosFuertes), R.drawable.pf2);
        l_categorias.add(postres);
        lString_categorias.add(l_categorias.get(3).titulo);
    }

    public static class MyAdapter01 extends BaseAdapter {

        private Context mContext;

        public MyAdapter01(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_categorias.size();
        }

        @Override
        public Object getItem(int position) {
            return l_categorias.get(position);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null) {
                // Make up a new view
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.menu_cat_layout, null);
            } else {
                // Use convertView if it is available
                view = convertView;
            }

            // Example to get an image resource
            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(l_categorias.get(position).image));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_categorias.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_categorias.get(position).descripcion);

            return view;

        }
    }
}
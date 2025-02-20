package com.upb.cartavirtual01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import com.upb.cartavirtual01.Clases.Plato;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Declaramos variables

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_categorias = new ArrayList<>();

    //String[] categorias = getResources().getStringArray(R.array.categorias);

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

        /*
        ListView lv =findViewById(android.R.id.list);
        ListAdapter la = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1,Categorias );
        lv.setAdapter(la);
         */

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(myAdapterMenu);

        listView.setOnItemClickListener(this);

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

    public void setData( ) {

        l_categorias.clear();

        Plato platosFuerte = new Plato(
            getResources().getStringArray(R.array.categorias)[0],
            getResources().getStringArray(R.array.categorias)[1],
            R.drawable.pf1
        );
        l_categorias.add(platosFuerte);


        Plato entradas = new Plato(
                getResources().getStringArray(R.array.categorias)[2],
                getResources().getStringArray(R.array.categorias)[3],
            R.drawable.ent01

        );
        l_categorias.add(entradas);

        Plato bebidas = new Plato(
                getResources().getStringArray(R.array.categorias)[4],
                getResources().getStringArray(R.array.categorias)[5],
            R.drawable.beb01
        );
        l_categorias.add(bebidas);

        Plato postres = new Plato(
                getResources().getStringArray(R.array.categorias)[6],
                getResources().getStringArray(R.array.categorias)[7],
            R.drawable.pos01
        );
        l_categorias.add(postres);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
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
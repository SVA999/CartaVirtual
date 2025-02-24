package com.upb.cartavirtual01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upb.cartavirtual01.Clases.Plato;

import java.util.ArrayList;

public class PostresActivity extends AppCompatActivity {

    private MyAdapterPos myAdapter = null;
    private static ArrayList<Plato> l_postres = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setData();

        myAdapter = new MyAdapterPos(this);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(myAdapter);

    }

    public void setData( ) {

        l_postres.clear();
        Plato bebida01 = new Plato(
                getResources().getStringArray(R.array.postres)[0],
                getResources().getStringArray(R.array.postres)[1],
                R.drawable.pos02
        );
        l_postres.add(bebida01);

        Plato bebida02 = new Plato(
                getResources().getStringArray(R.array.postres)[2],
                getResources().getStringArray(R.array.postres)[3],
                R.drawable.pos03
        );
        l_postres.add(bebida02);
    }

    public static class MyAdapterPos extends BaseAdapter {

        private Context mContext;
        public MyAdapterPos(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {

            return l_postres.size();
        }

        @Override
        public Object getItem(int position) {

            return l_postres.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_postres.get(position).image));
            TextView tTitle = (TextView) view.findViewById(R.id.title);
            tTitle.setText(l_postres.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.description);
            Tdescription.setText(l_postres.get(position).descripcion);

            return view;

        }
    }
}
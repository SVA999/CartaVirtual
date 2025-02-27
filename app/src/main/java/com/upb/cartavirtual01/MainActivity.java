package com.upb.cartavirtual01;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void VerSedes (View v){
        Intent i = new Intent(this,SedesActivity.class);
        startActivity(i);

    }

    public void VerMenu (View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);

    }

    public void Reservar (View v){
        //Intent i = new Intent(this,MenuActivity.class);
        //startActivity(i);

        String numeroTelefono = "+573225886403";
        String mensajePredeterminado = "Hola, Quiero reservar una mesa";

        Uri uri = Uri.parse("whatsapp://send?phone=" + numeroTelefono + "&text=" + Uri.encode(mensajePredeterminado));

        //Aqui podemos conectarnos a un proveedor en este caso, llama el paquete de Whatsapp
        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        //Intent i = pm.getLaunchIntentForPackage("com.whatsapp");
        i.setData(uri);
        startActivity(i);

        /*
        List<ResolveInfo> apps = pm.queryIntentActivities(i, 0);
        if (apps.size() > 0) {
            startActivity(i);
        } else {
            // Si WhatsApp no está instalado, puedes mostrar un mensaje al usuario
            Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show();
        }
    */




    }

}
package com.portal.trabajoaplicacion;

import static android.Manifest.permission.CALL_PHONE;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.portal.trabajoaplicacion.databinding.ActivityMainLoginBinding;

public class MainActivityLogin extends AppCompatActivity {
    private ActivityMainLoginBinding binding;
    private MainActivityLoginViewModel mv;
    public Llamada llamada = new Llamada();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityMainLoginBinding.inflate(getLayoutInflater());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityLoginViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        solicitarPermisos();
        registrarBroadcast();

        mv.getMutableIncorrecto().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(MainActivityLogin.this, "usuario y/o...",Toast.LENGTH_LONG).show();

            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.validacion(binding.etUsuario.getText().toString(),binding.etContrasena.getText().toString());

            }
        });




    }
    public void solicitarPermisos(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.N
            && checkSelfPermission(CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE},1000);
        }
    }


    private void registrarBroadcast() {
        this.llamada = new Llamada();
        registerReceiver(llamada, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(llamada);
    }
}

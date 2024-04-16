package com.portal.trabajoaplicacion;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class MainActivityLoginViewModel extends AndroidViewModel {



    private MutableLiveData<Boolean> mutableIncorrecto;

    public MainActivityLoginViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<Boolean> getMutableIncorrecto() {
        if (mutableIncorrecto == null){
            mutableIncorrecto= new MutableLiveData<>();
        }
        return mutableIncorrecto;
    }


    public void validacion(String usuario, String contrasena){
        String usuarioCorrecto = "analuz@gmail.com";
        String contrasenaCorrecta = "123";
        if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);
        }else {
            mutableIncorrecto.setValue(false);
        }

    }


}
package com.portal.trabajoaplicacion.ui.home;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends AndroidViewModel {



    public HomeViewModel(@NonNull Application application) {
        super(application);

    }

    public void llamar (String numero){
        Intent intentLlamada = new Intent(Intent.ACTION_CALL);
        intentLlamada.setData(Uri.parse("tel:" + numero));
        intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intentLlamada);
        }
    }




package com.example.recuperatoriomovi.ui.borrar;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.recuperatoriomovi.MainActivity;
import com.example.recuperatoriomovi.modelo.Inmueble;
import java.util.ArrayList;
import java.util.List;

public class BorrarViewModel extends AndroidViewModel {

    private final List<Inmueble> inmuebles;
    private final MutableLiveData<String> _toastMessage = new MutableLiveData<>();
    public LiveData<String> toastMessage = _toastMessage;
    private MutableLiveData<Inmueble> inmuebleEncontrado;

    public BorrarViewModel(@NonNull Application application) {
        super(application);
        inmuebleEncontrado = new MutableLiveData<>();
        inmuebles = MainActivity.inmuebleArrayList != null ? MainActivity.inmuebleArrayList : new ArrayList<>();
    }

    public LiveData<Inmueble> getMInmueble() {
        return inmuebleEncontrado;
    }

    public LiveData<Inmueble> buscarInmueble(String codigo){
        if (codigo.trim().isEmpty()){
            _toastMessage.setValue("Todos los campos son obligatorios.");
            return inmuebleEncontrado;
        }

        for (Inmueble inmueble : inmuebles){
            if(inmueble.getCodigo().equals(codigo)){
                inmuebleEncontrado.setValue(inmueble);
                return inmuebleEncontrado;
            }
        }

        _toastMessage.setValue("Inmueble no encontrado.");
        return inmuebleEncontrado;
    }

    public void eliminarInmueble(String codigo) {
        for (int i = 0; i < inmuebles.size(); i++) {
            Inmueble inmueble = inmuebles.get(i);
            if (inmueble.getCodigo().equals(codigo)) {
                inmuebles.remove(i); // Elimina el inmueble de la lista usando el índice
                _toastMessage.setValue("Inmueble borrado exitosamente.");
                inmuebleEncontrado.setValue(inmueble);
                return;
            }
        }
    }

}
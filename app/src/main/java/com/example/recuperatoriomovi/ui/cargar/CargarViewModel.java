package com.example.recuperatoriomovi.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.recuperatoriomovi.MainActivity;
import com.example.recuperatoriomovi.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class CargarViewModel extends AndroidViewModel {
    private List<Inmueble> inmuebles;
    private final MutableLiveData<String> _toastMessage = new MutableLiveData<>();
    public LiveData<String> toastMessage = _toastMessage;


    public CargarViewModel(@NonNull Application application) {
        super(application);
        inmuebles = MainActivity.inmuebleArrayList != null ? MainActivity.inmuebleArrayList : new ArrayList<>();
    }


    public boolean AltaInmueble(String codigo, String descripcion, String cantAmbientes, String direccion, String precio) {
        //verificacion
        if (codigo.trim().isEmpty() || descripcion.trim().isEmpty() || cantAmbientes.trim().isEmpty()|| direccion.trim().isEmpty() || precio.trim().isEmpty()) {
            _toastMessage.setValue("Todos los campos son obligatorios.");
            return false;
        }

        // Convertir precio y ambientes
        double precioDouble = Double.parseDouble(precio.replace(".", ","));
        int ambientesInt = Integer.parseInt(cantAmbientes);

        if(ambientesInt>30){
            _toastMessage.setValue("El número en cantidad de ambientes es demasiado grande .");
            return false;
        }

        //verificacion mismo codigo
        for (Inmueble inmueble : inmuebles){
            if(inmueble.getCodigo().equals(codigo)){
                _toastMessage.setValue("Ya existe un inmueble con el mismo código.");
                return false;
            }
        }
        //crear un inmueble y añadirlo al array
        Inmueble nuevoInmueble = new Inmueble(codigo,descripcion, ambientesInt, direccion, precioDouble);
        inmuebles.add(nuevoInmueble);
        _toastMessage.setValue("Inmueble agregado exitosamente");
        return true;
    }
}
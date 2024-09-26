package com.example.recuperatoriomovi.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recuperatoriomovi.R;
import com.example.recuperatoriomovi.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel mViewModel;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        mViewModel.toastMessage.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                // Muestra el Toast con el mensaje recibido desde el ViewModel
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.AltaInmueble(binding.etCodigo.getText().toString(),
                        binding.etDescripcion.getText().toString(),
                        binding.etCantAmb.getText().toString(),
                        binding.etDireccion.getText().toString(),
                        binding.etPrecio.getText().toString()
                        );

                //limpiar código
                binding.etCodigo.setText("");
                binding.etDescripcion.setText("");
                binding.etCantAmb.setText("");
                binding.etDireccion.setText("");
                binding.etPrecio.setText("");
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

}
package com.example.recuperatoriomovi.ui.borrar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recuperatoriomovi.R;
import com.example.recuperatoriomovi.databinding.FragmentBorrarBinding;
import com.example.recuperatoriomovi.modelo.Inmueble;

public class BorrarFragment extends Fragment {
    private FragmentBorrarBinding binding;
    private BorrarViewModel mViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        binding = FragmentBorrarBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        mViewModel.toastMessage.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                // muestra el toast
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });


        mViewModel.getMInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                //setea los datos a visible
                binding.textView8.setVisibility(View.VISIBLE);
                binding.textView9.setVisibility(View.VISIBLE);
                binding.textView10.setVisibility(View.VISIBLE);
                binding.textView11.setVisibility(View.VISIBLE);
                binding.textView12.setVisibility(View.VISIBLE);
                binding.tvDescEncontrada.setText(inmueble.getDescripcion());
                binding.tvCantAmbEncontrada.setText(String.valueOf(inmueble.getCantAmbientes()));
                binding.tvDireccionEncontrada.setText(inmueble.getDireccion());
                binding.tvPrecioEncontrado.setText(String.valueOf(inmueble.getPrecio()));
                binding.tvCodigoEncontrado.setText(inmueble.getCodigo());
                binding.btnBorrar.setVisibility(View.VISIBLE);
            }
        });

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //le pasamos para buscar un inmueble por codigo
                mViewModel.buscarInmueble(binding.etBuscarCod.getText().toString());
            }
        });

        binding.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = binding.etBuscarCod.getText().toString();
                mViewModel.eliminarInmueble(codigo);
                binding.tvDescEncontrada.setText("");
                binding.tvCantAmbEncontrada.setText("");
                binding.tvDireccionEncontrada.setText("");
                binding.tvPrecioEncontrado.setText("");
                binding.tvCodigoEncontrado.setText("");
                binding.etBuscarCod.setText("");
                binding.textView8.setVisibility(View.INVISIBLE);
                binding.textView9.setVisibility(View.INVISIBLE);
                binding.textView10.setVisibility(View.INVISIBLE);
                binding.textView11.setVisibility(View.INVISIBLE);
                binding.textView12.setVisibility(View.INVISIBLE);
                binding.btnBorrar.setVisibility(View.INVISIBLE);
            }
        });

        return root;
    }



}
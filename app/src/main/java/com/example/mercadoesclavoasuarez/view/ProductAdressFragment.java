package com.example.mercadoesclavoasuarez.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mercadoesclavoasuarez.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductAdressFragment extends Fragment {


    public ProductAdressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_adress, container, false);
    }

}

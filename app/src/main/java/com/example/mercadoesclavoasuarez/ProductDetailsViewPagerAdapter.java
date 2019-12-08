package com.example.mercadoesclavoasuarez;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductDetailsViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private final List<String> titleDetailList = new ArrayList<>();


    public ProductDetailsViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
        fragments.add(new ProductDescription());
        fragments.add(new Questions());
        fragments.add(new SellerInfo());
        fragments.add(new RatingsInfo());
        fragments.add(new CharactInfo());

        titleDetailList.add("DESCRIPCION");
        titleDetailList.add("PREGUNTAS");
        titleDetailList.add("VENDEDOR");
        titleDetailList.add("OPINIONES");
        titleDetailList.add("CARACTERISTICAS");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

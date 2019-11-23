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
        fragments.add(CharactInfo)
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

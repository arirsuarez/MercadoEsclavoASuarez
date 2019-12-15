package com.example.mercadoesclavoasuarez;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mercadoesclavoasuarez.view.ProductAdressFragment;
import com.example.mercadoesclavoasuarez.view.ProductLinkFragment;
import com.example.mercadoesclavoasuarez.view.SellerInfo;

public class ProductDetailsViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private final List<String> fragmentTitleList = new ArrayList<>();


    public ProductDetailsViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
        fragments.add(new SellerInfo());
        fragments.add(new ProductLinkFragment());
        fragments.add(new ProductAdressFragment());

        fragmentTitleList.add("SELLER");
        fragmentTitleList.add("LINK");
        fragmentTitleList.add("ADDRESS");
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}

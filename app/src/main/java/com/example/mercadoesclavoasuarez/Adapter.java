package com.example.mercadoesclavoasuarez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.Product;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    private List<Product> productList;


    public Adapter() {
    }

    public Adapter(List<Product> productList) {
        this.productList = productList;
    }

    public void refreshProduct(List<Product> productList){
        this.productList = productList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_cell, parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);

        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductViewHolder productViewHolder = (ProductViewHolder) holder;
        Product product = this.productList.get(position);
        productViewHolder.bind(product);


    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageProduct;
        TextView productName;
        TextView productPrice;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageProduct = itemView.findViewById(R.id.productImageView);
            this.productName = itemView.findViewById(R.id.productNameTextView);
            this.productPrice = itemView.findViewById(R.id.productPriceTextView);
        }

        public void bind(Product unProductPojo) {
            /*this.imageProduct.setImageResource(unProductPojo.getImageProduct());
            this.productName.setText(unProductPojo.getNameProduct());
            this.productPrice.setText(unProductPojo.getPriceProduct())*/;
        }
    }
}

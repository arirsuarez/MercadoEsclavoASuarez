package com.example.mercadoesclavoasuarez.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.model.pojo.Category;
import com.example.mercadoesclavoasuarez.model.pojo.Product;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {

    private List<Product> productList;
    private BoxListener boxListener;


    public Adapter() {
    }

    public Adapter(List<Product> productList, BoxListener boxListener) {
        this.productList = productList;
        this.boxListener = boxListener;
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
            this.productName = itemView.findViewById(R.id.productTitleTextView);
            this.productPrice = itemView.findViewById(R.id.productPriceCellTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product product = productList.get(getAdapterPosition());
                    boxListener.boxPicked(product);
                }
            });
        }

        public void bind(Product product) {

            Glide.with(imageProduct)
                    .load(product.getThumbnail())
                    .into(imageProduct);
            this.productName.setText(product.getTitle());
            this.productPrice.setText(product.getPrice().toString());
            /*this.imageProduct.setImageResource(unProductPojo.getImageProduct());
            this.productName.setText(unProductPojo.getNameProduct());
            this.productPrice.setText(unProductPojo.getPriceProduct())*/;
        }
    }
    public interface BoxListener{
        void boxPicked(Product productPicked);
    }
}

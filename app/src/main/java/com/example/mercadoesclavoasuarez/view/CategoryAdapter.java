package com.example.mercadoesclavoasuarez.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadoesclavoasuarez.HomeActivity;
import com.example.mercadoesclavoasuarez.MainActivity;
import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.model.pojo.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter {

    private List<Category> categoryList;
    BoxListener boxListener;

    public CategoryAdapter() {
    }

    public CategoryAdapter(List<Category> categoryList, BoxListener boxListener) {
        this.categoryList = categoryList;
        this.boxListener = boxListener;
    }

    public void refreshList(List<Category> categoryList){
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.category_cell, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CategoryViewHolder categoryViewHolder = (CategoryViewHolder) holder;
        Category category = this.categoryList.get(position);
        categoryViewHolder.bind(category);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;

        public CategoryViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.categoryName = itemView.findViewById(R.id.categoryNameTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Category category = categoryList.get(getAdapterPosition());
                    boxListener.boxPicked(category);
                }
            });
        }

        public void bind(Category category){
            this.categoryName.setText(category.getName());
        }
    }

    public interface BoxListener{
        void boxPicked(Category category);
    }
}

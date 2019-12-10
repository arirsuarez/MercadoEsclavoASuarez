package com.example.mercadoesclavoasuarez.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadoesclavoasuarez.R;
import com.example.mercadoesclavoasuarez.model.pojo.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter {

    private List<Category> categoryList;

    public CategoryAdapter() {
    }

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
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

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryName = itemView.findViewById(R.id.categoryNameTextView);
        }

        public void bind(Category category){
            this.categoryName.setText(category.getName());
        }
    }
}

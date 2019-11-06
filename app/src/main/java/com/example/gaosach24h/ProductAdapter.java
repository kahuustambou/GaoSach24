package com.example.gaosach24h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaosach24h.ui.listener.ListActionListener;
import com.example.gaosach24h.ui.model.Category;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import java.util.List;

public class ProductAdapter extends ExpandableRecyclerViewAdapter<CompanyViewHolder, ProductViewHolder> implements ListActionListener {

    ListActionListener listActionListener;

    public ProductAdapter(List<? extends ExpandableGroup> groups, ListActionListener listActionListener) {
        super(groups);
        this.listActionListener = listActionListener;
    }

    @Override
    public CompanyViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_rice, parent, false);
        return new CompanyViewHolder(v);
    }

    @Override
    public ProductViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rice, parent, false);
        return new ProductViewHolder(v,this);
    }

    @Override
    public void onBindChildViewHolder(ProductViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Product product = (Product) group.getItems().get(childIndex);
        holder.bind(product);
    }


    @Override
    public void onBindGroupViewHolder(CompanyViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Company company= (Company) group;
        holder.bind(company);
    }


    @Override
    public void cickImtemChid(Long id) {
        listActionListener.cickImtemChid(id);
    }

}

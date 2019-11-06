package com.example.gaosach24h;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class CompanyViewHolder extends GroupViewHolder {
    private TextView mTexView;

    public CompanyViewHolder(View itemView) {

        super(itemView);
        mTexView=itemView.findViewById(R.id.textView);
    }
    public void bind(Company company){
        mTexView.setText(company.getTitle());
    }
}

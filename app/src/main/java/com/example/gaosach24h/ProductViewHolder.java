package com.example.gaosach24h;

import android.view.View;
import android.widget.TextView;

import com.example.gaosach24h.ui.listener.ListActionListener;
import com.example.gaosach24h.ui.model.Category;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {
    private TextView mTextView;

    ListActionListener listActionListener;
    public ProductViewHolder(View itemView, ListActionListener listActionListener) {
        super(itemView);
        this.listActionListener = listActionListener;
       mTextView=itemView.findViewById(R.id.textView);

    }
    public void bind(final Product product){
        mTextView.setText(product.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listActionListener!=null)
                    listActionListener.cickImtemChid(product.getIdCategory());
            }
        });
    }
}

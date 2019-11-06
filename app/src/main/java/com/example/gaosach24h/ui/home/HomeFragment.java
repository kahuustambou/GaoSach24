package com.example.gaosach24h.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gaosach24h.Company;
import com.example.gaosach24h.Main2Activity;
import com.example.gaosach24h.MainAdapter;
import com.example.gaosach24h.Product;
import com.example.gaosach24h.ProductAdapter;
import com.example.gaosach24h.R;
import com.example.gaosach24h.ui.listener.ListActionListener;
import com.example.gaosach24h.ui.model.Category;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.thoughtbot.expandablecheckrecyclerview.listeners.OnCheckChildClickListener;
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements ListActionListener {

    private HomeViewModel homeViewModel;
    private ProductAdapter adapter;
    private ArrayList<Product>gaoProduct;
    Category category;
    RecyclerView recyclerView;
    ArrayList<Company> companies;
    Product product;

//    ListView lvContact;
    ArrayAdapter<String> adapterFirebase;
    String TAG="FIREBASE";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.idCategory.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


         recyclerView= root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        companies= new ArrayList<>();
       gaoProduct= new ArrayList<>();
        product=new Product();
//        gaoProduct.add(new Product("Gạo thơm dẻo","1"));
//        gaoProduct.add(new Product("Gạo thơm xốp","2"));
//        gaoProduct.add(new Product("Gạo ăn kiêng","3"));
//        gaoProduct.add(new Product("Gạo nếp","4"));
//        gaoProduct.add(new Product("Tấm","5"));

        // GridView
        GridView gridView;
        final String[] numberWorg= {"One","Two","Three","Four","Five","Six"};
        int[] numberImage = {R.drawable.arrow, R.drawable.book, R.drawable.cart, R.drawable.book, R.drawable.book,R.drawable.book};

        gridView=root.findViewById(R.id.grid_view);

        MainAdapter mainAdapter= new MainAdapter(getContext(),numberWorg,numberImage);
        gridView.setAdapter(mainAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"You click"+numberWorg[+ position], Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        return root;
    }

    private void loadData() {
        adapterFirebase=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Caregory");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren())
                {
                    Category key=data.getValue(Category.class);
                    product=new Product();
                    product.setName(key.getName());
                    product.setIdCategory(key.getIdCategory());
                    gaoProduct.add(product);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });


        Company gao =new Company("Gạo", gaoProduct);
        companies.add(gao);
        adapter=new ProductAdapter(companies,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void cickImtemChid(Long id) {

    }
}
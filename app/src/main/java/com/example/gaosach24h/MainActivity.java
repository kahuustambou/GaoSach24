package com.example.gaosach24h;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btndangNhap ;

//    ListView lvContact;
//    ArrayAdapter<String> adapter;
//    String TAG="FIREBASE";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
//        lvContact=findViewById(R.idCategory.lvContact);
//        lvContact.setAdapter(adapter);
////lấy đối tượng FirebaseDatabase
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
////Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
//        DatabaseReference myRef = database.getReference("contacts");
////truy suất và lắng nghe sự thay đổi dữ liệu
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                adapter.clear();
////vòng lặp để lấy dữ liệu khi có sự thay đổi trên Firebase
//                for (DataSnapshot data: dataSnapshot.getChildren())
//                {
////lấy key của dữ liệu
//                    String key=data.getKey();
////lấy giá trị của key (nội dung)
//                    String value=data.getValue().toString();
//                    adapter.add(key+"\n"+value);
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//            }
//        });
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndangNhap = (Button) findViewById(R.id.btndangNhap);
        btndangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);


            }

        });
//        RecyclerView recyclerView= findViewById(R.idCategory.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ArrayList<Company> companies= new ArrayList<>();
//        ArrayList<Product>gaoProduct= new ArrayList<>();
//        gaoProduct.add(new Product("Gạo thơm dẻo"));
//        gaoProduct.add(new Product("Gạo thơm xốp"));
//        gaoProduct.add(new Product("Gạo ăn kiêng"));
//        gaoProduct.add(new Product("Gạo nếp"));
//        gaoProduct.add(new Product("Tấm"));
//
//        Company gao =new Company("Gạo", gaoProduct);
//        companies.add(gao);
//        ProductAdapter adapter=new ProductAdapter(companies);
//        recyclerView.setAdapter(adapter);


    }
}

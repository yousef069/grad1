package com.example.yousefgrad;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class onlineDrivers extends AppCompatActivity implements track {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    FirebaseDatabase database,database2;
    DatabaseReference databaseReference,databaseReference2;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String useriid;
    Button taskAdd;
    String searchTitle;
    EditText searchbar;
    ProgressBar progressBar;
adapter adapter;
    LinearLayout layout;
    RecyclerView.LayoutManager layoutManager;
    List<driver> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_drivers);
        progressBar=findViewById(R.id.prog);
        firebaseAuth=FirebaseAuth.getInstance();
        layout=findViewById(R.id.parent_layout);

        useriid=firebaseAuth.getUid();
        intiFirebaseTools();


        intiRecycler();

        getAllContactsWithStream();

    }

    public void intiFirebaseTools() {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("driver");
    }
    private void intiRecycler() {
        recyclerView = findViewById(R.id.recyclerViewLists);
        adapter = new adapter(getApplicationContext(),this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void getAllContactsWithStream() {
        databaseReference.
                addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        modelList.clear();
                        if (dataSnapshot.exists()) {
                            progressBar.setVisibility(View.GONE);
                            layout.setVisibility(View.VISIBLE);
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                                modelList.add(snapshot.getValue(driver.class));
                            }
                            adapter.setResult(modelList);
                        }
                        else
                        {
                            progressBar.setVisibility(View.INVISIBLE);
                            layout.setVisibility(View.VISIBLE);
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                        Log.d("dddddddddd", "onCancelled: " + error.getMessage());
                    }
                });


    }


    @Override
    public void track(driver driver) {
        Intent intent= new Intent(getApplicationContext(),trackdriver.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("driver", driver);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
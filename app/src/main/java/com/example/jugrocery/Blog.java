package com.example.jugrocery;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Blog extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageDetailsAdapter adapter;
    private List<ImageDetails> imageDetailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getResources().getColor(R.color.black), // Change to your desired color
                getResources().getDimensionPixelSize(R.dimen.divider_height), // Change to your desired height
                this // Use your activity or fragment context
        );
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageDetailsList = new ArrayList<>();
        adapter = new ImageDetailsAdapter(this, imageDetailsList);
        recyclerView.setAdapter(adapter);

        // Initialize Firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference booksRef = db.collection("Products");

        // Retrieve data from Firestore
        booksRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot document : task.getResult()) {
                        // Parse data, including the bookName and authorName
                        String title = document.getString("title");
                        String category = document.getString("category");
                        String description = document.getString("description");
                        String amount = document.getString("amount");
                        String avnum = document.getString("avnum");

                        ImageDetails imageDetails = new ImageDetails(title, category, description, amount, avnum);
                        imageDetailsList.add(imageDetails);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle the error
                }
            }
        });
    }
}

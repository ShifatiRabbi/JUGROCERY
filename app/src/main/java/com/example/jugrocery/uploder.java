package com.example.jugrocery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class uploder extends AppCompatActivity {
    private EditText titleEditText, categoryEditText, descriptionEditText, amountEditText, avnumEditText;
    private Button uploadButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploder);

        titleEditText = findViewById(R.id.uptitle);
        categoryEditText = findViewById(R.id.upcategory);
        descriptionEditText = findViewById(R.id.updescription);
        amountEditText = findViewById(R.id.upamount);
        avnumEditText = findViewById(R.id.upavnum);
        uploadButton = findViewById(R.id.uploadButton);

        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });
    }

    private void uploadData() {
        final String title = titleEditText.getText().toString();
        final String category = categoryEditText.getText().toString();
        final String description = descriptionEditText.getText().toString();
        final String amount = amountEditText.getText().toString();
        final String avnum = avnumEditText.getText().toString();

        Map<String, Object> blogData = new HashMap<>();
        blogData.put("title", title);
        blogData.put("category", category);
        blogData.put("description", description);
        blogData.put("amount", amount);
        blogData.put("avnum", avnum);

        db.collection("Products")
                .add(blogData)
                .addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(uploder.this, "Product data uploaded successfully", Toast.LENGTH_SHORT).show();
                        clearFields();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(uploder.this, "Error uploading Product data to Firestore", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearFields() {
        titleEditText.setText("");
        categoryEditText.setText("");
        descriptionEditText.setText("");
        amountEditText.setText("");
        avnumEditText.setText("");
    }
}

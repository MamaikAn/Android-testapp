package com.example.testhtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
    }

    protected void setData() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        new Application(recyclerView, this).main();
    }

    public void showErrorMessage(String message) {
        new AlertDialogFragment().newInstance(message).show(getSupportFragmentManager(), "dialog");
    }
}
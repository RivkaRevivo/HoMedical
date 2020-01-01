package com.example.homedical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

public class Head extends AppCompatActivity {

    private RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclehead);
        new FirebaseDatabasehelper().getMedical(new FirebaseDatabasehelper.DataStatus() {
            @Override
            public void DataisLoaded(List<Medical> medicals, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, Head.this, medicals,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

    }
}

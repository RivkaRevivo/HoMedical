package com.example.homedical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth fAuth;
    Button head;
    Button belly;
    Button back;
    Button thorat;
    Button eyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAuth = FirebaseAuth.getInstance();
        head = (Button)findViewById(R.id.head);
        belly = (Button)findViewById(R.id.belly);
        back = (Button)findViewById(R.id.back);
        thorat = (Button)findViewById(R.id.t);
        eyes = (Button)findViewById(R.id.eyes);
//        head.setOnClickListener((View.OnClickListener) this);
//        belly.setOnClickListener((View.OnClickListener) this);
//        back.setOnClickListener((View.OnClickListener) this);
//        thorat.setOnClickListener((View.OnClickListener) this);
//        eyes.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = fAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {

        } else {
           startActivity(new Intent(MainActivity.this , Login.class));
        }
    }

}

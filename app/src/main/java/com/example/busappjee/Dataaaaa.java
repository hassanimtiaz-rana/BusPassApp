package com.example.busappjee;

import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dataaaaa {
    private static final String TAG = "Dataaaaa"; // Add a TAG variable

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference userRef = database.getReference("TestBusEnroll").child("Hassan");

    public Dataaaaa() {
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                DataClass2 user = dataSnapshot.getValue(DataClass2.class);
                Log.d(TAG, "User data is: " + user);
//                TextView textView = findViewById(R.id.textView);
//                textView.setText(user.username); // or any other field you want to display
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                String S;
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };
        userRef.addValueEventListener(userListener);
    }
}

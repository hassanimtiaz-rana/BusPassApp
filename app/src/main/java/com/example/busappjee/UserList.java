package com.example.busappjee;
import androidx.appcompat.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    private RecyclerView rcv;
    private DatabaseReference reference;
    private MyRAdapter myRAdapter;
    private ArrayList<user> list;
    private ArrayList<user> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        rcv = findViewById(R.id.userList);
        reference = FirebaseDatabase.getInstance().getReference("buyPass");
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        filteredList = new ArrayList<>();
        myRAdapter = new MyRAdapter(this, list);
        rcv.setAdapter(myRAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    user User = dataSnapshot.getValue(user.class);
                    list.add(User);
                }
                myRAdapter.notifyDataSetChanged();
                filter(""); // Call the filter method with an empty query to display the full list initially
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled event
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type Here to Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void filter(String query) {
        filteredList.clear();

        for (user User : list) {
            if (User.getRollNum().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(User);
            }
        }

        myRAdapter.filterList(filteredList);
    }
}

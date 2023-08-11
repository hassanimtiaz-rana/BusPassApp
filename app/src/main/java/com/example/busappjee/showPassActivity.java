package com.example.busappjee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class showPassActivity extends AppCompatActivity {
    DatabaseReference reference;
    TextView route_view, roll_num, phone_num, gen_date, exp_date, dura, name;
    Button del_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pass);
        del_button = findViewById(R.id.delButton);
        name = findViewById(R.id.username_view);
        roll_num = findViewById(R.id.rollnum_view);
        route_view = findViewById(R.id.route_view);
        dura = findViewById(R.id.duration_view);
        gen_date = findViewById(R.id.gen_view);
        exp_date = findViewById(R.id.valid_view);
        String userUsername = getIntent().getStringExtra("username");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("buyPass");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String rollnum = snapshot.child(userUsername).child("rollNum").getValue(String.class);
                    String route = snapshot.child(userUsername).child("route").getValue(String.class);
                    String duration = snapshot.child(userUsername).child("duration").getValue(String.class);
                    String genDate = snapshot.child(userUsername).child("genDate").getValue(String.class);
                    String expDate = snapshot.child(userUsername).child("expireDate").getValue(String.class);

                    name.setText(usernameFromDB);
                    roll_num.setText(rollnum);
                    route_view.setText(route);
                    dura.setText(duration);
                    gen_date.setText(genDate);
                    exp_date.setText(expDate);
                } else {
                    showErrorDialog();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        del_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(userUsername).removeValue();
            }
        });
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(showPassActivity.this);
        LayoutInflater inflater = LayoutInflater.from(showPassActivity.this);
        View view = inflater.inflate(R.layout.error_dialog, null);
        Button errClose = view.findViewById(R.id.errorClose);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        alertDialog.show();

        errClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(showPassActivity.this,Menu.class);
                String userUsername = getIntent().getStringExtra("username");
                intent.putExtra("username", userUsername);
                alertDialog.dismiss();
                Toast.makeText(showPassActivity.this, "Closed", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }
}

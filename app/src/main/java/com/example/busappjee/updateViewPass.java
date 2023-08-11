package com.example.busappjee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateViewPass extends AppCompatActivity {

    EditText edit_username,edit_rollnum,edit_section,edit_phone;
    Button saveButton;
    Spinner edit_dur,edit_route;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_view_pass);

        reference = FirebaseDatabase.getInstance().getReference("buyPass");

        edit_username = findViewById(R.id.edit_username);
        edit_rollnum = findViewById(R.id.edit_rollnum_pass);
        edit_section = findViewById(R.id.edit_section_pass);
        edit_phone = findViewById(R.id.edit_phone_pass);
        saveButton = findViewById(R.id.buy_button);
        edit_dur=findViewById(R.id.edit_duration_pass);
        edit_route=findViewById(R.id.edit_route_pass);




        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRollNumChanged() || isPhoneChanged() || isSectionChanged() || isRouteChanged() || isDurationChanged()){
                    Toast.makeText(updateViewPass.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(updateViewPass.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isRollNumChanged() {

            reference.child(edit_username.getText().toString()).child("rollNum").setValue(edit_rollnum.getText().toString());
            return true;

    }

    private boolean isSectionChanged() {

            reference.child(edit_username.getText().toString()).child("sec").setValue(edit_section.getText().toString());
            return true;

    }


    private boolean isPhoneChanged() {

            reference.child(edit_username.getText().toString()).child("phoneNum").setValue(edit_phone.getText().toString());

            return true;

    }

    private boolean isDurationChanged() {

            reference.child(edit_username.getText().toString()).child("duration").setValue(edit_dur.getSelectedItem().toString());
            return true;

    }
    private boolean isRouteChanged() {

            reference.child(edit_username.getText().toString()).child("route").setValue(edit_route.getSelectedItem().toString());

            return true;

    }



}
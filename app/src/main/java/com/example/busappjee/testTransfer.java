package com.example.busappjee;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class testTransfer extends AppCompatActivity {
    Button testbutton;
    EditText test1,test2;
    Spinner routes,duration;

    DatabaseReference testReference;
    TextView t;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_transfer);


        testbutton=findViewById(R.id.testbutton);
        test1=findViewById(R.id.test1);
        test2=findViewById(R.id.test2);
        routes=findViewById(R.id.busRoutes);
        duration=findViewById(R.id.duration);

        testReference = FirebaseDatabase.getInstance().getReference().child("TestBusEnroll");

        Query query = testReference.orderByChild("testName").equalTo("Hassan");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        DataClass2 obj = snapshot.getValue(DataClass2.class);
                        s=obj.getDuration().toString();
                        // do something with the data object
                        Log.d("TAG", "testName: " + obj.getDuration());
//                        Log.d("TAG", "testEmail: " + obj.getTestEmail());
//                        Log.d("TAG", "testRoute: " + obj.getTestRoute());
//                        Log.d("TAG", "testDuration: " + obj.getTestDuration());
                    }
                } else {
                    // handle no data found
                    Log.d("TAG", "testName: ");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // handle error
                Log.e("Error", "Failed to read value.", databaseError.toException());
            }
        });
        t=findViewById(R.id.textView2);
        t.setText(s);



//        testReference= FirebaseDatabase.getInstance().getReference().child("TestBusEnroll");
//        testbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                saveData();
//            }
//        });
//
//
//    }
//
//    private void saveData() {
//        String name1=test1.getText().toString();
//        String name2=test2.getText().toString();
//        String route=routes.getSelectedItem().toString();
//        String dura=duration.getSelectedItem().toString();
////        Date date= Calendar.getInstance().getTime();
////        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
////        String curr_date=dateFormat.format(dateFormat);
////        String datajee="datajee";
//        DataClass2 obj=new DataClass2(name1,name2,route,dura);
//        testReference.push().setValue(obj);
//        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
    }


}
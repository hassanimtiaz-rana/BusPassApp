package com.example.busappjee;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.busappjee.DataClass2;
import com.example.busappjee.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class eDATA extends AppCompatActivity {

    TextView textViewjee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edata);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        long timestamp = currentDate.getTime();

        textViewjee = findViewById(R.id.textView5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String formattedcurrentDate = dateFormat.format(currentDate);
        //textViewjee.setText(formattedDate);

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, 3); // Increment the date by 3 days
//
//        Date currentDate = calendar.getTime();
//        long timestamp = currentDate.getTime();
//
//        textViewjee = findViewById(R.id.textView5);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
//        String formattedDate = dateFormat.format(currentDate);
//        textViewjee.setText(formattedDate);




    }
}

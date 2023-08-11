package com.example.busappjee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BuyPassActivity extends AppCompatActivity {
    TextView t;

    EditText roll_num, phone_num, section;
    Spinner routes, duration;
    Button button;
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView total_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_pass);
        t = findViewById(R.id.textView6);
        String s = getIntent().getStringExtra("username");
        t.setText(s);

        roll_num = findViewById(R.id.rollnum_pass);
        phone_num = findViewById(R.id.phone_pass);
        section = findViewById(R.id.section_pass);
        routes = findViewById(R.id.route_pass);
        duration = findViewById(R.id.duration_pass);
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        long timestamp = currentDate.getTime();
        button = findViewById(R.id.buy_button);
        total_amount = findViewById(R.id.Total);

        duration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String dur = duration.getSelectedItem().toString();
                if (dur.equals("1Day")) {
                    total_amount.setText("100Rs");
                } else if (dur.equals("2Months")) {
                    total_amount.setText("15000Rs");
                } else {
                    total_amount.setText("30000Rs");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the input values from the text fields
                String roll = roll_num.getText().toString();
                String phone = phone_num.getText().toString();
                String sec = section.getText().toString();
                String rt = routes.getSelectedItem().toString();

                // Check if any of the fields is empty
                if (roll.isEmpty() || phone.isEmpty() || sec.isEmpty()) {
                    // Display an error message or show a toast indicating the fields are empty
                    Toast.makeText(BuyPassActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return; // Exit the method without proceeding
                }

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("buyPass");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
                String formattedcurrentDate = dateFormat.format(currentDate);

                String dur = duration.getSelectedItem().toString();
                String formattedexpDate;
                if (dur.equals("1Day")) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(Calendar.DAY_OF_MONTH, 1); // Increment the date by 1 day
                    Date expDate = calendar2.getTime();
                    long timestamp2 = expDate.getTime();
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd:MM:yyyy");
                    formattedexpDate = dateFormat2.format(expDate);
                    total_amount.setText("100Rs");
                } else if (dur.equals("2Months")) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(Calendar.MONTH, 2); // Increment the date by 2 months
                    Date expDate = calendar2.getTime();
                    long timestamp2 = expDate.getTime();
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd:MM:yyyy");
                    formattedexpDate = dateFormat2.format(expDate);
                    total_amount.setText("15000Rs");
                } else {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.add(Calendar.MONTH, 4); // Increment the date by 4 months
                    Date expDate = calendar2.getTime();
                    long timestamp2 = expDate.getTime();
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd:MM:yyyy");
                    formattedexpDate = dateFormat2.format(expDate);
                    total_amount.setText("30000Rs");
                }
                Toast.makeText(BuyPassActivity.this, "Pass Bought", Toast.LENGTH_SHORT).show();
                DataClass2 obj = new DataClass2(roll, phone, sec, rt, dur, formattedcurrentDate, formattedexpDate, s);
                reference.child(s).setValue(obj);
            }
        });
    }
}

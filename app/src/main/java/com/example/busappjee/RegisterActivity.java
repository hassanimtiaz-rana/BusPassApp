package com.example.busappjee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Console;

public class RegisterActivity extends AppCompatActivity {
    EditText inputEmail, inputPassword, inputConfirmPassword;
    Button btnRegister;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String emailPattern= "[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+" ;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog=new ProgressDialog(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();

            }
        });
    }

    private void PerformAuth() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();
//        if (!email.matches(emailPattern)) {
//            inputEmail.setError("Enter Correct Mail");
//
//        }
//        else
            if (password.isEmpty() || password.length() < 6) {
            inputPassword.setError("Password should be greater than 6");

        } else if (!password.equals(confirmPassword)) {
            inputConfirmPassword.setError("Confirm Password and Password are not same");

        } else {
            progressDialog.setMessage("Hold On We are Registring For you");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();

                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        newActivity();
                    } else {
                        progressDialog.dismiss();

                        Toast.makeText(RegisterActivity.this, "Registration Not Successful", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }

    private void newActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
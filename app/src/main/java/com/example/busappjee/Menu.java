package com.example.busappjee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
//    TextView emailV;
//    Button Buy,viewP,History,viewR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        Intent intent = new Intent("com.example.BROADCAST_MESSAGE");
//        intent.putExtra("message", "Hello, users!");

// Send the broadcast
      //  sendBroadcast(intent);

        //  String email=getIntent().getStringExtra("username");
        //emailV=findViewById(R.id.username_View);

//        Buy=findViewById(R.id.viewbuyPass);
//        viewP=findViewById(R.id.viewCurrentPass);
//        History=findViewById(R.id.history);
//        viewR=findViewById(R.id.routes);
//        emailV.setText(email);

//        Buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Menu.this,showPassActivity.class);
//                intent.putExtra("username",email);
//                startActivity(intent);
//            }
//        });
//        viewP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(Menu.this,BuyPassActivity.class);
//                intent.putExtra("username",email);
//            }
//        });
//        History.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Menu.this,MainImageActivity.class);
//            }
//        });
//        viewR.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Menu.this, MainImageActivity.class);
//                startActivity(intent);
//            }
//        });


    }
    public void onClickBuy(View View)
    {
        String email=getIntent().getStringExtra("username");
        Intent intent=new Intent(this,BuyPassActivity.class);
                intent.putExtra("username",email);
                startActivity(intent);


    }
    public void currentPassClick(View View)
    {
        String email=getIntent().getStringExtra("username");
        Intent intent=new Intent(this,showPassActivity.class);
        intent.putExtra("username",email);
        startActivity(intent);


    }
    public void routesClick(View View)
    {
        Intent intent=new Intent(this,MainImageActivity.class);
        startActivity(intent);



    }
    public void viewdata(View view)
    {
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);

    }
    public void onEdit(View view){
        String name= getIntent().getStringExtra("name");
        String email=getIntent().getStringExtra("email");
        String username= getIntent().getStringExtra("username");
        String password= getIntent().getStringExtra("password");
//        String email=getIntent().getStringExtra("username");
//        Intent intent=new Intent(this,showPassActivity.class);
//        intent.putExtra("username",email);
//        startActivity(intent);
        Intent intent = new Intent(Menu.this, EditProfileActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
    }



}
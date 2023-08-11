package com.example.busappjee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class adminMenu extends AppCompatActivity {
    //    TextView emailV;
//    Button Buy,viewP,History,viewR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
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
      //  String email=getIntent().getStringExtra("username");
        Intent intent=new Intent(this,UploadActivity.class);
      //  intent.putExtra("username",email);
        startActivity(intent);


    }
    public void currentPassClick(View View)
    {
        //String email=getIntent().getStringExtra("username");
        Intent intent=new Intent(this,sendNotification.class);
        //intent.putExtra("username",email);
        startActivity(intent);


    }
    public void routesClick(View View)
    {
        Intent intent=new Intent(this,UserList.class);
        startActivity(intent);



    }
    public void viewdata(View view)
    {
        Intent intent=new Intent(this,updateViewPass.class);
        startActivity(intent);

    }



}
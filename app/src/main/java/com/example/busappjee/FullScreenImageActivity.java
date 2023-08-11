package com.example.busappjee;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FullScreenImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        // Get the image URL from the intent
        String imageUrl = getIntent().getStringExtra("image_url");

        // Load the image using Glide
        ImageView fullScreenImageView = findViewById(R.id.fullScreenImageView);
        Glide.with(this).load(imageUrl).into(fullScreenImageView);
    }
}

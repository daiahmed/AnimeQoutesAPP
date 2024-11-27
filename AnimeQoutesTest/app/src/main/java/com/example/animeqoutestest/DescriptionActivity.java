package com.example.animeqoutestest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_description);

        ImageView imageView = findViewById(R.id.descriptionimageView);
        TextView textView = findViewById(R.id.descriptionTextView);

        String quote = getIntent().getStringExtra("quote");
        int image = getIntent().getIntExtra("image", 0);

        imageView.setImageResource(image);
        textView.setText(quote);
    }
}
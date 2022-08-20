package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticon.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button changeToPreview = findViewById(R.id.previewButton);
        changeToPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityPreview();
            }
        });
    }

    private void changeActivityPreview() {
        Intent intent = new Intent(this, PreviewActivity.class);
        startActivity(intent);
    }
}
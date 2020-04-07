package com.emets.tucson;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {

    private int category = 0;
    private int position = 0;

//    private int[] chapter1Array= {R.string.test_text, R.string.test_text1};
//    private int[] chapter2Array= {R.string.test1_text, R.string.test1_text1};

    private int[] chapter1ImgArray = {R.drawable.tucson, R.drawable.tucson};
    private int[] chapter2ImgArray = {R.drawable.tucson, R.drawable.tucson};

    private TextView textContent;
    private ImageView imageContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.html_content);
        // убрать тулбар
        getSupportActionBar().hide();
//        textContent = findViewById(R.id.text_main_content);
//        imageContent = findViewById(R.id.imageContent);
        receiveIntent();
        getContent();
    }

    private void receiveIntent(){
        Intent intent = getIntent();
        if (intent != null){
            category = intent.getIntExtra("category", 0);
            position = intent.getIntExtra("position", 0);
        }
    }

    private void getContent(){
        switch (category){
            case 0:
                imageContent.setImageResource(chapter1ImgArray[position]);
//                textContent.setText(R.string.text_introducion);
                break;
            case 1:
                imageContent.setImageResource(chapter1ImgArray[position]);
//                textContent.setText(chapter1Array[position]);
                break;
            case 2:
                imageContent.setImageResource(chapter2ImgArray[position]);
//                textContent.setText(chapter2Array[position]);
                break;
        }
    }
}

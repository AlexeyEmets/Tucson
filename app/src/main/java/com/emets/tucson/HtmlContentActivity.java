package com.emets.tucson;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HtmlContentActivity extends AppCompatActivity {

    private WebView webView;
    private String itemHtml;

    private String category = "0";
    private int position = 0;

    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.html_content);
        // убрать тулбар
        getSupportActionBar().hide();
        receiveIntent();
        webView = findViewById(R.id.htmlContent);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        dbHelper = new DBHelper(this);
        itemHtml = dbHelper.getPage(category, position);
        webView.loadDataWithBaseURL("file:///android_asset/", itemHtml, "text/html", "utf-8", null);
    }

    private void receiveIntent(){
        Intent intent = getIntent();
        if (intent != null){
            category = intent.getStringExtra("category");
            position = intent.getIntExtra("position", 0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null){
            webView.destroy();
        }
    }
}

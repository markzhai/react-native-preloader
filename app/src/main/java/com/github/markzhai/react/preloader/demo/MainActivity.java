package com.github.markzhai.react.preloader.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.markzhai.react.preloader.demo.R;
import com.github.markzhai.react.preloader.ReactPreLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReactPreLoader.init(this, DemoReactActivity.reactInfo);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DemoReactActivity.class));
            }
        });
    }
}

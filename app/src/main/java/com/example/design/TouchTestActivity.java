package com.example.design;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.design.customView.BubbleView;

public class TouchTestActivity extends Activity {

    public ListView listView;
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon",
            "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    public BubbleView bubbleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_test);
        initView();
    }

    private void initView() {
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                TouchTestActivity.this, android.R.layout.simple_list_item_1, data);
//        listView = findViewById(R.id.list_item);
//        listView.setAdapter(adapter);
        bubbleView = findViewById(R.id.bubbleView);


    }
}

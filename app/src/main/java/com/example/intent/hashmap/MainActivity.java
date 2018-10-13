package com.example.intent.hashmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private ExpandableListView expandableListView;
private List<String> title = new ArrayList<>();
private Map<String,List<String>> child = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        preparedData();
    }

    private void preparedData() {
        title.add("Dhaka");
        title.add("Khulna");
        title.add("Rajshahi");
        title.add("Noakhali");
        title.add("Barishal");

       List<String> dhaka = new ArrayList<>();
       dhaka.add("formerly known as Dacca");
       dhaka.add("One of the largest cities");
       dhaka.add("Dhaka is not a quiet, retiring place.");
       child.put(title.get(0),dhaka);

        List<String> khulna = new ArrayList<>();
        khulna.add("Khulna is the third-largest city of Bangladesh");
        khulna.add("it is known as the industrial city");
        child.put(title.get(1),khulna);

        List<String> raj = new ArrayList<>();
        raj.add("Rajshahi is a metropolitan city in Bangladesh");
        raj.add("commercial and educational centre of North Bengal.");
        child.put(title.get(2),raj);

        List<String> noa = new ArrayList<>();
        noa.add("Noakhali is a district in South-eastern Bangladesh.");
        noa.add("It is located in the Chittagong Division.");
        child.put(title.get(3),noa);

        List<String> bar = new ArrayList<>();
        bar.add("Barisal, officially known as Barishal");
        bar.add("Barisal is a major city that lies on the bank");
        child.put(title.get(4),bar);


       ELAdapter adapter = new ELAdapter(this,title,child);
       expandableListView.setAdapter(adapter);
    }

    private void initView() {
        expandableListView = findViewById(R.id.MyExpendableList);
    }
}

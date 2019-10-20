package com.example.adminpanel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.myViewPager);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("ADMIN PANEL");



    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new UserFragment(),"User Query");
        viewPagerAdapter.addFragment(new EventFragment(),"Events");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
